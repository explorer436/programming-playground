-- solve :: [Int] -> [Int] -> Int
solve (n:m:rest) = length 
                    $ filter (\x -> bsGcd `mod` x == 0) 
                    $ takeWhile (<= bsGcd) 
                    $ map (* asLcm) [1..]
    where asLcm = foldl1 lcm as
          bsGcd = foldl1 gcd bs
          as = take n rest
          bs = drop n rest

testSolve01 = solve [2, 3, 2, 4, 16, 32, 96] -- expected result is 3
