import Data.Char (toUpper)

{- |
    Pangram
    Write a function to determine if a given string is a pangram. 
    A pangram is defined as a sentence that uses every letter of the alphabet at least once. 
    It is allowed to use some letters more than once, 
    but it must use every letter at least once. For example:

    -- This is pangram. Notice that it uses 'o', 't', 'h', 'e' more than once.

    The quick brown fox jumps over the lazy dog
    More pangrams for testing your code:

    Pack my box with five dozen liquor jugs
    We promptly judged antique ivory buckles for the next prize
    Sixty zippers were quickly picked from the woven jute bag
    Sphinx of black quartz: judge my vow
-}

{- |
pangram :: Foldable t => t Char -> Bool
pangram input 
    | (length (charactersThatAreNotInTheSentence input) > 0)  = False
    | otherwise = True

charactersThatAreNotInTheSentence :: Foldable t => t Char -> [Char]
charactersThatAreNotInTheSentence input = [c | c <- ['a'..'z'], c `notElem` input && (toUpper c) `notElem` input]
charactersThatAreNotInTheSentenceTest = charactersThatAreNotInTheSentence "Sphinx of black quartz: judge my vow"    
-}

-- `and` takes a list of boolean values 
-- and returns True only if all the values in the list are True.

pangram :: Foldable t => t Char -> Bool
pangram input = and $ (map (doesCharacterExistInString input) ['a'..'z'])

doesCharacterExistInString input c
    | (c `elem` input || (toUpper c) `elem` input) = True
    | otherwise = False


-- tests    
pangramTest01 = pangram "The quick brown fox jumps over the lazy dog"                 -- True
pangramTest02 = pangram "test"                                                        -- False
pangramTest03 = pangram "Pack my box with five dozen liquor jugs"                     -- True
pangramTest04 = pangram "We promptly judged antique ivory buckles for the next prize" -- True
pangramTest05 = pangram "Sixty zippers were quickly picked from the woven jute bag"   -- True
pangramTest06 = pangram "Sphinx of black quartz: judge my vow"                        -- True
