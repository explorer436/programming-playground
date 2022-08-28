# My notes about using Git

### Commands 

#### Create Repositories

| command                 | description                                            |
| ------------------------| -------------------------------------------------------|
| git init (project name) | Creates a new local repository with the specified name |
| git clone (url)         | downloads a project and its entire version history     |

#### Create feature branch from command line

| command                                                           | description                                            |
| ------------------------------------------------------------------| -------------------------------------------------------|
| git branch -vv                                                    | To find out which remote branch your local branch is tracking, command to give tracking branch |
| git status -sb                                                    | To find out which remote branch your local branch is tracking, command to give tracking branch |
| git remote update                                                 | command to update remote branches     |
| git remote update --prune                                         | command to update remote branches. This will remove all remote branches which you have a local record of, but are no longer actually present on the remote.                                              |
| git branch -m <newname>                                           | To rename the current local branch    |
| git branch (local branch name) -u (remote branch name)            | To point local branch to a different remote branch|
| git branch -a                                                     | command to list all branches          |
| git branch -r                                                     | Remote branches only.                 |
| git branch -l or git branch                                     | Local branches only.                  |


| command                                                           | description                                            |
| ------------------------------------------------------------------| -------------------------------------------------------|
| git checkout -b feature/testFeatureBranch remotes/origin/develop  | To start a feature branch from command line, simply create a new branch from remotes/origin/develop |
| git checkout localBranch1                                         | To find out which remote branch your local branch is tracking |
| git checkout localBranch2                                         | To find out which remote branch your local branch is tracking |
| git status                                                        | To see the status of the local repository |


| command                                                           | description                                            |
| ------------------------------------------------------------------| -------------------------------------------------------|
| git diff filename.txt                                             | command to show changes in a specific file. command to see what you haven't "git add"ed yet |
| git diff --word-diff myfile.txt | Instead of showing you two lines for each change, Git allows you to highlight changes in a line explicitly. (The result is usually colored nicely, the removed part being red and the added text green.)                             |
| git diff --cached myfile.txt    | command to see already "-add" ed changes |

| command                                                           | description                                            |
| ------------------------------------------------------------------| -------------------------------------------------------|
| git add -A or git add .         | To stage all changed files        |
| git add (fileName)              | To stage individual changed files |
| git checkout                    | To copy a file from some other commit to your current working tree. It doesn't automatically commit the file. (Switch branches or restore working tree files)    |
| git checkout fileName           | Command to undo changes to a single file in working directory     |
| git commit -m "commit message"  | To commit with a custom message                                   |
| git stash -u                    | command to undo all changes                                       |
| GIT LOG --ONELINE               | To view recent commit messages                                    |
| git push                        | To push the commits to an upsteam remote branch                   |
| git revert                      | To undo a previous commit. In git, you can't alter or erase an earlier commit. (Actually you can, but it can cause problems.) So instead of editing the earlier commit, revert introduces a new commit that reverses an earlier one. |

When doing a diff on a long line, this can be very helpful but you'll still get a less-like scrolling output that can be unhandy to use. You maybe just want the diff put into your terminal:

```
   `PAGER='' git diff --word-diff myfile.txt`
```

| command                                                           | description                                            |
| ------------------------------------------------------------------| -------------------------------------------------------|
| git reset                                        | To undo changes in your working directory that haven't been comitted yet                            |
| git reset --mixed HEAD file.txt                  | it essentially just takes whatever file.txt looks like in HEAD and puts that in the Index           |
| git reset HEAD~                                  | If you do not want to push your commit to remote branch                                             |
| git reset HEAD~                                  | To undo previous commits that you don't want to push                                                |
| git reset --hard HEAD~                           | (You undid your last commit, all the git adds, and all the work you did in your working directory.) |
| git reset --hard origin/master<remotebranchname> | master branch and 'origin/master' have diverged, how to 'undiverge' branches'                       |
| git reset --soft HEAD~                           | (When you reset back to HEAD~ (the parent of HEAD), you are moving the branch back to where it was without changing the Index (staging area) or Working Directory. You could now do a bit more work and commit again to accomplish basically what git commit --amend would have done. Note that if you run git status now you'll see in green the difference between the Index and what the new HEAD is.) |
| git reset --mixed HEAD~                          | It still undid your last commit, but also unstaged everything. You rolled back to before you ran all your git adds AND git commit. |

| command                                                           | description                                            |
| ------------------------------------------------------------------| -------------------------------------------------------|
| git clean                                                            | To remove local untracked files from the current Git branch |
| git clean -n                                                         | To see which files will be deleted you can use the -n option before you run the actual command |
| git clean -f                                                         | When you are comfortable (because it will delete the files for real!) use the -f option  |
| git clean -f -d or git clean -fd                                     | To remove directories   |
| git clean -f -X or git clean -fX (Note the case difference on the X) | To remove ignored files |
| git clean -f -x or git clean -fx (Note the case difference on the X) | To remove ignored and non-ignored files  |

### Undoing a git push

You need to make sure that no other users of this repository are fetching the incorrect changes or trying to build on top of the commits that you want removed because you are about to rewind history.

Then you need to 'force' push the old reference.

`git push -f origin last_known_good_commit:branch_name`

e.g.

`git push -f origin cc4b63bebb6:alpha-0.3.0`

### Remove last commit from remote git repository

Be careful that this will create an "alternate reality" for people who have already fetch/pulled/cloned from the remote repository.
But in fact, it's quite simple:

```
git reset HEAD^ # remove commit locally
git push origin +HEAD # force-push the new HEAD commit
```

If you want to still have it in your local repository and only remove it from the remote, then you can use:
```
git push origin +HEAD^:<name of your branch, most likely 'master'>
```

### Undo a commit and redo

```
$ git commit -m "Something terribly misguided"              (1)

$ git reset HEAD~                                           (2)

<< edit files as necessary >>                               (3)

$ git add ...                                               (4)

$ git commit -c ORIG_HEAD                                   (5)
```

1. This is what you want to undo
2. This leaves your working tree (the state of your files on disk) unchanged but undoes the commit and leaves the changes you  committed unstaged (so they'll appear as "Changes not staged for commit" in git status, and you'll need to add them again before committing). If you only want to add more changes to the previous commit, or change the commit message1, you could use git reset --soft HEAD~ instead, which is like git reset HEAD~ (where HEAD~ is the same as HEAD~1) but leaves your existing changes staged.
3. Make corrections to working tree files.
4. git add anything that you want to include in your new commit.
5. Commit the changes, reusing the old commit message. reset copied the old head to .git/ORIG_HEAD; commit with -c ORIG_HEAD will open an editor, which initially contains the log message from the old commit and allows you to edit it. If you do not need to edit the message, you could use the -C option.

If the commit you want to fix isn’t the most recent one:

```
   git rebase --interactive $parent_of_flawed_commit (after the git log command, if you want to edit the fifth commit, then enter the name of the sixth commit in this command.)
```
 
If you want to fix several flawed commits, pass the parent of the oldest one of them.

```
   An editor will come up, with a list of all commits since the one you gave.
   Change pick to reword (or on old versions of Git, to edit) in front of any commits you want to fix.
   Once you save, Git will replay the listed commits.
```
 
For each commit you want to reword, Git will drop you back into your editor. For each commit you want to edit, Git drops you into the shell. If you’re in the shell:

```
   Change the commit in any way you like.
   git commit --amend
   git rebase --continue
```

Most of this sequence will be explained to you by the output of the various commands as you go. It’s very easy, you don’t need to memorise it – just remember that git rebase --interactive lets you correct commits no matter how long ago they were.

### Helpful Resources
    
    https://www.atlassian.com/git/tutorials/merging-vs-rebasing 

