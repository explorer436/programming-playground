{- |}
Association Lists

Often, we have to deal with data that is unordered but is indexed by a key.

In Haskell, there are several ways to handle data that is structured in this way. The two most common are association lists and the Map type provided by Data.Map module. Association lists are handy because they are simple. They are standard Haskell lists, so all the familiar list functions work with association lists. However, for large data sets, Map will have a considerable performance advantage over association lists.

An association list is just a normal list containing (key, value) tuples. The type of a list of mappings from UID to username might be [(Integer, String)]. We could use just about any type for both the key and the value (The type we use for the key must be a member of the Eq typeclass.)

We can build association lists just we do any other list. Haskell comes with one built-in function called Data.List.lookup to look up data in an association list. Its type is Eq a => a -> [(a, b)] -> Maybe b.
-}

al = [(1, "one"), (2, "two"), (3, "three"), (4, "four")]

-- lookup 1 al
-- Just "one"

-- lookup 5 al
--Nothing

-- The lookup function is really simple. Here's one way we could write it.

myLookup :: Eq a => a -> [(a, b)] -> Maybe b
myLookup _ [] = Nothing
myLookup key ((thiskey,thisval):rest) =
    if key == thiskey
       then Just thisval
       else myLookup key rest
