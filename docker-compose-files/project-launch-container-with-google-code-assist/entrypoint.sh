#!/bin/bash
set -e  # Exit on error

# 1. FIX PERMISSIONS IMMEDIATELY
# This ensures that the developer user has full control 
# over their home directory, regardless of how volumes were mounted.
# If we do not have this, we will see errors like the one described below.
# Tool output cleanup failed: EACCES: permission denied, mkdir '/home/developer/.gemini'
# An unexpected critical error occurred:Error: EACCES: permission denied, mkdir '/home/developer/.gemini'
chown -R developer:developer /home/developer
chmod 644 /home/developer/.bashrc

# 1. Load SDKMAN (Since we are root, we point to the developer's path)
# Note: This only loads it for this script's execution context
if [ -f "/home/developer/.sdkman/bin/sdkman-init.sh" ]; then
    source "/home/developer/.sdkman/bin/sdkman-init.sh"
fi

# 2. Persist the Gemini API Key
if [ -n "$GEMINI_API_KEY" ]; then
    echo "Auth: Gemini API Key detected. Configuring environment..."
    
    # We are ROOT here, so we have permission to write directly.
    # We use a check to avoid appending the same line every time the container restarts.
    if ! grep -q "export GEMINI_API_KEY" /home/developer/.bashrc; then
        echo "export GEMINI_API_KEY=\"$GEMINI_API_KEY\"" >> /home/developer/.bashrc
        # Ensure the file stays owned by the developer
        chown developer:developer /home/developer/.bashrc
    fi
    
    echo "Auth: Success. API Key is now persistent for user 'developer'."
else
    echo "Warning: No GEMINI_API_KEY found. SSH sessions may require manual export."
fi

# 3. Start SSH daemon
echo "Starting SSH server on port 22..."

# We use 'exec' so sshd becomes PID 1. 
# This is the correct way to keep the container alive.
exec /usr/sbin/sshd -D