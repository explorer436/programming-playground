CONFIGURE TOOLING :

```
git config --global push.default simple
git config --global user.name "Bruce Wayne"
git config --global user.email explorer436@tutanota.com
git config --system core.longpaths true
git config --global color.ui auto
git config --global core.autocrlf true
```

--------------------------------------------
CREATE REPOSITORIES :

`git init (project name)` - Creates a new local repository with the specified name
`git clone (url)` - downloads a project and its entire version history

--------------------------------------------
CREATE FEATURE BRANCH FROM COMMAND LINE : 

To start a feature branch from command line, simply create a new branch from remotes/origin/develop:

`git checkout -b feature/testFeatureBranch remotes/origin/develop`

--------------------------------------------
`git branch (local branch name) -u (remote branch name)` : To point local branch to a different remote branch

`git branch -m <newname>`  : command to rename the current local branch

Git - Use these comments for check in :

`git status`

`git diff myfile.txt` : command to see what you haven't "git add"ed yet

Instead of showing you two lines for each change, Git allows you to highlight changes in a line explicitly:

`git diff --word-diff myfile.txt`

(The result is usually colored nicely, the removed part being red and the added text green.)

When doing a diff on a long line, this can be very helpful but you'll still get a less-like scrolling output that can be unhandy to use. You maybe just want the diff put into your terminal:

`PAGER='' git diff --word-diff myfile.txt`

`git diff --cached myfile.txt` : command to see already "-add" ed changes

`git add -A` : To add all changed files

`git add (fileName)` : To add individual changed files

`git commit -m "comments - include JIRA id in comments"`

`git commit -m 'USPS-684 MapAddressesToSSMForDeletedAgreementAddressTypes' path/to/my/file.ext` - this is the 
command to git commit a single file/directory

`git push`

`git push <remotename> <commit SHA>:<remotebranchname>`

If it says "Your branch is ahead of 'origin/feature/LifeXXXXXX' by 1 commit" and 
if you want to push your commit to remote branch, use `git push`.
 
If you do not want to push your commit to remote branch, use `git reset HEAD~`

`git revert` : is used to undo a previous commit. In git, you can't alter or erase an earlier commit. 
    (Actually you can, but it can cause problems.) 
    So instead of editing the earlier commit, revert introduces a new commit that reverses an earlier one.
    
`git reset`  : is used to undo changes in your working directory that haven't been comitted yet.

`git checkout` : is used to copy a file from some other commit to your current working tree. 
    It doesn't automatically commit the file. (Switch branches or restore working tree files)

`git checkout fileName` - Command to undo changes to a single file in working directory

`git reset --mixed HEAD file.txt` - it essentially just takes whatever file.txt looks like in HEAD and puts that in the Index

`git reset HEAD~` (to undo previous commits that you don't want to push)

---------------------------------------------------
`git reset --soft HEAD~` (When you reset back to HEAD~ (the parent of HEAD), 
    you are moving the branch back to where it was without changing the Index (staging area) or Working Directory. 
    
You could now do a bit more work and commit again to accomplish basically what git commit --amend would have done. 

Note that if you run git status now you'll see in green the difference between the Index and what the new HEAD is.)
git reset --mixed HEAD~  (It still undid your last commit, but also unstaged everything. 

You rolled back to before you ran all your git adds AND git commit.)
    
---------------------------------------------------
    
`git reset --hard HEAD~`  (You undid your last commit, all the git adds, and all the work you did in your working directory.)

`git reset --hard origin/master<remotebranchname>` : master branch and 'origin/master' have diverged, how to 'undiverge' branches'

---------------------------------------------------

If the names of your local branch and the remote branch are different, you will see this message.

fatal: The upstream branch of your current branch does not match the name of your current branch.

To push to the upstream branch on the remote, use "git push origin HEAD:feature/LifeEventObjectLocks"

To push to the branch of the same name on the remote, 
    use "git push origin feature/SavePropertyQuoteFailureLifeEventObjectLocks"
    
---------------------------------------------------

`git stash -u` : command to undo all changes

`git diff file_name.txt`  : command to show changes in a specific file

`git remote update` : command to update remote branches

`git remote update --prune` : command to update remote branches. This will remove all remote branches which you have a local record of, but are no longer actually present on the remote.

`git branch -a` : command to list all branches

Find out which remote branch a local branch is tracking : 

`git branch -vv` : command to give tracking branch

`git status -sb` : command to give tracking branch


--------------------------------------------
$ git pull

Permission denied (publickey).

fatal: Could not read from remote repository.

Please make sure you have the correct access rights
and the repository exists.

A "Permission denied" error means that the server rejected your connection. 

Resolution 1 : 

`git remote set-url origin https://n0281526@git.forge.lmig.com/scm/uscm-esales/services-policywriting.git`

Resolution 2 : 

If you generated the keys yourself from your client machine, do not forget to add them to the SSH agent using the command "ssh-add".
Run ssh-add on the client machine, that will add the SSH key to the agent. 

To figure out where your client's SSH agent is looking for private and public keys, use this command:
`ssh -vT git@github.com`

This will show the list of the directories that your computer's SSH agent is looking in for public and private keys.
If everything looks good with this command, you are pretty much set to push and pull from the remote repositories.

You can change the protocol that your local repository is using to communicate with the remote repository :
It can be HTTPS or SSH.
The issue with using HTTPS URL is, every time you want to push a change, it might ask you for username and password.
With SSH, you don't have to enter username and password every single time.

Use these commands to switch between the two :

1. `git remote set-url origin https://github.com/USERNAME/REPOSITORY.git` (if you want to use HTTPS)

  If you got authentication issues with the GIT console you can try your auth this way : `https://<username>:<password>@bitbucket.org/<username>/<repo>.git`

2. `git remote set-url origin git@github.com:USERNAME/REPOSITORY.git` (if you want to use SSH)

  ssh-keygen -t rsa -b 4096 -C "explorer436@tutanota.com" (When you're prompted to "Enter a file in which to save the key," 
press Enter. This accepts the default file location.) Now add this SSH ket to bitbucket server.

  If you want to add an SSH key generated from Git console to the ssh-agent in your computer : 
( You might need to start ssh-agent before you run the ssh-add command: eval `ssh-agent -s` or eval $(ssh-agent))
Add your SSH private key to the ssh-agent using the following command : ssh-add  ~/Downloads/CloudForgeGitSSHKeys/id_rsa
(this should point to the location of the private key file)

------------------------------------------------
Undoing a 'git push'

You need to make sure that no other users of this repository are fetching the incorrect changes or trying to build on top of the commits that you want removed because you are about to rewind history.

Then you need to 'force' push the old reference.

`git push -f origin last_known_good_commit:branch_name`

e.g.

`git push -f origin cc4b63bebb6:alpha-0.3.0`

------------------------------------------------
Undo a commit and redo

$ git commit -m "Something terribly misguided"              (1)

$ git reset HEAD~                                           (2)

<< edit files as necessary >>                               (3)

$ git add ...                                               (4)

$ git commit -c ORIG_HEAD                                   (5)

1. This is what you want to undo
2. This leaves your working tree (the state of your files on disk) unchanged but undoes the commit and leaves the changes you  committed unstaged (so they'll appear as "Changes not staged for commit" in git status, and you'll need to add them again before committing). If you only want to add more changes to the previous commit, or change the commit message1, you could use git reset --soft HEAD~ instead, which is like git reset HEAD~ (where HEAD~ is the same as HEAD~1) but leaves your existing changes staged.
3. Make corrections to working tree files.
4. git add anything that you want to include in your new commit.
5. Commit the changes, reusing the old commit message. reset copied the old head to .git/ORIG_HEAD; commit with -c ORIG_HEAD will open an editor, which initially contains the log message from the old commit and allows you to edit it. If you do not need to edit the message, you could use the -C option.

------------------------------------------------

How to remove local untracked files from the current Git branch?

Well, the short answer as per the Git Documents is `git clean`

If you want to see which files will be deleted you can use the -n option before you run the actual command: `git clean -n`

Then when you are comfortable (because it will delete the files for real!) use the -f option: `git clean -f`

Here are some more options for you to delete directories, files, ignored and non-ignored files

* To remove directories, run git clean -f -d or git clean -fd
* To remove ignored files, run git clean -f -X or git clean -fX
* To remove ignored and non-ignored files, run git clean -f -x or git clean -fx

Note the case difference on the X for the two latter commands.

-------------------------------------------------------

Git: See all unpushed commits or commits that are not in another branch
If you need to find out which of your local commits are not on the remote server do this:

`git cherry -v`

The -v option prints out the commit messages. Without it you will see only the SHA1 codes.

You may also compare against another (upstream) branch like that:

`git cherry -v origin/somebranch`

This tool is especially useful when you have a ton of commits after a merge and want to know the commit differences between branches

Once you have the list, use this to see the files that changed in each commit : `git show (COMMIT_HASH)`

-------------------------------------------------------

To view recent commit messages : `git log --oneline`

If the commit you want to fix isn’t the most recent one:

* git rebase --interactive $parent_of_flawed_commit (after the git log command, if you want to edit the fifth commit, then enter the name of the sixth commit in this command.)
 
If you want to fix several flawed commits, pass the parent of the oldest one of them.
 
* An editor will come up, with a list of all commits since the one you gave.
*     Change pick to reword (or on old versions of Git, to edit) in front of any commits you want to fix.
*     Once you save, Git will replay the listed commits.
 
For each commit you want to reword, Git will drop you back into your editor. For each commit you want to edit, Git drops you into the shell. If you’re in the shell:
*     Change the commit in any way you like.
*     git commit --amend
*     git rebase --continue

Most of this sequence will be explained to you by the output of the various commands as you go. It’s very easy, you don’t need to memorise it – just remember that git rebase --interactive lets you correct commits no matter how long ago they were.

-----------------------------------------------------------

https://www.atlassian.com/git/tutorials/merging-vs-rebasing 
