module Strings.AnagramSpec where

import Strings.Anagram (anagram)

import Test.Hspec

spec :: Spec
spec = do
  describe "anagram" $ do
    it "returns true when the two strings are listen and silent" $
      anagram "listen" "silent"                       `shouldBe` True
    it "returns false when the two strings are listen and not silent" $
      anagram "listen" "not silent"                   `shouldBe` False
    it "returns true when the two strings are anagram and nag a ram" $
      anagram "anagram" "nag a ram"                   `shouldBe` True
    it "returns true when the two strings are Tar and Rat" $
      anagram "Tar" "Rat"                             `shouldBe` True
    it "returns true when the two strings are Arc and Car" $
      anagram "Arc" "Car"                             `shouldBe` True
    it "returns true when the two strings are Elbow and Below" $
      anagram "Elbow" "Below"                         `shouldBe` True
    it "returns true when the two strings are State and Taste" $
      anagram "State" "Taste"                         `shouldBe` True
    it "returns true when the two strings are Cider and Cried" $
      anagram "Cider" "Cried"                         `shouldBe` True
    it "returns true when the two strings are Dusty and Study" $
      anagram "Dusty" "Study"                         `shouldBe` True
    it "returns true when the two strings are Night and Thing" $
      anagram "Night" "Thing"                         `shouldBe` True
    it "returns true when the two strings are Inch and Chin" $
      anagram "Inch" "Chin"                           `shouldBe` True
    it "returns true when the two strings are Brag and Grab" $
      anagram "Brag" "Grab"                           `shouldBe` True
    it "returns true when the two strings are Cat and Act" $
      anagram "Cat" "Act"                             `shouldBe` True
    it "returns true when the two strings are Bored and Robed" $
      anagram "Bored" "Robed"                         `shouldBe` True
    it "returns true when the two strings are Save and Vase" $
      anagram "Save" "Vase"                           `shouldBe` True
    it "returns true when the two strings are Angel and Glean" $
      anagram "Angel" "Glean"                         `shouldBe` True
    it "returns true when the two strings are Stressed and Desserts" $
      anagram "Stressed" "Desserts"                   `shouldBe` True
    it "returns true when the two strings are debit card and bad credit and silent" $
      anagram "debit card" "bad credit"               `shouldBe` True
    it "returns true when the two strings are Dormitory and Dirty room" $
      anagram "Dormitory" "Dirty room"                `shouldBe` True
    it "returns true when the two strings are School master and The classroom" $
      anagram "School master" "The classroom"         `shouldBe` True
    it "returns true when the two strings are Conversation and Voices rant on" $
      anagram "Conversation" "Voices rant on"         `shouldBe` True
    it "returns true when the two strings are Listen and Silent" $
      anagram "Listen" "Silent"                       `shouldBe` True
    it "returns true when the two strings are Astronomer and Moon starer" $
      anagram "Astronomer" "Moon starer"              `shouldBe` True
    it "returns true when the two strings are The eyes and They see" $
      anagram "The eyes" "They see"                   `shouldBe` True
    it "returns true when the two strings are A gentleman and Elegant man" $
      anagram "A gentleman" "Elegant man"             `shouldBe` True
    it "returns true when the two strings are Funeral and Real fun" $
      anagram "Funeral" "Real fun"                    `shouldBe` True
    it "returns true when the two strings are The Morse Code and Here comes dots" $
      anagram "The Morse Code" "Here comes dots"      `shouldBe` True
    it "returns true when the two strings are Eleven plus two and Twelve plus one" $
      anagram "Eleven plus two" "Twelve plus one"     `shouldBe` True
    it "returns true when the two strings are Slot machines and Cash lost in me" $
      anagram "Slot machines" "Cash lost in me"       `shouldBe` True
    it "returns true when the two strings are Fourth of July and Joyful Fourth" $
      anagram "Fourth of July" "Joyful Fourth"        `shouldBe` True
