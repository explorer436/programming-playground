import qualified Data.Map as Map

{- |
Maps

The Data.Map module provides a Map type with behavior that is similar to association lists, but has much better performance.

Maps give us the same capabilities as hash tables do in other languages. 
Internally, a map is implemented as a balanced binary tree. 
Compared to a hash table, this is a much more efficient representation in a language with immutable data. 
This is the most visible example of how deeply pure functional programming affects how we write code: 
we choose data structures and algorithms that we can express cleanly and that perform efficiently, but our choices for specific tasks are often different their counterparts in imperative languages.

Some functions in the Data.Map module have the same names as those in the Prelude. 
Therefore, we will import it with import qualified Data.Map as Map and use Map.name to refer to names in that module. 

Let's start our tour of Data.Map by taking a look at some ways to build a map.

-}


-- Functions to generate a Map that represents an association list as a map

al :: [(Integer, [Char])]
al = [(1, "one"), (2, "two"), (3, "three"), (4, "four")]


{- | Create a map representation of 'al' by converting the association list using Map.fromList -}
mapFromAL :: Map.Map Integer [Char]
mapFromAL = Map.fromList al
-- fromList [(1,"one"),(2,"two"),(3,"three"),(4,"four")]


{- | Create a map representation of 'al' by doing a fold -}
mapFold :: Map.Map Integer [Char]
mapFold = foldl (\map (k, v) -> Map.insert k v map) Map.empty al
-- fromList [(1,"one"),(2,"two"),(3,"three"),(4,"four")]


{- | Manually create a map with the elements of 'al' in it -}
mapManual :: Map.Map Integer [Char]
mapManual =
    Map.insert 2 "two" . 
    Map.insert 4 "four" .
    Map.insert 1 "one" .
    Map.insert 3 "three" $ Map.empty
-- fromList [(1,"one"),(2,"two"),(3,"three"),(4,"four")]

-- Notice that the output from mapManual differs from the order of the list we used to construct the map. 
-- Maps do not guarantee that they will preserve the original ordering.

-- Functions like Map.insert work in the usual Haskell way: they return a copy of the input data, with the requested change applied. 
-- This is quite handy with maps. 
-- It means that you can use foldl to build up a map as in the mapFold example. 
-- Or, you can chain together calls to Map.insert as in the mapManual example.

