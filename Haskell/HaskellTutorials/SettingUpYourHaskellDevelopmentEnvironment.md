https://www.haskelltutorials.com

https://www.haskelltutorials.com/without-theory/basic-types-and-functions.html

Setting up your Haskell development environment

----------------------------

Pre-requisities

Serious Haskell projects (not textbook problems) are memory-guzzlers during development & compilation. So, it won’t be long before your system starts swapping, which is why it’s better to have an SSD along with a lot of RAM. For serious Haskell development, we recommend at least 10 GB of RAM and at least 256 GB SSD. For text-book practice, you can probably get away with 4GB of RAM and an HDD.

----------------------------

Installing Haskell

There are currently four ways to install Haskell! Here’s what they are:

Via your OS’ native package manager, i.e. apt-get, or homebrew, or yum
Via a minimal installer or the Haskell Platform
Via Stack - https://haskell-lang.org/get-started (recommended)
Via Nix/NixOS

Recommendation
Out of the four methods listed above, only Stack is recommended for maintaining your sanity. So, head over to Stack’s Get Started page and follow only the first step, titled “Download Haskell Stack” for your OS. The other steps given on that page are covered in greater detail below.

----------------------------

Quick primer on Stack

(stack --version)

stack solves the following problems:

Having different versions of the Haskell compiler (i.e. ghc) available on your machine without messing things up, and using the right ghc version for your project.
Taking care of which Haskell libraries are known to compile/build with which version of ghc.
Taking care of the dependency graph of libraries, so that all the libraries that your project depends on, compile successfully without you having to manually specify the version of each library. Basically stack saves you from the dependency hell problem.
In a sense stack is similar to the following tools from other ecosystems, which attempt to solve some, or all, of the same problems (but they may have solved them in a different manner):

rvm and bundler from the Ruby world
virtualenv from the Python world
gvm from the Go world
nvm or yarn from the NodeJS world

----------------------------

Setup your first throw-away project:

$ stack new --resolver=lts-9.14 first-project
$ cd first-project
$ stack setup

The last command stack setup may take forever, becuase it will probably download the GHC compiler and a bunch of core/base libraries. Also, it’s going to take a lot of disk-space (about 2GB+).

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

----------------------------

Make sure you are reading the correct docs

You will find yourself referring to API documentation very often. However, do not search for the package names on Google and start reading docs from there. You will end-up in a world of pain without even realising it. Google doesn’t know which version of the package you’re using, and from a first-hand experience, things change a lot between versions.

So, here’s what you should do:

Check which LTS/resolver you are on – it’ll be the very first setting in your project’s stack.yaml file.
Go to the Stackage homepage (https://www.stackage.org/) and find the listing page for your LTS/resolver. For example, here’s the listing for lts-9.17 (https://www.stackage.org/lts-9.17)
Search for documentation and packages only from this page

----------------------------


Hackage vs Stackage & Cabal vs Stack

Strangely, Haskell has two widely used package repositories. Here is how they are conceptually different and why both exist:

Hackage (http://hackage.haskell.org/) is the original package repository. This is where authors upload their packages to share them with the world.

Stackage (https://www.stackage.org/) pulls specific versions of specific packages from Hackage and divides them into “sets” known as “snapshots”. Each snapshot contains only a single version of any package with a guarantee that all the packages in a given snapshot will successfully build when included in a project. That is, you will not get a dependency hell when your project depends on 5 packages from the same Stackage snapshot. (If you go to a snapshot/LTS’ listing page you can verify that there is only one version of each package listed there. On the other hand, if you check the same package on Hackage, you will see all versions of the package listed there).

Hackage has way more packages than Stackage, because, not every author adds their package to the Stackage snapshot. This is probably because, every time a new LTS/snapshot is released, package-authors have to do some extra work to maintain the “no dependeny-hell guaranteee”. However, most popular/important packages have already been added to Stackage, so you won’t be missing any packages till you start doing advanced Haskell stuff.

The command-line tool called cabal does not know about Stackage and pulls packages directly from Hackage. Also, cabal+Hackage do not give this “no dependency-hell guarantee” that stack+Stackage works very hard to maintain.

The command-line tool called stack pulls packages from Stackage, by default. Having said that, it can pull packages from Hackage if a particular package is not available in its snapshot (but this requires a few extra lines of config).

Finally, lot of cabal/Hackage lovers hate stack/Stackage and vice-versa. If you are in the mood for some gossip you can search the interwebs and read some flamewars. One hopes, that at some point in the future, the best parts of stack/Stackage and cabal/Hackage can be merged to build a unified, kickass build-tool. Till that day comes, just use Stack.

----------------------------
