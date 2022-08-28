-- Let's take a look at a more complex example of association lists. 
-- On Unix/Linux machines, there is a file called /etc/passwd that stores usernames, UIDs, home directories, and various other data. 
-- We will write a program that parses such a file, creates an association list, and lets the user look up a username by giving a UID.

import Data.List ()
import System.IO ()
import Control.Monad(when)
import System.Exit ( exitFailure )
import System.Environment(getArgs)



main :: IO ()
main = do
    -- Load the command-line arguments
    args <- getArgs

    -- If we don't have the right amount of args, give an error and abort
    when (length args /= 2) $ do
        putStrLn "Syntax: passwd-al filename uid"
        exitFailure

    -- Read the file lazily
    content <- readFile (args !! 0)

    -- Compute the username in pure code
    let username = findByUID content (read (args !! 1))

    -- Display the result
    case username of 
         Just x -> putStrLn x
         Nothing -> putStrLn "Could not find that UID"



-- Given the entire input and a UID, see if we can find a username.
findByUID :: String -> Integer -> Maybe String
findByUID content uid =
    let al = map parseline . lines $ content
        in lookup uid al



-- Convert a colon-separated line into fields
parseline :: String -> (Integer, String)
parseline input =
    let fields = split ':' input
        in (read (fields !! 2), fields !! 0)



{- | Takes a delimiter and a list.  Break up the list based on the
-  delimiter. -}
split :: Eq a => a -> [a] -> [[a]]



-- If the input is empty, the result is a list of empty lists.
split _ [] = [[]]
split delim str =
    let -- Find the part of the list before delim and put it in "before".
        -- The rest of the list, including the leading delim, goes
        -- in "remainder".
        (before, remainder) = span (/= delim) str
        in
        before : case remainder of
                      [] -> []
                      x -> -- If there is more data to process,
                           -- call split recursively to process it
                           split delim (tail x)



-- The heart of it is findByUID, which is a simple function that parses the input one line at a time, then calls lookup over the result. 
-- The remaining program is concerned with parsing the input. 
-- The input file looks like this:



{- |
root:x:0:0:root:/root:/bin/bash
daemon:x:1:1:daemon:/usr/sbin:/bin/sh
bin:x:2:2:bin:/bin:/bin/sh
sys:x:3:3:sys:/dev:/bin/sh
sync:x:4:65534:sync:/bin:/bin/sync
games:x:5:60:games:/usr/games:/bin/sh
man:x:6:12:man:/var/cache/man:/bin/sh
lp:x:7:7:lp:/var/spool/lpd:/bin/sh
mail:x:8:8:mail:/var/mail:/bin/sh
news:x:9:9:news:/var/spool/news:/bin/sh
jgoerzen:x:1000:1000:John Goerzen,,,:/home/jgoerzen:/bin/bash
-}



-- Its fields are separated by colons, and include a username, numeric user ID, numeric group ID, full name, home directory, and shell. 
-- No field may contain an internal colon.
