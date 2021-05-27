# haskell-playground

#### Setting up the Haskell project

stack new Playgrond

Add hspec as a dependency in package.yaml

`stack build` to build the application.

`stack exec Playgrond-exe` to run the application

`stack test` to run the tests

To load a single file into ghci, go to that folder in terminal and run `stack ghci`.
After that, load that file into ghci by using `:l FileName`

TODO:
Move all the tests into the test directory. 
That way, the source code will be free of tests and, we will be able to run all the tests using a single command.
Revisit the descriptions in the test files and fix them if necessary.

References:

[The Haskell Tool Stack](https://docs.haskellstack.org/en/stable/README/)

[stack user guide](https://docs.haskellstack.org/en/stable/GUIDE/)
