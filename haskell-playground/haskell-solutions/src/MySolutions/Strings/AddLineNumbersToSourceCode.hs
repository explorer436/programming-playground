module MySolutions.Strings.AddLineNumbersToSourceCode where

{- |
    Source: https://www.haskelltutorials.com/without-theory/lambdas.html

    Add line numbers to source code
    Write a function that accepts lines-of-code, represented as a list of Strings, and return a new list where each line-of-code is pre-fixed with the line number?
    
    prefixLineNumbers :: [String] -> [String]
    prefixLineNumbers = _todo
    
    -- prefixLineNumbers
    --  [ "module Main where"
    --  , ""
    --  , "increment :: Int -> Int"
    --  , "increment x = x + 1"
    --  ]
    --
    -- OUTPUT:
    -- [ "1: module Main where"
    -- , "2: "
    -- , "3: increment :: Int -> Int"
    -- , "4: increment x = x + 1" ]
    First write it using only functions and recursion and if-then-else.
    Write it using map. Is it possible? If not, why?
    Write it using foldl'
    Write it using zip
    Write it using zipWith
-}


