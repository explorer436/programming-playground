Setup your first throw-away project:

$ stack new first-project (if you do not want to specify a resolver)
or
$ stack new --resolver=lts-9.14 first-project
$ cd first-project

Use either stack setup or stack build:

$ stack setup
The last command stack setup may take forever, because it will probably download the GHC compiler and a bunch of core/base libraries. Also, it’s going to take a lot of disk-space (about 2GB+).

OK, before we go too much further, let’s just make sure this fresh project builds:
$ stack build

Pretty straight forward stuff! If everything’s been set up right, we should expect stack exec <project>-exe (corresponding to the executable target in the cabal file) to run the program as it sits now, as described by the Stack quickstart guide to write “someFunc” as output to STDOUT and exit immediately. Let’s make sure:

$ stack exec haskell-restish-todo-exe
someFunc

-------------------------------------------------------------------

Creating custom hs files in your project and working with them:

Create a new file called Throwaway.hs in your project:

Open first-project/src/Throwaway.hs and make sure it has the following contents:

module Throwaway where

addNumbers :: Int
addNumbers = 1 + 2

Now, fire-up GHCi:

$ stack ghci

Main Lib> :l Throwaway
Main> addNumbers
3

Now, make some changes to Throwaway.hs, WITHOUT EXITING GHCi:

module Throwaway where

addNumbers :: Int
addNumbers = 10 + 20
Next, reload these changes in GHCI:

Main> :r
Main> addNumbers
30

That’s the most basic development workflow to follow:

Always start ghci with stack ghci from within your project directory. This will ensure that the correct version of the compiler is used and that your GHCi is aware of the files in your project and the packages that your project depends on.
Load a file in GHCi via :l
Run a function
Change something in the function
Reload the file via :r (There is a difference in the behaviour of :l and :r that you may read about, if you are interested.)
Re-run the function

-------------------------------------------------------------------
