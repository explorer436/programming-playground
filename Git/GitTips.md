
# Table of Contents

1.  [Configure Tooling](#orgf0d8af1)
2.  [Commands](#orgc4ef20d)
    1.  [Create Repositories](#orgc878b21)
    2.  [Create feature branch from command line](#org1c26b87)
3.  [Undoing a git push](#org8fa5ca4)
4.  [Undo a commit and redo](#org4c806aa)
5.  [Authentication issues](#org4747aac)
6.  [Helpful Resources](#org1b5306c)


<a id="orgf0d8af1"></a>

# Configure Tooling

    git config --global push.default simple
    git config --global user.name "Bruce Wayne"
    git config --global user.email explorer436@tutanota.com
    git config --global merge.conflictstyle diff3
    git config --system core.longpaths true
    git config --global color.ui auto
    git config --global core.autocrlf true

What is "merge.conflictStyle"? Specify the style in which conflicted hunks are written out to working tree files upon merge. The default is "merge", which shows a <<<<<<< conflict marker, changes made by one side, a `=====` marker, changes made by the other side, and then a >>>>>>> marker. An alternate style, "diff3", adds a ||||||| marker and the original text before the `=====` marker.

---


<a id="orgc4ef20d"></a>

# Commands


<a id="orgc878b21"></a>

## Create Repositories

<table border="2" cellspacing="0" cellpadding="6" rules="groups" frame="hsides">


<colgroup>
<col  class="org-left" />

<col  class="org-left" />
</colgroup>
<tbody>
<tr>
<td class="org-left">git init (project name)</td>
<td class="org-left">Creates a new local repository with the specified name</td>
</tr>


<tr>
<td class="org-left">git clone (url)</td>
<td class="org-left">downloads a project and its entire version history</td>
</tr>
</tbody>
</table>

---


<a id="org1c26b87"></a>

## Create feature branch from command line

<table border="2" cellspacing="0" cellpadding="6" rules="groups" frame="hsides">


<colgroup>
<col  class="org-left" />

<col  class="org-left" />
</colgroup>
<tbody>
<tr>
<td class="org-left">git branch -vv</td>
<td class="org-left">To find out which remote branch your local branch is tracking, command to give tracking branch</td>
</tr>


<tr>
<td class="org-left">git status -sb</td>
<td class="org-left">To find out which remote branch your local branch is tracking, command to give tracking branch</td>
</tr>
</tbody>
</table>

<table border="2" cellspacing="0" cellpadding="6" rules="groups" frame="hsides">


<colgroup>
<col  class="org-left" />

<col  class="org-left" />
</colgroup>
<tbody>
<tr>
<td class="org-left">git remote update</td>
<td class="org-left">command to update remote branches</td>
</tr>


<tr>
<td class="org-left">git remote update &#x2013;prune</td>
<td class="org-left">command to update remote branches. This will remove all remote branches which you have a local record of, but are no longer actually present on the remote.</td>
</tr>
</tbody>
</table>

<table border="2" cellspacing="0" cellpadding="6" rules="groups" frame="hsides">


<colgroup>
<col  class="org-left" />

<col  class="org-left" />
</colgroup>
<tbody>
<tr>
<td class="org-left">git branch -m &lt;newname&gt;</td>
<td class="org-left">To rename the current local branch</td>
</tr>


<tr>
<td class="org-left">git branch (local branch name) -u (remote branch name)</td>
<td class="org-left">To point local branch to a different remote branch</td>
</tr>


<tr>
<td class="org-left">git branch -a</td>
<td class="org-left">command to list all branches</td>
</tr>


<tr>
<td class="org-left">git branch -r</td>
<td class="org-left">Remote branches only.</td>
</tr>


<tr>
<td class="org-left">git branch -l or `git branch`</td>
<td class="org-left">Local branches only.</td>
</tr>
</tbody>
</table>

<table border="2" cellspacing="0" cellpadding="6" rules="groups" frame="hsides">


<colgroup>
<col  class="org-left" />

<col  class="org-left" />
</colgroup>
<tbody>
<tr>
<td class="org-left">git checkout -b feature/testFeatureBranch remotes/origin/develop`</td>
<td class="org-left">To start a feature branch from command line, simply create a new branch from remotes/origin/develop</td>
</tr>


<tr>
<td class="org-left">git checkout localBranch1</td>
<td class="org-left">To find out which remote branch your local branch is tracking,</td>
</tr>


<tr>
<td class="org-left">git checkout localBranch2</td>
<td class="org-left">To find out which remote branch your local branch is tracking,</td>
</tr>
</tbody>
</table>

<table border="2" cellspacing="0" cellpadding="6" rules="groups" frame="hsides">


<colgroup>
<col  class="org-left" />

<col  class="org-left" />
</colgroup>
<tbody>
<tr>
<td class="org-left">git status</td>
<td class="org-left">To see the status of the local repository</td>
</tr>


<tr>
<td class="org-left">git diff filename.txt</td>
<td class="org-left">command to show changes in a specific file. command to see what you haven't "git add"ed yet</td>
</tr>


<tr>
<td class="org-left">git diff &#x2013;word-diff myfile.txt</td>
<td class="org-left">Instead of showing you two lines for each change, Git allows you to highlight changes in a line explicitly. (The result is usually colored nicely, the removed part being red and the added text green.)</td>
</tr>


<tr>
<td class="org-left">git diff &#x2013;cached myfile.txt</td>
<td class="org-left">command to see already "-add" ed changes</td>
</tr>


<tr>
<td class="org-left">git add -A` or `git add .`</td>
<td class="org-left">To stage all changed files</td>
</tr>


<tr>
<td class="org-left">git add (fileName)`</td>
<td class="org-left">To stage individual changed files</td>
</tr>


<tr>
<td class="org-left">git checkout</td>
<td class="org-left">To copy a file from some other commit to your current working tree. It doesn't automatically commit the file. (Switch branches or restore working tree files)</td>
</tr>


<tr>
<td class="org-left">git checkout fileName</td>
<td class="org-left">Command to undo changes to a single file in working directory</td>
</tr>


<tr>
<td class="org-left">git commit -m "commit message"</td>
<td class="org-left">To commit with a custom message</td>
</tr>


<tr>
<td class="org-left">git stash -u</td>
<td class="org-left">command to undo all changes</td>
</tr>


<tr>
<td class="org-left">GIT LOG &#x2013;ONELINE</td>
<td class="org-left">To view recent commit messages</td>
</tr>


<tr>
<td class="org-left">git push</td>
<td class="org-left">To push the commits to an upsteam remote branch</td>
</tr>


<tr>
<td class="org-left">git revert</td>
<td class="org-left">To undo a previous commit. In git, you can't alter or erase an earlier commit. (Actually you can, but it can cause problems.) So instead of editing the earlier commit, revert introduces a new commit that reverses an earlier one.</td>
</tr>
</tbody>
</table>

When doing a diff on a long line, this can be very helpful but you'll still get a less-like scrolling output that can be unhandy to use. You maybe just want the diff put into your terminal:

    `PAGER='' git diff --word-diff myfile.txt`

<table border="2" cellspacing="0" cellpadding="6" rules="groups" frame="hsides">


<colgroup>
<col  class="org-left" />

<col  class="org-left" />
</colgroup>
<tbody>
<tr>
<td class="org-left">git reset</td>
<td class="org-left">To undo changes in your working directory that haven't been comitted yet</td>
</tr>


<tr>
<td class="org-left">git reset &#x2013;mixed HEAD file.txt</td>
<td class="org-left">it essentially just takes whatever file.txt looks like in HEAD and puts that in the Index</td>
</tr>


<tr>
<td class="org-left">git reset HEAD~</td>
<td class="org-left">If you do not want to push your commit to remote branch</td>
</tr>


<tr>
<td class="org-left">git reset HEAD~</td>
<td class="org-left">To undo previous commits that you don't want to push</td>
</tr>


<tr>
<td class="org-left">git reset &#x2013;hard HEAD~</td>
<td class="org-left">(You undid your last commit, all the git adds, and all the work you did in your working directory.)</td>
</tr>


<tr>
<td class="org-left">git reset &#x2013;hard origin/master&lt;remotebranchname&gt;</td>
<td class="org-left">master branch and 'origin/master' have diverged, how to 'undiverge' branches'</td>
</tr>


<tr>
<td class="org-left">git reset &#x2013;soft HEAD~</td>
<td class="org-left">(When you reset back to HEAD~ (the parent of HEAD), you are moving the branch back to where it was without changing the Index (staging area) or Working Directory. You could now do a bit more work and commit again to accomplish basically what git commit &#x2013;amend would have done. Note that if you run git status now you'll see in green the difference between the Index and what the new HEAD is.)</td>
</tr>


<tr>
<td class="org-left">git reset &#x2013;mixed HEAD~</td>
<td class="org-left">It still undid your last commit, but also unstaged everything. You rolled back to before you ran all your git adds AND git commit.</td>
</tr>
</tbody>
</table>

<table border="2" cellspacing="0" cellpadding="6" rules="groups" frame="hsides">


<colgroup>
<col  class="org-left" />

<col  class="org-left" />
</colgroup>
<tbody>
<tr>
<td class="org-left">git clean</td>
<td class="org-left">To remove local untracked files from the current Git branch</td>
</tr>


<tr>
<td class="org-left">git clean -n</td>
<td class="org-left">To see which files will be deleted you can use the -n option before you run the actual command</td>
</tr>


<tr>
<td class="org-left">git clean -f</td>
<td class="org-left">When you are comfortable (because it will delete the files for real!) use the -f option</td>
</tr>


<tr>
<td class="org-left">git clean -f -d or git clean -fd</td>
<td class="org-left">To remove directories</td>
</tr>


<tr>
<td class="org-left">git clean -f -X or git clean -fX (Note the case difference on the X)</td>
<td class="org-left">To remove ignored files</td>
</tr>


<tr>
<td class="org-left">git clean -f -x or git clean -fx (Note the case difference on the X)</td>
<td class="org-left">To remove ignored and non-ignored files</td>
</tr>
</tbody>
</table>

---

GIT: SEE ALL UNPUSHED COMMITS OR COMMITS THAT ARE NOT IN ANOTHER BRANCH

<table border="2" cellspacing="0" cellpadding="6" rules="groups" frame="hsides">


<colgroup>
<col  class="org-left" />

<col  class="org-left" />
</colgroup>
<tbody>
<tr>
<td class="org-left">git cherry -v</td>
<td class="org-left">If you need to find out which of your local commits are not on the remote server do this. The -v option prints out the commit messages. Without it you will see only the SHA1 codes.</td>
</tr>


<tr>
<td class="org-left">git cherry -v origin/somebranch</td>
<td class="org-left">You may also compare against another (upstream) branch like that. This tool is especially useful when you have a ton of commits after a merge and want to know the commit differences between branches</td>
</tr>


<tr>
<td class="org-left">git show (COMMIT<sub>HASH</sub>)</td>
<td class="org-left">Once you have the list from the command above, use this to see the files that changed in each commit</td>
</tr>
</tbody>
</table>

---


<a id="org8fa5ca4"></a>

# Undoing a git push

You need to make sure that no other users of this repository are fetching the incorrect changes or trying to build on top of the commits that you want removed because you are about to rewind history.

Then you need to 'force' push the old reference.

    `git push -f origin last_known_good_commit:branch_name`

e.g.

    `git push -f origin cc4b63bebb6:alpha-0.3.0`

---


<a id="org4c806aa"></a>

# Undo a commit and redo

    $ git commit -m "Something terribly misguided"              (1)
    
    $ git reset HEAD~                                           (2)
    
    << edit files as necessary >>                               (3)
    
    $ git add ...                                               (4)
    
    $ git commit -c ORIG_HEAD                                   (5)

1.  This is what you want to undo
2.  This leaves your working tree (the state of your files on disk) unchanged but undoes the commit and leaves the changes you  committed unstaged (so they'll appear as "Changes not staged for commit" in git status, and you'll need to add them again before committing). If you only want to add more changes to the previous commit, or change the commit message1, you could use git reset &#x2013;soft HEAD~ instead, which is like git reset HEAD~ (where HEAD~ is the same as HEAD~1) but leaves your existing changes staged.
3.  Make corrections to working tree files.
4.  git add anything that you want to include in your new commit.
5.  Commit the changes, reusing the old commit message. reset copied the old head to .git/ORIG<sub>HEAD</sub>; commit with -c ORIG<sub>HEAD</sub> will open an editor, which initially contains the log message from the old commit and allows you to edit it. If you do not need to edit the message, you could use the -C option.

---

If the commit you want to fix isn’t the most recent one:

    git rebase --interactive $parent_of_flawed_commit (after the git log command, if you want to edit the fifth commit, then enter the name of the sixth commit in this command.)

If you want to fix several flawed commits, pass the parent of the oldest one of them.

    An editor will come up, with a list of all commits since the one you gave.
    Change pick to reword (or on old versions of Git, to edit) in front of any commits you want to fix.
    Once you save, Git will replay the listed commits.

For each commit you want to reword, Git will drop you back into your editor. For each commit you want to edit, Git drops you into the shell. If you’re in the shell:

    Change the commit in any way you like.
    git commit --amend
    git rebase --continue

Most of this sequence will be explained to you by the output of the various commands as you go. It’s very easy, you don’t need to memorise it – just remember that git rebase &#x2013;interactive lets you correct commits no matter how long ago they were.

---


<a id="org4747aac"></a>

# Authentication issues

If you need to set the username and password, use this command:

    git remote set-url origin https://<username>:<password>@github.com/<details-about-the-repository>.git

$ git pull

Permission denied (publickey).
fatal: Could not read from remote repository.
Please make sure you have the correct access rights and the repository exists.
A "Permission denied" error means that the server rejected your connection. 

Resolution 1 : 

    git remote set-url origin https://n0281526@git.forge.lmig.com/scm/uscm-esales/services-policywriting.git

Resolution 2 : 

If you generated the keys yourself from your client machine, do not forget to add them to the SSH agent using the command "ssh-add".
Run ssh-add on the client machine, that will add the SSH key to the agent. 

To figure out where your client's SSH agent is looking for private and public keys, use this command:

    ssh -vT git@github.com

This will show the list of the directories that your computer's SSH agent is looking in for public and private keys.
If everything looks good with this command, you are pretty much set to push and pull from the remote repositories.

You can change the protocol that your local repository is using to communicate with the remote repository :
It can be HTTPS or SSH.
The issue with using HTTPS URL is, every time you want to push a change, it might ask you for username and password.
With SSH, you don't have to enter username and password every single time.

Use these commands to switch between the two :

1.  If you want to use HTTPS
    
        git remote set-url origin https://github.com/USERNAME/REPOSITORY.git
    
    If you got authentication issues with the GIT console you can try your auth this way:
    
        https://<username>:<password>@bitbucket.org/<username>/<repo>.git

2.  If you want to use SSH
    
        git remote set-url origin git@github.com:USERNAME/REPOSITORY.git
    
    And then run this:
    
        ssh-keygen -t rsa -b 4096 -C "explorer436@tutanota.com"
    
    (When you're prompted to "Enter a file in which to save the key," 
    press Enter. This accepts the default file location.) Now add this SSH ket to bitbucket server.
    
    If you want to add an SSH key generated from Git console to the ssh-agent in your computer : 
    
    You might need to start ssh-agent before you run the ssh-add command: 
    
        eval `ssh-agent -s` or eval $(ssh-agent)
    
    Add your SSH private key to the ssh-agent using the following command:
    
        ssh-add  ~/Downloads/CloudForgeGitSSHKeys/id_rsa
    
    (this should point to the location of the private key file)

---


<a id="org1b5306c"></a>

# Helpful Resources

<https://www.atlassian.com/git/tutorials/merging-vs-rebasing> 

