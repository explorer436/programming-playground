### Authentication issues

   If you are using a Windows machine and if you are using https method for connecting to Git, and if you need to updated the password for Git, an easy way would be to use Windows Credential Manager. `Control Panel -> Credential Manager -> Windows Credential -> Git` and update the password there.

   If you need to set the username and password, use this command:

  ```
  git remote set-url origin https://<username>:<password>@github.com/<details-about-the-repository>.git
  ```

  $ git pull

  Permission denied (publickey).
  fatal: Could not read from remote repository.
  Please make sure you have the correct access rights and the repository exists.
  A "Permission denied" error means that the server rejected your connection. 

  Resolution 1 : 
  ```
  git remote set-url origin https://n0281526@git.forge.lmig.com/scm/uscm-esales/services-policywriting.git
  ```


  Resolution 2 : 

  If you generated the keys yourself from your client machine, do not forget to add them to the SSH agent using the command "ssh-add".
  Run ssh-add on the client machine, that will add the SSH key to the agent. 

  To figure out where your client's SSH agent is looking for private and public keys, use this command:
  ```
  ssh -vT git@github.com
  ```

  This will show the list of the directories that your computer's SSH agent is looking in for public and private keys.
  If everything looks good with this command, you are pretty much set to push and pull from the remote repositories.

  You can change the protocol that your local repository is using to communicate with the remote repository :
  It can be HTTPS or SSH.
  The issue with using HTTPS URL is, every time you want to push a change, it might ask you for username and password.
  With SSH, you don't have to enter username and password every single time.

  Use these commands to switch between the two :

  1. If you want to use HTTPS

    ```
    git remote set-url origin https://github.com/USERNAME/REPOSITORY.git
    ```

    If you got authentication issues with the GIT console you can try your auth this way:
    ```
    https://<username>:<password>@bitbucket.org/<username>/<repo>.git
    ```

  2. If you want to use SSH

    ```
    git remote set-url origin git@github.com:USERNAME/REPOSITORY.git
    ```

    And then run this:
    
    ```
    ssh-keygen -t rsa -b 4096 -C "explorer436@tutanota.com"
    ```

   (When you're prompted to "Enter a file in which to save the key," 
   press Enter. This accepts the default file location.) Now add this SSH ket to bitbucket server.

   If you want to add an SSH key generated from Git console to the ssh-agent in your computer : 

   You might need to start ssh-agent before you run the ssh-add command: 
   ```
   eval `ssh-agent -s`
   ```
   or
   ```
   eval $(ssh-agent)
   ```

   Add your SSH private key to the ssh-agent using the following command:
   ```
   ssh-add  ~/Downloads/CloudForgeGitSSHKeys/id_rsa
   ```
   (this should point to the location of the private key file)

   If you see the error
   ```
   Permissions 0664 for '/home/explorer436/.ssh/id_rsa' are too open.
   It is required that your private key files are NOT accessible by others.
   This private key will be ignored.
   ```

   fix the permissions by using these:

   Keys need to be only readable by you:
   ```
   chmod 400 ~/.ssh/id_rsa
   ```

   If Keys need to be read-writable by you:
   ```
   chmod 600 ~/.ssh/id_rsa
   ```
   600 appears to be fine as well (in fact better in most cases, because you don't need to change file permissions later to edit it).
