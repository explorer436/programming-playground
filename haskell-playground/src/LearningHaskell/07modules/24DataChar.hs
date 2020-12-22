import Data.Char
import Data.Function
import Data.List

-- The Data.Char module does what its name suggests.
-- It exports functions that deal with characters.
-- It's also helpful when filtering and mapping over strings because they're just lists of characters.

-- Data.Char exports a bunch of predicates over characters.
-- That is, functions that take a character and 
-- tell us whether some assumption about it is true or false.
-- Here's what they are:

-- isControl checks whether a character is a control character.

-- isSpace checks whether a character is a white-space characters.
-- That includes spaces, tab characters, newlines, etc.

-- isLower checks whether a character is lower-cased.

-- isUpper checks whether a character is upper-cased.

-- isAlpha checks whether a character is a letter.

-- isAlphaNum checks whether a character is a letter or a number.

-- isPrint checks whether a character is printable.
-- Control characters, for instance, are not printable.

-- isDigit checks whether a character is a digit.

-- isOctDigit checks whether a character is an octal digit.

-- isHexDigit checks whether a character is a hex digit.

-- isLetter checks whether a character is a letter.

-- isMark checks for Unicode mark characters.
-- Those are characters that combine with preceding letters to form latters with accents.
-- Use this if you are French.

-- isNumber checks whether a character is numeric.

-- isPunctuation checks whether a character is punctuation.

-- isSymbol checks whether a character is a fancy mathematical or currency symbol.

-- isSeparator checks for Unicode spaces and separators.

-- isAscii checks whether a character falls into the first 128 characters of the Unicode character set.

-- isLatin1 checks whether a character falls into the first 256 characters of Unicode.

-- isAsciiUpper checks whether a character is ASCII and upper-case.

-- isAsciiLower checks whether a character is ASCII and lower-case.

-- All these predicates have a type signature of Char -> Bool.
-- Most of the time you'll use this to filter out strings or something like that.
-- For instance, let's say we're making a program that takes a username and 
-- the username can only be comprised of alphanumeric characters.
-- We can use the Data.List function all in combination with the Data.Char predicates 
-- to determine if the username is alright.

testIsAlphaNum01 = all isAlphaNum "bobby283"  
-- True  
testIsAlphaNum02 = all isAlphaNum "eddy the fish!"  
-- False  

-- In case you don't remember, all takes a predicate and 
-- a list and returns True only if that predicate holds for every element in the list.

-- We can also use isSpace to simulate the Data.List function words.

testWords01 = words "hey guys its me"  
-- ["hey","guys","its","me"]  
testGroupBy01 = groupBy ((==) `on` isSpace) "hey guys its me"
-- ["hey"," ","guys"," ","its"," ","me"]  

-- Hmmm, well, it kind of does what words does but we're left with elements of only spaces.
-- Hmm, whatever shall we do? I know, let's filter that sucker.
testFilterGroupBy01 = 
    filter (not . any isSpace) . groupBy ((==) `on` isSpace) $ "hey guys its me"  
-- ["hey","guys","its","me"]  


-- The Data.Char also exports a datatype that's kind of like Ordering.
-- The Ordering type can have a value of LT, EQ or GT.
-- It's a sort of enumeration.
-- It describes a few possible results that can arise from comparing two elements.
-- The GeneralCategory type is also an enumeration.
-- It presents us with a few possible categories that a character can fall into.
-- The main function for getting the general category of a character is generalCategory.
-- It has a type of generalCategory :: Char -> GeneralCategory.
-- There are about 31 categories so we won't list them all here, 
-- but let's play around with the function.

testGeneralCategory01 = generalCategory ' '  
-- Space  
testGeneralCategory02 = generalCategory 'A'  
-- UppercaseLetter  
testGeneralCategory03 = generalCategory 'a'  
-- LowercaseLetter  
testGeneralCategory04 = generalCategory '.'  
-- OtherPunctuation  
testGeneralCategory05 = generalCategory '9'  
-- DecimalNumber  
testGeneralCategory06 = map generalCategory " \t\nA9?|"  
-- [Space,Control,Control,UppercaseLetter,DecimalNumber,OtherPunctuation,MathSymbol]  

-- Since the GeneralCategory type is part of the Eq typeclass, 
-- we can also test for stuff like generalCategory c == Space.

-- toUpper converts a character to upper-case. 
-- Spaces, numbers, and the like remain unchanged.

-- toLower converts a character to lower-case.

-- toTitle converts a character to title-case. 
-- For most characters, title-case is the same as upper-case.

-- digitToInt converts a character to an Int. 
-- To succeed, the character must be in the ranges '0'..'9', 'a'..'f' or 'A'..'F'.

testDigitToInt01 = map digitToInt "34538"  
-- [3,4,5,3,8]  
testDigitToInt02 = map digitToInt "FF85AB"  
-- [15,15,8,5,10,11]  

-- intToDigit is the inverse function of digitToInt.
-- It takes an Int in the range of 0..15 and converts it to a lower-case character.

testIntToDigit01 = intToDigit 15  
-- 'f'  
testIntToDigit02 = intToDigit 5  
-- '5'  

-- The ord and chr functions convert characters to their corresponding numbers and vice versa:

testOrder01 = ord 'a'  
-- 97  
testChr01 = chr 97  
-- 'a'  
testOrder02 = map ord "abcdefgh"  
-- [97,98,99,100,101,102,103,104] 

-- The difference between the ord values of two characters is equal to 
-- how far apart they are in the Unicode table.

------------------------------------------------------------------------

-- The Caesar cipher is a primitive method of encoding messages by 
-- shifting each character in them by a fixed number of positions in the alphabet.
-- We can easily create a sort of Caesar cipher of our own,
-- only we won't constrict ourselves to the alphabet.

encode :: Int -> String -> String  
encode shift msg = 
    let ords = map ord msg  
        shifted = map (+ shift) ords  
    in  map chr shifted  

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


