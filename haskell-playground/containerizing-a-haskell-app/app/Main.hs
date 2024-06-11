module Main (main) where

import Web.Scotty
import Data.Text
import Data.Text.Lazy
import Data.Text()
import Network.HTTP.Types

main :: IO ()
main = scotty 3000 $ do

--------------------------------------------------------------
-- Basic routes

  addroute GET (capture "/") $ do
    text getLazyText
  -- curl -X GET http://localhost:3000/

  addroute DELETE (capture "/") $ do
    text getLazyText
  -- curl -X DELETE http://localhost:3000/

  addroute POST (capture "/") $ do
    text getLazyText
  -- curl -X POST http://localhost:3000/

  addroute PUT (capture "/") $ do
    text getLazyText
  -- curl -X PUT http://localhost:3000/


getText :: Data.Text.Text
getText = Data.Text.pack "This was a request to the application"

-- To convert from Strict Text to Lazy Text
-- https://www.stackage.org/haddock/lts-22.25/text-2.0.2/Data-Text-Lazy.html#g:4
-- https://www.stackage.org/haddock/lts-22.25/text-2.0.2/src/Data.Text.Lazy.html#fromStrict 
getLazyText :: Data.Text.Lazy.Text
getLazyText = fromStrict getText