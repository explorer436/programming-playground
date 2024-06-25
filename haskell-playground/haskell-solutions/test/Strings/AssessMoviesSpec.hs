module Strings.AssessMoviesSpec where

import Strings.AssessMovies (assessMovies)

import Test.Hspec

spec :: Spec
spec = do

  describe "assessMovies" $ do

    it "returns expected output for the input parameters" $
        assessMovies movies
        `shouldBe` 
        ["Aeon Flux - Good","The Black Cat - Bad","Superman - Bad","Stick It - Bad","The Matrix Revolutions - Bad","The Raven - Bad","Inception - Good","Looper - Good","Hoodwinked - Good","Tell-Tale - Bad"]

movies =
  [ "Aeon Flux"
  , "The Black Cat"
  , "Superman"
  , "Stick It"
  , "The Matrix Revolutions"
  , "The Raven"
  , "Inception"
  , "Looper"
  , "Hoodwinked"
  , "Tell-Tale"
  ]