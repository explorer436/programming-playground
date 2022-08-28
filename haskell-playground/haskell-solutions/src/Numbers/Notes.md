Find out the reason for the following error and figure out how to solve it.

/home/explorer436/Downloads/GitRepositories/programming-playground/haskell-playground/test/Datastructures/Trees/FindAllDuplicateSubtreesSpec.hs:13:35: error:
    • Ambiguous type variable ‘a20’ arising from the literal ‘1’
      prevents the constraint ‘(Num a20)’ from being solved.
      Probable fix: use a type annotation to specify what ‘a20’ should be.
      These potential instances exist:
        instance Num Integer -- Defined in ‘GHC.Num’
        instance Num Double -- Defined in ‘GHC.Float’
        instance Num Float -- Defined in ‘GHC.Float’
        ...plus two others
        ...plus two instances involving out-of-scope types
        (use -fprint-potential-instances to see them all)
    • In the first argument of ‘Node’, namely ‘1’
      In the first argument of ‘findDuplicateSubtrees’, namely
        ‘(Node
            1
            (Node 2 (Node 3 EmptyTree EmptyTree) EmptyTree)
            (Node 2 (Node 3 EmptyTree EmptyTree) EmptyTree))’
      In the first argument of ‘shouldBe’, namely
        ‘findDuplicateSubtrees
           (Node
              1
              (Node 2 (Node 3 EmptyTree EmptyTree) EmptyTree)
              (Node 2 (Node 3 EmptyTree EmptyTree) EmptyTree))’
   |        
13 |       findDuplicateSubtrees (Node 1
   |                                   ^
            
Progress 1/2

--  While building package haskell-playground-0.1.0.0 (scroll up to its section to see the error) using:
      /home/explorer436/.stack/setup-exe-cache/x86_64-linux-tinfo6/Cabal-simple_mPHDZzAJ_3.0.1.0_ghc-8.8.4 --builddir=.stack-work/dist/x86_64-linux-tinfo6/Cabal-3.0.1.0 build lib:haskell-playground exe:haskell-playground-exe test:haskell-playground-test --ghc-options " -fdiagnostics-color=always"
    Process exited with code: ExitFailure 1