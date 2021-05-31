module Numbers.Primes where

import Data.List
-- import Data.List (foldl', \\)

{- |
	Hi, here's your problem today. This problem was recently asked by Amazon:
	
	Given a positive integer n, find all primes less than n.
	
	Here's an example and some starter code:
	
	def find_primes(n):
	  # Fill this in.
	
	print(find_primes(14))
	# [2, 3, 5, 7, 11, 13]
-}

-- The primality test of n can be performed like this:
-- If we find a number between 2 and n − 1 that divides n then n is a composite number. 
-- Otherwise, n is a prime number.
isPrime :: Integral a => a -> Bool
isPrime n = foldl' (\acc x -> if n `mod` x == 0 then False else acc) True [2..n-1] 

testIsPrime01 = isPrime 5 -- True
testIsPrime02 = isPrime 6 -- False

ineffficientPrimesUntilN :: Integral a => a -> [a]
ineffficientPrimesUntilN n = [x | x <- [2..n], isPrime x]
testIneffficientPrimesUntilN01 = ineffficientPrimesUntilN 14
-- [2, 3, 5, 7, 11, 13]

{- |
	Source: Wikipedia
	Sieve of Eratosthenes
	
	To find all the prime numbers less than or equal to a given integer n by Eratosthenes' method:
	
	1. Create a list of consecutive integers from 2 through n: (2, 3, 4, ..., n).
	2. Initially, let p equal 2, the smallest prime number.
	3. Enumerate the multiples of p by counting in increments of p from 2p to n, and mark them in the list (these will be 2p, 3p, 4p, ...; the p itself should not be marked).
	4. Find the smallest number in the list greater than p that is not marked. If there was no such number, stop. Otherwise, let p now equal this new number (which is the next prime), and repeat from step 3.
	5. When the algorithm terminates, the numbers remaining not marked in the list are all the primes below n.
	
	The main idea here is that every value given to p will be prime, because if it were composite, it would be marked as a multiple of some other, smaller prime. Note that some of the numbers may be marked more than once (e.g., 15 will be marked both for 3 and 5).
	
	As a refinement, it is sufficient to mark the numbers in step 3 starting from p^2, as all the smaller multiples of p will have already been marked at that point. This means that the algorithm is allowed to terminate in step 4 when p2 is greater than n.
	
	Another refinement is to initially list odd numbers only, (3, 5, ..., n), and count in increments of 2p from p^2 in step 3, thus marking only odd multiples of p. This actually appears in the original algorithm. This can be generalized with wheel factorization, forming the initial list only from numbers coprime with the first few primes and not just from odds (i.e., numbers coprime with 2), and counting in the correspondingly adjusted increments so that only such multiples of p are generated that are coprime with those small primes, in the first place.
	
	Example
	
	To find all the prime numbers less than or equal to 30, proceed as follows.
	
	First, generate a list of integers from 2 to 30:
	 2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30
	
	The first number in the list is 2; cross out every 2nd number in the list after 2 by counting up from 2 in increments of 2 (these will be all the multiples of 2 in the list):
	 2  3     5     7     9     11    13    15    17    19    21    23    25    27    29   
	
	The next number in the list after 2 is 3; cross out every 3rd number in the list after 3 by counting up from 3 in increments of 3 (these will be all the multiples of 3 in the list):
	 2  3     5     7           11    13          17    19          23    25          29   
	
	The next number not yet crossed out in the list after 3 is 5; cross out every 5th number in the list after 5 by counting up from 5 in increments of 5 (i.e. all the multiples of 5):
	 2  3     5     7           11    13          17    19          23                29   
	
	The next number not yet crossed out in the list after 5 is 7; the next step would be to cross out every 7th number in the list after 7, but they are all already crossed out at this point, as these numbers (14, 21, 28) are also multiples of smaller primes because 7 × 7 is greater than 30. 
	
	The numbers not crossed out at this point in the list are all the prime numbers below 30:
	 2  3     5     7           11    13          17    19          23                29
-}

primesTo :: (Eq a, Num a, Enum a) => a -> [a] 
primesTo m = sieve [2..m]
             where 
             sieve (x:xs) = x : sieve (xs \\ [x,x+x..m])
             sieve [] = []
testPrimesTo14 = primesTo 14

countPrimesTo :: (Eq a, Num a, Enum a) => a -> Int
countPrimesTo m = length $ primesTo m
testCountPrimesTo14 = countPrimesTo 14

