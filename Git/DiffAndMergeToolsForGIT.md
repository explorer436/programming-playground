These are various tools that we can use when viewing the differences and to resolve merge conflicts.
This takes a little bit of set-up.
If using the terminal or the default tools for viewing diffs is not comfortable for you, these may help.
If you cannot resolve the merge conflicts either manually or using other tools like vim-fugitive, these tools may help.

--------------------------

'git diff' command shows the differences on the command prompt.  

GIT needs to know that KDiff3 should be used as the preferred diff/merge tool.  For this, we need to make a simple change in the .gitconfig file.  This file can be found under your home directory.

Open the .gitconfig file in your favorite text editor.
It should look something like this :

[core]
	longpaths = true
[user]
	name = Bruce Wayne
	email = bruce.wayne@domain.com
  
  
Add the following lines to the file :  
[merge]
	tool = kdiff3
[diff]
	tool = kdiff3
[mergetool "kdiff3"]
    path = C:/Program Files/KDiff3/kdiff3.exe
    keepBackup = false
    trustExitCode = false
 
[difftool "kdiff3"]
    path = C:/Program Files/KDiff3/kdiff3.exe
    keepBackup = false
    trustExitCode = false
    
The path config property under the mergetool and difftool, should point to the installation path of KDiff3 tool on your machine.    

NOTE: please use forward slash "/" as the path separator even on windows machines.  Using back slash "\" will not work!
The above config tells GIT to use the KDiff3 tool as the external diff/merge tool.

From git bash, type this command to launch kdiff3 : 'git difftool'
GIT will launch the KDiff3 for all the files that have changes since the last commit.

If you feel annoyed about GIT asking your permission for showing the KDiff3 for each changed file, use the following command : 'git difftool -y'

To use KDiff as the merge tool use the following command : 'git mergetool'
Hitting enter will launch the KDiff3 as the merge tool.

KDiff3 shows nice GUI to do the merge easily.  It shows the original file on the leftmost window called "A" or "Base", local file in the middle called "B" or "Local" and remote file in the rightmost window called "C" or "Remote".

--------------------------

If you want to use DiffMerge as the diff and merge tool with git, this is how the git confile should look like : 
[core]
	longpaths = true
[user]
	name = Bruce Wayne
	email = bruce.wayne@domain.com

[merge]
	tool = DiffMerge
[diff]
	tool = DiffMerge
[mergetool "DiffMerge"]
    path = C:/Program Files/SourceGear/Common/DiffMerge/sgdm.exe
    keepBackup = false
    trustExitCode = false
 
[difftool "DiffMerge"]
    path = C:/Program Files/SourceGear/Common/DiffMerge/sgdm.exe
    keepBackup = false
    trustExitCode = false
    
--------------------------

To use diffuse as the merge tool and kdiff3 as the diff tool : 
[core]
	longpaths = true
[user]
	name = Bruce Wayne
	email = bruce.wayne@domain.com

[merge]
	tool = diffuse
[diff]
	tool = kdiff3
[mergetool "diffuse"]
    path = C:/Program Files (x86)/Diffuse/diffuse.exe
    keepBackup = false
    trustExitCode = false
 
[difftool "kdiff3"]
    path = C:/Program Files/KDiff3/kdiff3.exe
    keepBackup = false
    trustExitCode = false

--------------------------
