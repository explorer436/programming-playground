{-# LANGUAGE InstanceSigs #-}
module MySolutions.BitwiseOperations.MyBits where

import Data.List (foldl', unfoldr)

-- from https://wiki.haskell.org/Library_for_binary

data Bit = Zero | One deriving (Eq)

instance Show Bit where
  showsPrec :: Int -> Bit -> ShowS
  showsPrec _ (Zero) = ("+0+"++)
  showsPrec _ (One)  = ("+1+"++)
  showList :: [Bit] -> ShowS
  showList ls st = "*" ++ map bit_to_character ls ++ "*" ++ st

bit_to_integer :: (Integral i) => Bit -> i
bit_to_integer Zero = 0
bit_to_integer One  = 1

bit_to_boolean :: Bit -> Bool
bit_to_boolean = (One ==)

bit_to_character :: Bit -> Char
bit_to_character Zero = '0'
bit_to_character One  = '1'

bit_from_integer :: (Integral i) => i -> Bit
bit_from_integer 0 = Zero
bit_from_integer 1 = One
bit_from_integer _ = error "bit_from_integer: Invalid integer."

bit_from_boolean :: Bool -> Bit
bit_from_boolean b = if b then One else Zero

bit_from_character :: Char -> Bit
bit_from_character '0' = Zero
bit_from_character '1' = One
bit_from_character _   = error "bit_from_character: Invalid character."


type Bits = [Bit]

bits_trim :: [Bit] -> [Bit]
bits_trim  = dropWhile (Zero ==)

bits_pad :: Int -> [Bit] -> [Bit]
bits_pad n = reverse . take n . (++ repeat Zero) . reverse

bits_to_string :: [Bit] -> [Char]
bits_to_string   = map bit_to_character

bits_from_string :: [Char] -> [Bit]
bits_from_string = map bit_from_character

bits_from_integer :: (Integral i) => i -> Bits
bits_from_integer = reverse . unfoldr (\n -> if n == 0 then Nothing else Just (bit_from_integer $ n `mod` 2, n `div` 2)) . positive

bits_to_integer :: (Integral i) => Bits -> i
bits_to_integer = foldl' (\n b -> 2*n + bit_to_integer b) 0

bits_inc :: [Bit] -> [Bit]
bits_inc  = reverse . work . reverse where   -- Next binary integer
  work [] = [One]
  work (Zero : bs) = One  : bs
  work (One  : bs) = Zero : (work bs)

bits_next :: [Bit] -> [Bit]
bits_next = reverse . work . reverse where   -- Next (balanced) tree address
  work [] = [Zero]
  work (Zero : bs) = One  : bs
  work (One  : bs) = Zero : (work bs)


positive :: (Ord p, Num p) => p -> p
positive n = if n < 0 then error "Negative argument." else n

test_bits_from_integer_01 = bit_from_integer 1