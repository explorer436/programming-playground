module Strings.GroupNamesByAlphabetsSpec where
import Strings.GroupNamesByAlphabets (groupNamesByAlphabet, groupNamesByAllAlphabets)

import Test.Hspec

spec :: Spec
spec = do

  describe "groupNamesByAlphabet" $ do

    it "returns True when the input is a pangram" $
        groupNamesByAlphabet 'a' [ "Adam", "Bhushan", "Bimal", "Chilgoza", "Beth", "Anurag", "Ashton", "Chaman", "Charlie", "Banksky"]
        `shouldBe` 
        ('a',["Adam","Anurag","Ashton"])


  describe "groupNamesByAllAlphabets" $ do

    it "returns True when the input is a pangram" $
        groupNamesByAllAlphabets [ "Adam", "Bhushan", "Bimal", "Chilgoza", "Beth", "Anurag", "Ashton", "Chaman", "Charlie", "Banksky"]
        `shouldBe` 
        [('a',["Adam","Anurag","Ashton"]),('b',["Bhushan","Bimal","Beth","Banksky"]),('c',["Chilgoza","Chaman","Charlie"]),('d',[]),('e',[]),('f',[]),('g',[]),('h',[]),('i',[]),('j',[]),('k',[]),('l',[]),('m',[]),('n',[]),('o',[]),('p',[]),('q',[]),('r',[]),('s',[]),('t',[]),('u',[]),('v',[]),('w',[]),('x',[]),('y',[]),('z',[])]

