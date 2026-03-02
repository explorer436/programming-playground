FROM gcr.io/google.com/cloudsdktool/google-cloud-cli:latest

# Install all system dependencies as ROOT
# Install SSH, dev tools
# Install system dependencies + Build tools for Python
# Zip/Unzip are required by SDKMAN
# Chaining update/install ensures the package index is fresh
RUN apt-get update && apt-get install -y \
    openssh-server \
    git \
    curl \
    zip \
    unzip \
    sudo \
    python3-pip \
    python3-dev \
    build-essential \
    pkg-config \
    libssl-dev && \
    curl -fsSL https://deb.nodesource.com/setup_20.x | bash - && \
    apt-get install -y nodejs && \
    rm -rf /var/lib/apt/lists/*

# 2. Setup developer user, sudo, and GENERATE SSH KEYS
RUN useradd -m -s /bin/bash developer && \
    echo "developer:password123" | chpasswd && \
    echo "developer ALL=(ALL) NOPASSWD:ALL" >> /etc/sudoers && \
    mkdir -p /var/run/sshd && \
    ssh-keygen -A  
    # <--- THIS FIXES THE "NO HOSTKEYS" ERROR

# 3. Switch to the developer user to install SDKMAN Java setup
USER developer
WORKDIR /home/developer

# Install SDKMAN! and Java 21
RUN curl -s "https://get.sdkman.io" | bash && \
    bash -c "source /home/developer/.sdkman/bin/sdkman-init.sh && sdk install java 21.0.8-zulu"

# 3. Set Environment Variables so Java is available globally
ENV SDKMAN_DIR="/home/developer/.sdkman"
ENV JAVA_HOME="$SDKMAN_DIR/candidates/java/current"
ENV PATH="$JAVA_HOME/bin:$SDKMAN_DIR/bin:$PATH"

# 4. Switch back to root for global CLI and Python library installs
USER root    

# Install Gemini Code Assist CLI
# Using npm to install the official @google/gemini-cli
RUN npm install -g @google/gemini-cli

# Upgrade pip first, then install Gemini libraries
# Install Gemini libraries using the bypass flag for Debian/Ubuntu
RUN pip3 install --upgrade pip --break-system-packages && \
    pip3 install --no-cache-dir \
    google-generativeai \
    --break-system-packages

# Ensure the developer user owns their home directory and workspace
RUN chown -R developer:developer /home/developer

# If you are mounting a volume for the workspace, 
# ensure the mount point exists with the right permissions
RUN mkdir -p /home/developer/workspace && chown -R developer:developer /home/developer/workspace

# Auth Configuration (API Key Mode)
# The value for this will be passed via docker-compose.yml
ENV GEMINI_API_KEY=""

# Copy the entrypoint automation script
COPY entrypoint.sh /usr/local/bin/entrypoint.sh
RUN chmod +x /usr/local/bin/entrypoint.sh

EXPOSE 22

# Use the script as the start command
ENTRYPOINT ["/usr/local/bin/entrypoint.sh"] 
