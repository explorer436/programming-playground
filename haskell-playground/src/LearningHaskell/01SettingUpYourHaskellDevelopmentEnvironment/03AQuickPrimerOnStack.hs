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

