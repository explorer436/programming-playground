module RailFenceCipher where

import qualified StripASetOfCharactersFromAString as SSCFS

{- |
    Rail Fence Cipher
    The Rail Fence cipher is a form of transposition cipher 
    that gets its name from the way in which it is encoded. 
    It was used by the ancient Greeks. 
    In the Rail Fence cipher, 
    the message is written downwards on successive “rails” of an imaginary fence, 
    then moving up when we get to the bottom (like a zig-zag). 
    Finally the message is then read off in rows.

    For example, using three “rails” and the message “WE ARE DISCOVERED FLEE AT ONCE”, the cipherer writes out:

    1 | W . . . E . . . C . . . R . . . L . . . T . . . E  --> Reads off as "WECRLTE"
    2 | . E . R . D . S . O . E . E . F . E . A . O . C .  --> Reads off as "ERDSOEEFEAOC"
    3 | . . A . . . I . . . V . . . D . . . E . . . N . .  --> Reads off as "AIVDEN"

    The final encoded message is:
    WECRLTEERDSOEEFEAOCAIVDEN

    Write a function that encodes a given string using the Rails Fence Cipher.
-}
