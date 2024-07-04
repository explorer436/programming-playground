module MySolutions.BitwiseOperations.SwapElements where


import Data.Bits
import GHC.Exts ( IsString(..) )
import Data.Word (Word8)

import MySolutions.BitwiseOperations.DecimalToBinary (toBin)    
import qualified MySolutions.BitwiseOperations.MyBits as M


swapElements a b = (b, a)
