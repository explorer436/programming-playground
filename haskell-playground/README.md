# haskell-playground

#### Setting up the Haskell project

stack new Playgrond

Add hspec as a dependency in package.yaml

`stack build` to build the application.

`stack exec Playgrond-exe` to run the application

`stack test` to run the tests

To load a single file into ghci, go to that folder in terminal and run `stack ghci`.
After that, load that file into ghci by using `:l FileName`
