import qualified Data.Char as CH

{- |
    Reference:
    https://www.haskell.org/hugs/pages/libraries/base/Data-Char.html#v%3Aord
    Numeric representations
    ord :: Char -> Int
    The fromEnum method restricted to the type Char.
    chr :: Int -> Char
    The toEnum method restricted to the type Char.

    > Prelude> fromEnum 'a'
    97
-}

-- The Caesar cipher is a primitive method of encoding messages by 
-- shifting each character in them by a fixed number of positions in the alphabet.
-- We can easily create a sort of Caesar cipher of our own,
-- only we won't constrict ourselves to the alphabet.

encode :: Int -> String -> String  
encode shift msg = 
    let ords = map CH.ord msg  
        shifted = map (+ shift) ords  
    in  map CH.chr shifted  

-- Here, we first convert the string to a list of numbers.
-- Then we add the shift amount to each number before 
-- converting the list of numbers back to characters.
-- If you're a composition cowboy, 
-- you could write the body of this function as map (chr . (+ shift) . ord) msg.
-- Let's try encoding a few messages.

testEncode01 = encode 3 "Heeeeey"  
-- "Khhhhh|"  
testEncode02 = encode 4 "Heeeeey"  
-- "Liiiii}"  
testEncode03 = encode 1 "abcd"  
-- "bcde"  
testEncode04 = encode 5 "Marry Christmas! Ho ho ho!"  
-- "Rfww~%Hmwnxyrfx&%Mt%mt%mt&"  

-- That's encoded alright.
-- Decoding a message is basically just shifting it back by 
-- the number of places it was shifted by in the first place.

decode :: Int -> String -> String  
decode shift msg = encode (negate shift) msg  

testDecode01 = encode 3 "Im a little teapot"  
-- "Lp#d#olwwoh#whdsrw"  
testDecode02 = decode 3 "Lp#d#olwwoh#whdsrw"  
-- "Im a little teapot"  
testDecode03 = decode 5 . encode 5 $ "This is a sentence"  
-- "This is a sentence"  
