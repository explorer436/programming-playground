module MySolutions.BitwiseOperations.DecimalToBinary where


import Data.Bits ( Bits(testBit, xor), FiniteBits(finiteBitSize) )
import GHC.Exts ( IsString(..) )
import Data.Word (Word8)

toBin :: Integral a => a -> [a]
toBin 0 = []
toBin n = reverse (helper n)

helper :: Integral a => a -> [a]
helper 0 = []
helper n = (n `mod` 2) : helper (n `div` 2)


test_toBin_1 :: [Integer]
test_toBin_1 = toBin 5
-- [1,0,1]
