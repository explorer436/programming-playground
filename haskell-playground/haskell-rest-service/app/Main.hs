{-# LANGUAGE OverloadedStrings #-}
import Web.Scotty
import Network.HTTP.Types
import Data.Text.Internal.Lazy

import Model.Article

main :: IO ()
main = scotty 3000 $ do

--------------------------------------------------------------
-- Basic routes

  get "/" $ do                         -- handle GET request on "/" URL
    text "This was a GET request!"     -- send 'text/plain' response
  -- curl -X GET http://localhost:3000/

  delete "/" $ do
    html "This was a DELETE request!"  -- send 'text/html' response
  -- curl -X DELETE http://localhost:3000/

  post "/" $ do
    text "This was a POST request!"
  -- curl -X POST http://localhost:3000/

  put "/" $ do
    text "This was a PUT request!"
  -- curl -X PUT http://localhost:3000/

--------------------------------------------------------------
-- Set a custom Header in the response

  get "/agent" $ do
    userAgentName <- header "User-Agent"
    let res = convertMaybeToText userAgentName
    text res
  -- curl -v --header "User-Agent: my-custom-user-agent" http://localhost:3000/agent
  -- curl -v http://localhost:3000/agent

  -- adding a few more handlers to handle different types of requests
  -- set a header:
  post "/set-headers" $ do
   status status302  -- Respond with HTTP 302 status code
   setHeader "Location" "http://www.google.com.au"

--------------------------------------------------------------
-- Named and Un-named parameters

  -- named parameters:
  get "/askfor/:word" $ do
    w <- param "word"
    html $ mconcat ["<h1>You asked for ", w, ", you got it!</h1>" ]
  -- curl -X GET http://localhost:3000/askfor/har

  -- unnamed parameters from a query string or a form:
  post "/submit" $ do  
   name <- param "name"
   text name
  -- curl -X POST http://localhost:3000/submit?name=someone

--------------------------------------------------------------
-- Handle custom data models in requests and responses

  -- get article (json)
  get "/article" $ do
    json $ Article 13 "caption" "content" -- Call Article constructor and encode the result as JSON
  -- curl -X GET http://localhost:3000/article

  -- post article (json)
  post "/article" $ do
    article <- jsonData :: ActionM Article -- Decode body of the POST request as an Article object
    json article
  -- curl --header "Content-Type: application/json" --request POST --data '{"id":13,"title":"articleTitle","bodyText":"articleBodyText"}' http://localhost:3000/article
  -- NOTE: the Content-Type in the curl command is important because without it, the application will not identify the json data in the request.

  --------------------------------------------------------------
  -- NOTE: These should always be at the end of the file.

  -- match a route regardless of the method
  matchAny "/all" $ do 
   text "matches all methods"
  -- curl -v http://localhost:3000/all

  -- handler for when there is no matched route
  -- (this should be the last handler because it matches all routes)
  notFound $ do 
   text "there is no such route."
  -- curl -v http://localhost:3000/abcd

convertMaybeToText :: (Maybe Text) -> Data.Text.Internal.Lazy.Text
convertMaybeToText (Just x) = x
convertMaybeToText Nothing = "no user agent"
