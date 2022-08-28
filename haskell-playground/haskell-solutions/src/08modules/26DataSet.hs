import qualified Data.Set as Set 
import qualified Data.List as L

-- The Data.Set module offers us, well, sets. 
-- Like sets from mathematics.
-- Sets are kind of like a cross between lists and maps.
-- All the elements in a set are unique.
-- And because they're internally implemented with trees 
-- (much like maps in Data.Map), they're ordered.
-- Checking for membership, inserting, deleting, etc. is 
-- much faster than doing the same thing with lists.
-- The most common operation when dealing with sets are inserting into a set,
-- checking for membership and converting a set to a list.

-- Because the names in Data.Set clash with a lot of 
-- Prelude and Data.List names, 
-- we do a qualified import.

-- Let's say we have two pieces of text.
-- We want to find out which characters were used in both of them.

text1 = "I just had an anime dream. Anime... Reality... Are they so different?"  
text2 = "The old man left his garbage can out and now his trash is all over my lawn!"  

-- The fromList function works much like you would expect. It takes a list and converts it into a set.
set1 = Set.fromList text1  
-- fromList " .?AIRadefhijlmnorstuy"  
set2 = Set.fromList text2  
-- fromList " !Tabcdefghilmnorstuvwy"  
-- As you can see, the items are ordered and each element is unique.
-- Now let's use the intersection function to see which elements they both share.

testIntersection01 = Set.intersection set1 set2  
-- fromList " adefhilmnorstuy"  

-- We can use the difference function to see 
-- which letters are in the first set but aren't in the second one and vice versa.

testDifference01 = Set.difference set1 set2  
-- fromList ".?AIRj"  
testDifference02 = Set.difference set2 set1  
-- fromList "!Tbcgvw"  

-- Or we can see all the unique letters used in both sentences by using union.

testUnion01 = Set.union set1 set2  
-- fromList " !.?AIRTabcdefghijlmnorstuvwy"  


-- The null, size, member, empty, singleton, insert and delete functions 
-- all work like you'd expect them to.

testNull01 = Set.null Set.empty  
-- True  
testNull02 = Set.null $ Set.fromList [3,4,5,5,4,3]  
-- False  
testSize01 = Set.size $ Set.fromList [3,4,5,3,4,5]  
-- 3  
testSingleton01 = Set.singleton 9  
-- fromList [9]  
testInsert01 = Set.insert 4 $ Set.fromList [9,3,8,1]  
-- fromList [1,3,4,8,9]  
testInsert02 = Set.insert 8 $ Set.fromList [5..10]  
-- fromList [5,6,7,8,9,10]  
testDelete01 = Set.delete 4 $ Set.fromList [3,4,5,4,3,4,5]  
-- fromList [3,5]  

-- We can also check for subsets or proper subset.
-- Set A is a subset of set B if B contains all the elements that A does.
-- Set A is a proper subset of set B if B contains all the elements that A does 
-- but has more elements.

testSubsetOf01 = Set.fromList [2,3,4] `Set.isSubsetOf` Set.fromList [1,2,3,4,5]  
-- True  
testSubsetOf02 = Set.fromList [1,2,3,4,5] `Set.isSubsetOf` Set.fromList [1,2,3,4,5]  
-- True  
testProperSubsetOf01 = Set.fromList [1,2,3,4,5] `Set.isProperSubsetOf` Set.fromList [1,2,3,4,5]  
-- False  
testSubsetOf03 = Set.fromList [2,3,4,8] `Set.isSubsetOf` Set.fromList [1,2,3,4,5]  
-- False  

-- We can also map over sets and filter them.

testFilter01 = Set.filter odd $ Set.fromList [3,4,5,6,7,2,3,4]  
-- fromList [3,5,7]  
testFilter02 = Set.map (+1) $ Set.fromList [3,4,5,6,7,2,3,4]  
-- fromList [3,4,5,6,7,8]  

-- Sets are often used to weed a list of duplicates from a list 
-- by first making it into a set with fromList 
-- and then converting it back to a list with toList. 
-- The Data.List function nub already does that, 
-- but weeding out duplicates for large lists is much faster 
-- if you cram them into a set and then convert them back to a list than using nub. 
-- But using nub only requires 
-- the type of the list's elements to be part of the Eq typeclass, 
-- whereas if you want to cram elements into a set, 
-- the type of the list has to be in Ord.

setNub xs = Set.toList $ Set.fromList xs  
testSetNub01 = setNub "HEY WHATS CRACKALACKIN"  
-- " ACEHIKLNRSTWY"  
testSetNub02 = L.nub "HEY WHATS CRACKALACKIN"  
-- "HEY WATSCRKLIN"  
-- setNub is generally faster than nub on big lists but as you can see, nub preserves the ordering of the list's elements, while setNub does not.
