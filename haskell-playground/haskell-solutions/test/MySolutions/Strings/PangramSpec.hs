module MySolutions.Strings.PangramSpec where

import MySolutions.Strings.Pangram (pangram)

import Test.Hspec

spec :: Spec
spec = do

  describe "pangram" $ do

    it "returns True when the input is a pangram" $
        pangram "The quick brown fox jumps over the lazy dog" `shouldBe` True

    it "returns False when the input is not a pangram" $
        pangram "test" `shouldBe` False

    it "returns True when the input is a pangram" $
        pangram "Pack my box with five dozen liquor jugs" `shouldBe` True

    it "returns True when the input is a pangram" $
        pangram "We promptly judged antique ivory buckles for the next prize" `shouldBe` True

    it "returns True when the input is a pangram" $
        pangram "Sixty zippers were quickly picked from the woven jute bag" `shouldBe` True

    it "returns True when the input is a pangram" $
        pangram "Sphinx of black quartz: judge my vow" `shouldBe` True
