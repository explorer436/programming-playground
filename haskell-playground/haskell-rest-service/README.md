# haskell-rest-service

Install Stack.
Install GHC

$stack new haskell-rest-service

$cd haskell-rest-service: 
$stack setup
The stack setup will download the compiler if necessary in an isolated location (default ~/.stack) that won't interfere with any system-level installations. (For information on installation paths, please use the stack path command.).

Install dependencies and build project
$stack build

Run project
$stack exec haskell-rest-service-exe

------------------------

(You might have a global ghc pkg list that has incorrect versions of packages and stack might try to use it and this will result in problems. In order to verify this, call ghc-pkg list and see what shows up.)
Ideally, we should not run into this issue if we do "stack setup" and update the dependencies in the correct location in package.yaml

------------------------

If you are choosing cabal instead of stack, use these. I used stack for dependency management.
cabal update
cabal install
cabal run

------------------------

Scope for building up on the functionality:

https://adit.io/posts/2013-04-15-making-a-website-with-haskell.html
http://taylor.fausak.me/2014/10/21/building-a-json-rest-api-in-haskell/
https://github.com/eckyputrady/haskell-scotty-realworld-example-app
https://vadosware.io/post/rest-ish-services-in-haskell-part-1/ (and part-2 and part-3)
https://github.com/scotty-web/scotty/wiki/Scotty-Tutorials-&-Examples

