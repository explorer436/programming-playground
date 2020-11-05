-- An example showing the use of Type Synonyms

-- Let’s take a look at a program 
-- which will let us work out how much our shopping list will cost in total.

aShoppingListItem :: (String, Int)
aShoppingListItem = ("Bananas", 300)

-- This is a single shopping list item: a 2-tuple value. 
-- It has the String "Bananas", and the Int 300 
-- which we’re going to use to represent the number of cents that the bananas cost.

-- We actually want a list of these items, though. 
-- Let’s take a look what it’d look like to have 
-- a new name for our (String, Int) tuple type so our program is more self-explanatory.


-- We use “"type"” to tell Haskell we’re defining a type alias (or type synonym). 
-- This means Haskell sees ShippingListItem as being the same type as (String, Int). 
-- This is just to make our programs more readable for us. 
-- Haskell won’t see these types as different, 
-- so if you accidentally used a (String, Int) where you meant to use a ShoppingListItem, 
-- then Haskell won’t complain. 
-- Ideally, we’d like it to, though.

-- Note that in Haskell, all types must start with a capital letter, 
-- and all variable names must start with a lowercase letter.

-- Ok so let’s look at another couple of type synonyms to make things clearer, 
-- and also a type synonym for shopping lists, and an actual shopping list, too:


type Name = String
type PriceInCents = Int
type ShoppingListItem = (Name, PriceInCents)
type ShoppingList = [ShoppingListItem]

shoppingList :: ShoppingList
shoppingList = [ ("Bananas", 300)
               , ("Chocolate", 250)
               , ("Milk", 300)
               , ("Apples", 450)
               ]

-- So Name is now String, PriceInCents is Int, ShoppingListItem is a tuple of Name and PriceInCents, 
-- which is the same as saying it’s a tuple of String and Int, 
-- and ShoppingList is the same thing as [(Name,PriceInCents)], 
-- which is a list of tuples, and is the same thing as [(String,Int)].

-- All of these type aliases makes it much easier to understand 
-- what the programmer who wrote this intended. 
-- Especially the type PriceInCents. 
-- If we didn’t have this, 
-- we would have no idea what the numbers in each tuple are supposed to represent. 
-- We would have to either work it out by looking at all of the code, 
-- or hope that the programmer had written some helpful comments in the code.

sumShoppingList :: ShoppingList -> PriceInCents
sumShoppingList []     = 0
sumShoppingList (x:xs) = getPriceFromItem x +
                         sumShoppingList xs

getPriceFromItem :: ShoppingListItem -> PriceInCents
getPriceFromItem (_, price) = price

testSumShoppingList01 = "Price of shopping list is "
                ++ show (sumShoppingList shoppingList)
                ++ " cents."
