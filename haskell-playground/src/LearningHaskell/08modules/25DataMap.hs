import qualified Data.Map as Map 
import Data.Char

-- Association lists (also called dictionaries) are lists 
-- that are used to store key-value pairs where ordering doesn't matter.
-- For instance, we might use an association list to store phone numbers,
-- where phone numbers would be the values and people's names would be the keys.
-- We don't care in which order they're stored,
-- we just want to get the right phone number for the right person.

-- The most obvious way to represent association lists in Haskell 
-- would be by having a list of pairs.
-- The first component in the pair would be the key,
-- the second component the value.
-- Here's an example of an association list with phone numbers:

phoneBook1 =   
    [("betty","555-2938")  
    ,("bonnie","452-2928")  
    ,("patsy","493-2928")  
    ,("lucille","205-2928")  
    ,("wendy","939-8282")  
    ,("penny","853-2492")  
    ]  

-- Despite this seemingly odd indentation, this is just a list of pairs of strings.
-- The most common task when dealing with association lists is 
-- looking up some value by key.
-- Let's make a function that looks up some value given a key.

findKey1 :: (Eq k) => k -> [(k,v)] -> v  
findKey1 key xs = snd . head . filter (\(k,v) -> key == k) $ xs      

-- snd stands for second (as opposed to first).
-- The function that takes a key and a list,
-- filters the list so that only matching keys remain,
-- gets the first key-value that matches and returns the value.

-- But what happens if the key we're looking for isn't in the association list?
-- Here, if a key isn't in the association list,
-- we'll end up trying to get the head of an empty list,
-- which throws a runtime error.
-- However, we should avoid making our programs so easy to crash,
-- so let's use the Maybe data type.
-- If we don't find the key, we'll return a Nothing.
-- If we find it, we'll return Just something,
-- where something is the value corresponding to that key.

findKey2 :: (Eq k) => k -> [(k,v)] -> Maybe v  
findKey2 key [] = Nothing  
findKey2 key ((k,v):xs) = if key == k  
                            then Just v  
                            else findKey2 key xs  

-- Look at the type declaration.
-- It takes a key that can be equated, an association list and then it maybe produces a value.

-- This is a textbook recursive function that operates on a list.
-- Edge case, splitting a list into a head and a tail, recursive calls, they're all there.
-- This is the classic fold pattern, so let's see how this would be implemented as a fold.

findKey3 :: (Eq k) => k -> [(k,v)] -> Maybe v  
findKey3 key = foldr (\(k,v) acc -> if key == k then Just v else acc) Nothing  

-- Note: It's usually better to use folds for this standard list recursion pattern 
-- instead of explicitly writing the recursion because 
-- they're easier to read and identify.
-- Everyone knows it's a fold when they see the foldr call, 
-- but it takes some more thinking to read explicit recursion.

testFindKey01 = findKey3 "penny" phoneBook1  
-- Just "853-2492"  
testFindKey02 = findKey3 "betty" phoneBook1  
-- Just "555-2938"  
testFindKey03 = findKey3 "wilma" phoneBook1  
-- Nothing  

-- Works like a charm! 
-- If we have the girl's phone number, we Just get the number, otherwise we get Nothing.

-- We just implemented the lookup function from Data.List.
-- If we want to find the corresponding value to a key,
-- we have to traverse all the elements of the list until we find it.
-- The Data.Map module offers association lists that are much faster 
-- (because they're internally implemented with trees) 
-- and also it provides a lot of utility functions.
-- From now on, we'll say we're working with maps instead of association lists.

-- Because Data.Map exports functions that clash with the Prelude and Data.List ones, 
-- we need do a qualified import.

-- Let's go ahead and see what Data.Map has in store for us! 
-- Here's the basic rundown of its functions.


-- The fromList function takes an association list (in the form of a list) 
-- and returns a map with the same associations.
testFromList01 = Map.fromList [("betty","555-2938"),("bonnie","452-2928"),("lucille","205-2928")]  
-- fromList [("betty","555-2938"),("bonnie","452-2928"),("lucille","205-2928")]  
testFromList02 = Map.fromList [(1,2),(3,4),(3,2),(5,5)]  
-- fromList [(1,2),(3,2),(5,5)] 

-- If there are duplicate keys in the original association list,
-- the duplicates are just discarded.
-- This is the type signature of fromList

-- Map.fromList :: (Ord k) => [(k, v)] -> Map.Map k v  

-- It says that it takes a list of pairs of type k and v 
-- and returns a map that maps from keys of type k to type v. 
-- Notice that when we were doing association lists with normal lists,
-- the keys only had to be equatable 
-- (their type belonging to the Eq typeclass) 
-- but now they have to be orderable. 
-- That's an essential constraint in the Data.Map module.
-- It needs the keys to be orderable so it can arrange them in a tree.

-- You should always use Data.Map for key-value associations 
-- unless you have keys that aren't part of the Ord typeclass.

-- empty represents an empty map. It takes no arguments, it just returns an empty map.
testMapEmpty01 = Map.empty  
-- fromList []  

-- insert takes a key, a value and a map and 
-- returns a new map that's just like the old one, only with the key and value inserted.

testMapInsert01 = Map.insert 3 100 Map.empty  
-- fromList [(3,100)]  
testMapInsert02 = Map.insert 5 600 (Map.insert 4 200 ( Map.insert 3 100  Map.empty))  
-- fromList [(3,100),(4,200),(5,600)]  
testMapInsert03 = Map.insert 5 600 . Map.insert 4 200 . Map.insert 3 100 $ Map.empty  
-- fromList [(3,100),(4,200),(5,600)]  

-- We can implement our own fromList by using the empty map, insert and a fold. Watch:

fromList' :: (Ord k) => [(k,v)] -> Map.Map k v  
fromList' = foldr (\(k,v) acc -> Map.insert k v acc) Map.empty  

-- It's a pretty straightforward fold.
-- We start of with an empty map and we fold it up from the right,
-- inserting the key value pairs into the accumulator as we go along.

-- null checks if a map is empty.
testMapNull01 = Map.null Map.empty  
-- True  
testMapNull02 = Map.null $ Map.fromList [(2,3),(5,5)]  
-- False  

-- size reports the size of a map.
testMapSize01 = Map.size Map.empty  
-- 0  
testMapSize02 = Map.size $ Map.fromList [(2,4),(3,3),(4,2),(5,4),(6,4)]  
-- 5  


-- singleton takes a key and a value and creates a map that has exactly one mapping.
testMapSingleton01 = Map.singleton 3 9  
-- fromList [(3,9)]  
testMapSingleton02 = Map.insert 5 9 $ Map.singleton 3 9  
-- fromList [(3,9),(5,9)]  

-- lookup works like the Data.List lookup, only it operates on maps.
-- It returns Just something if it finds something for the key and Nothing if it doesn't.

-- member is a predicate takes a key and a map and reports whether the key is in the map or not.

testMapMember01 = Map.member 3 $ Map.fromList [(3,6),(4,3),(6,9)]  
-- True  
testMapMember02 = Map.member 3 $ Map.fromList [(2,5),(4,5)]  
-- False  

-- map and filter work much like their list equivalents.

testMapMap01 = Map.map (*100) $ Map.fromList [(1,1),(2,4),(3,9)]  
-- fromList [(1,100),(2,400),(3,900)]  
testMapFilter01 = Map.filter isUpper $ Map.fromList [(1,'a'),(2,'A'),(3,'b'),(4,'B')]  
--fromList [(2,'A'),(4,'B')]  

-- toList is the inverse of fromList.
testMapToList01 = Map.toList . Map.insert 9 2 $ Map.singleton 4 3  
-- [(4,3),(9,2)]  

-- keys and elems return lists of keys and values respectively.
-- keys is the equivalent of map fst . Map.toList and 
-- elems is the equivalent of map snd . Map.toList.

-- fromListWith is a cool little function.
-- It acts like fromList, only it doesn't discard duplicate keys 
-- but it uses a function supplied to it to decide what to do with them.
-- Let's say that a girl can have several numbers and we have an association list set up like this.

phoneBook2 =   
    [("betty","555-2938")  
    ,("betty","342-2492")  
    ,("bonnie","452-2928")  
    ,("patsy","493-2928")  
    ,("patsy","943-2929")  
    ,("patsy","827-9162")  
    ,("lucille","205-2928")  
    ,("wendy","939-8282")  
    ,("penny","853-2492")  
    ,("penny","555-2111")  
    ]  
-- Now if we just use fromList to put that into a map, we'll lose a few numbers! 
-- So here's what we'll do:

phoneBookToMap :: (Ord k) => [(k, String)] -> Map.Map k String  
phoneBookToMap xs = Map.fromListWith (\number1 number2 -> number1 ++ ", " ++ number2) xs  

testMapLookup01 = Map.lookup "patsy" $ phoneBookToMap phoneBook2  
-- "827-9162, 943-2929, 493-2928"  
testMapLookup02 = Map.lookup "wendy" $ phoneBookToMap phoneBook2  
-- "939-8282"  
testMapLookup03 = Map.lookup "betty" $ phoneBookToMap phoneBook2  
-- "342-2492, 555-2938"  

-- If a duplicate key is found,
-- the function we pass is used to combine the values of those keys into some other value.
-- We could also first make all the values in the association list singleton lists 
-- and then we can use ++ to combine the numbers.

phoneBookToMap2 :: (Ord k) => [(k, a)] -> Map.Map k [a]  
phoneBookToMap2 xs = Map.fromListWith (++) $ map (\(k,v) -> (k,[v])) xs  
testMapLookup04 = Map.lookup "patsy" $ phoneBookToMap2 phoneBook2  
-- ["827-9162","943-2929","493-2928"]  

-- Pretty neat! 
-- Another use case is if we're making a map from an association list of numbers 
-- and when a duplicate key is found, we want the biggest value for the key to be kept.

testMapFromListWith01 = Map.fromListWith max [(2,3),(2,5),(2,100),(3,29),(3,22),(3,11),(4,22),(4,15)]  
-- fromList [(2,100),(3,29),(4,22)]  

-- Or we could choose to add together values on the same keys.
testMapFromListWith02 = Map.fromListWith (+) [(2,3),(2,5),(2,100),(3,29),(3,22),(3,11),(4,22),(4,15)]  
-- fromList [(2,108),(3,62),(4,37)]  

-- insertWith is to insert what fromListWith is to fromList.
-- It inserts a key-value pair into a map,
-- but if that map already contains the key,
-- it uses the function passed to it to determine what to do.

testMapInsertWith01 = Map.insertWith (+) 3 100 $ Map.fromList [(3,4),(5,103),(6,339)]  
-- fromList [(3,104),(5,103),(6,339)]  

-- These were just a few functions from Data.Map. 
-- You can see a complete list of functions in the documentation.

