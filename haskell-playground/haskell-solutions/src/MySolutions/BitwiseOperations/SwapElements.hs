module MySolutions.BitwiseOperations.SwapElements (swapElements) where

import Data.Bits

swapElements a b = (x, y)
    let combinedbits = a xor b
        x = combinedbits xor b
        y = combinedbits xor a
