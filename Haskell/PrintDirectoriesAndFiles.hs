import Data.List
import System.Directory

-- main = do all <- getDirectoryContents "/home/explorer436/Downloads/AddToBooksAndCatalog/"
main = do 
    mainDirectoryContents <- listDirectory "/home/explorer436/Downloads/AddToBooksAndCatalog/"
    listComprehensionExample2 <- listDirectory $ [mainDirectoryContents]
    print listComprehensionExample2



-- main = do 
--   let mainDirectoryLocation = "/home/explorer436/Downloads/AddToBooksAndCatalog/"
-- 
--   mainDirectoryContents <- listDirectory "/home/explorer436/Downloads/AddToBooksAndCatalog/"
--   listComprehensionExample2 <- listDirectory mainDirectoryLocation ++ x | x <- [mainDirectoryContents]
-- 
--   print listComprehensionExample2
-- listComprehensionExample2 <- [listDirectory mainDirectoryLocation ++ x | x <- [mainDirectoryContents]]

          -- let filtered = filter (isPrefixOf "haskell") all
          -- print filtered