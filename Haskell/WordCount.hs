-- file: ch01/WordCount.hs
-- lines beginning with "--" are comments.


-- To run this, from the command prompt (no need to launch ghci before running it) $ runghc WordCount < quux.txt

-- This counts the number of lines in a file.
-- main = interact wordCount
--    where wordCount input = show (length (lines input)) ++ "\n"

-- The words function counts the number of words in a string. 
-- Modify the WC.hs example to count the number of words in a file
-- main = interact wordCount
--    where wordCount input = show (length (words input)) ++ "\n"

-- This shoes the number of characters in a file
main = interact characterCount
    where characterCount input = show (length input) ++ "\n"    
