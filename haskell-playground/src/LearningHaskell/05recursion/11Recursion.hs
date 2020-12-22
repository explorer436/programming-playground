{- |
    Recursion is important to Haskell because 
        unlike imperative languages, 
        you do computations in Haskell 
        by declaring what something is 
        instead of declaring how you get it. 
    That is why there are no while loops or for loops in Haskell 
        and instead we many times have to use recursion to declare what something is.
-}

-------------------------------------------------------------------------
-- The `maximum` function takes a list of things that can be ordered 
-- and returns the biggest of them.
-- Prelude> maximum [1,2,3]
-- 3

maximum' :: (Ord a) => [a] -> a  
maximum' [] = error "maximum of empty list"  
maximum' [x] = x  
maximum' (x:xs)   
        | x > maxTail = x  
        | otherwise = maxTail  
        where maxTail = maximum' xs  

--  We use pattern matching to split a list into a head and a tail.
-- This is a very common idiom when doing recursion with lists, so get used to it.

-- tests
testCustomMaximum01 = maximum' [1,2,3]    


{- |
    Pattern matching goes great with recursion!
    Imperative languages that don't have pattern matching 
        have to make a lot of if else statements to test for edge conditions.
-}

-- An even clearer way to write this function is to use `max`.
-- `max` is a function that takes two numbers and 
-- returns the bigger of them. 

maximum'' :: (Ord a) => [a] -> a  
maximum'' [] = error "maximum of empty list"  
maximum'' [x] = x  
maximum'' (x:xs) = max x (maximum'' xs)  
--tests
testCustomMaximum02 = maximum'' [1,2,3]   

-------------------------------------------------------------------------
{- |
    Note: Num is not a subclass of Ord. 
    That means that what constitutes for a number 
        doesn't really have to adhere to an ordering.
    So that's why we have to specify both the Num and Ord class constraints 
        when doing addition or subtraction and also comparison.
-}
replicate' :: (Num i, Ord i) => i -> a -> [a]  
replicate' n x  
    | n <= 0    = []  
    | otherwise = x:replicate' (n-1) x
--tests
testCustomReplicate01 = replicate' 4 6    

-- We are using guards here instead of patterns because 
-- we're testing for a boolean condition. 
-- If n is less than or equal to 0, return an empty list. 
-- Otherwise return a list that has x as the first element and 
-- then x replicated n-1 times as the tail. 
-- Eventually, the (n-1) part will cause our function to reach the edge condition.

-------------------------------------------------------------------------

take' :: (Num i, Ord i) => i -> [a] -> [a]  
take' n _  
    | n <= 0   = []  
take' _ []     = []  
take' n (x:xs) = x : take' (n-1) xs 

-- tests
testCustomTake01 = take' 3 [5,4,3,2,1]

-------------------------------------------------------------------------

reverse' :: [a] -> [a]  
reverse' [] = []  
reverse' (x:xs) = reverse' xs ++ [x]  

-- tests
testCustomReverse = reverse' [2,3,4]

-------------------------------------------------------------------------

zip' :: [a] -> [b] -> [(a,b)]  
zip' _ [] = []  
zip' [] _ = []  
zip' (x:xs) (y:ys) = (x,y):zip' xs ys 

--tests
testCustomZip = zip' ["smart", "hardworking"] ["bruce", "wayne"]
-- [("smart","bruce"),("hardworking","wayne")]

-------------------------------------------------------------------------

elem' :: (Eq a) => a -> [a] -> Bool  
elem' a [] = False  
elem' a (x:xs)  
    | a == x    = True  
    | otherwise = a `elem'` xs

-------------------------------------------------------------------------

-- Take a look at Quicksort.hs

-------------------------------------------------------------------------
