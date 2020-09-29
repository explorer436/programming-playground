-- Back when we were dealing with recursion, 
--     we noticed a theme throughout many of the recursive functions that operated on lists. 
-- Usually, we'd have an edge case for the empty list. 
-- We'd introduce the x:xs pattern 
--     and then we'd do some action that involves a single element 
--     and the rest of the list. 
-- It turns out this is a very common pattern, 
--     so a couple of very useful functions were introduced to encapsulate it. 
-- These functions are called folds. 
-- They're sort of like the map function, only they reduce the list to some single value.

-- A fold takes a binary function, 
--     a starting value (I like to call it the accumulator) and a list to fold up. 
-- The binary function itself takes two parameters. 
-- The binary function is called with the accumulator 
--     and the first (or last) element and produces a new accumulator. 
-- Then, the binary function is called again with the new accumulator 
--     and the now new first (or last) element, and so on. 
-- Once we've walked over the whole list, 
--     only the accumulator remains, which is what we've reduced the list to.

-- Let's take a look at the foldl function, also called the left fold. 
-- It folds the list up from the left side. 
-- The binary function is applied between the starting value and the head of the list. 
-- That produces a new accumulator value 
--     and the binary function is called with that value and the next element, etc.

-- Let's implement sum again, only this time, we'll use a fold instead of explicit recursion.

sum' :: (Num a) => [a] -> a  
sum' xs = foldl (\acc x -> acc + x) 0 xs  
Testing, one two three:

testSum01 = sum' [3,5,2,1]  
-- 11  

-- Let's take an in-depth look into how this fold happens. `\acc x -> acc + x` is the binary function. 
-- 0 is the starting value and xs is the list to be folded up. 
-- Now first, 0 is used as the acc parameter to the binary function and 
--     3 is used as the x (or the current element) parameter. 
-- 0 + 3 produces a 3 and it becomes the new accumulator value, so to speak. 
-- Next up, 3 is used as the accumulator value 
--     and 5 as the current element and 8 becomes the new accumulator value. 
-- Moving forward, 8 is the accumulator value, 2 is the current element, the new accumulator value is 10. 
-- Finally, that 10 is used as the accumulator value and 1 as the current element, producing an 11. 
-- Congratulations, you've done a fold!

-- If we take into account that functions are curried, we can write this implementation ever more succinctly, like so:

sum' :: (Num a) => [a] -> a  
sum' = foldl (+) 0  
-- The lambda function (\acc x -> acc + x) is the same as (+). We can omit the xs as the parameter because calling foldl (+) 0 will return a function that takes a list. Generally, if you have a function like foo a = bar b a, you can rewrite it as foo = bar b, because of currying.

-- Let's implement another function with a left fold before moving on to right folds. 
-- elem checks whether a value is part of a list.
-- Let's implement it with a left fold.

elem' :: (Eq a) => a -> [a] -> Bool  
elem' y ys = foldl (\acc x -> if x == y then True else acc) False ys  

-- The starting value and accumulator here is a boolean value. 
-- The type of the accumulator value and the end result is always the same when dealing with folds. 
-- Remember that if you ever don't know what to use as a starting value, it'll give you some idea. 
-- We start off with False. 
-- It makes sense to use False as a starting value. 
-- We assume it isn't there. 
-- Also, if we call a fold on an empty list, the result will just be the starting value. 
-- Then we check the current element is the element we're looking for. 
-- If it is, we set the accumulator to True. 
-- If it's not, we just leave the accumulator unchanged. 
-- If it was False before, it stays that way because this current element is not it. 
-- If it was True, we leave it at that.

-- The right fold, foldr works in a similar way to the left fold, 
--     only the accumulator eats up the values from the right. 
-- Also, the left fold's binary function has the accumulator as the first parameter 
--     and the current value as the second one (so \acc x -> ...), 
--     the right fold's binary function has the current value as the first parameter 
--     and the accumulator as the second one (so \x acc -> ...). 
-- It kind of makes sense that the right fold has the accumulator on the right, 
--     because it folds from the right side.

-- The accumulator value (and hence, the result) of a fold can be of any type. 
-- It can be a number, a boolean or even a new list. 
-- We'll be implementing the map function with a right fold. 
-- The accumulator will be a list, we'll be accumulating the mapped list element by element. 
-- From that, it's obvious that the starting element will be an empty list.

map' :: (a -> b) -> [a] -> [b]  
map' f xs = foldr (\x acc -> f x : acc) [] xs  

-- If we're mapping (+3) to [1,2,3], we approach the list from the right side. 
-- We take the last element, which is 3 and apply the function to it, which ends up being 6. 
-- Then, we prepend it to the accumulator, which is was []. 
-- 6:[] is [6] and that's now the accumulator. 
-- We apply (+3) to 2, that's 5 and we prepend (:) it to the accumulator, so the accumulator is now [5,6]. 
-- We apply (+3) to 1 and prepend that to the accumulator and so the end value is [4,5,6].

-- Of course, we could have implemented this function with a left fold too. 
-- It would be map' f xs = foldl (\acc x -> acc ++ [f x]) [] xs, 
--     but the thing is that the ++ function is much more expensive than :, 
--     so we usually use right folds when we're building up new lists from a list.

-- If you reverse a list, 
--     you can do a right fold on it just like you would have done a left fold and vice versa. 
-- Sometimes you don't even have to do that. 
-- The sum function can be implemented pretty much the same with a left and right fold. 
-- One big difference is that right folds work on infinite lists, 
--     whereas left ones don't! 
-- To put it plainly, 
--     if you take an infinite list at some point and you fold it up from the right, 
--     you'll eventually reach the beginning of the list. 
-- However, if you take an infinite list at a point and you try to fold it up from the left, 
--     you'll never reach an end!

-- Folds can be used to implement any function where you traverse a list once, 
--     element by element, and then return something based on that. 
-- Whenever you want to traverse a list to return something, 
--     chances are you want a fold. 
-- That's why folds are, along with maps and filters, 
--     one of the most useful types of functions in functional programming.

-- The foldl1 and foldr1 functions work much like foldl and foldr, 
--     only you don't need to provide them with an explicit starting value. 
-- They assume the first (or last) element of the list to be the starting value 
--     and then start the fold with the element next to it. 
-- With that in mind, the sum function can be implemented like so: sum = foldl1 (+). 
-- Because they depend on the lists they fold up having at least one element, 
--     they cause runtime errors if called with empty lists. 
-- foldl and foldr, on the other hand, work fine with empty lists. 
-- When making a fold, think about how it acts on an empty list. 
-- If the function doesn't make sense when given an empty list, 
--     you can probably use a foldl1 or foldr1 to implement it.

-- Just to show you how powerful folds are, 
--     we're going to implement a bunch of standard library functions by using folds.

maximum' :: (Ord a) => [a] -> a  
maximum' = foldr1 (\x acc -> if x > acc then x else acc)  
  
reverse' :: [a] -> [a]  
reverse' = foldl (\acc x -> x : acc) []  
  
product' :: (Num a) => [a] -> a  
product' = foldr1 (*)  
  
filter' :: (a -> Bool) -> [a] -> [a]  
filter' p = foldr (\x acc -> if p x then x : acc else acc) []  
  
head' :: [a] -> a  
head' = foldr1 (\x _ -> x)  
  
last' :: [a] -> a  
last' = foldl1 (\_ x -> x)  

-- head is better implemented by pattern matching, 
--     but this just goes to show, 
--     you can still achieve it by using folds. 
-- Our reverse' definition is pretty clever, I think. 
-- We take a starting value of an empty list 
--     and then approach our list from the left and just prepend to our accumulator. 
-- In the end, we build up a reversed list. 
-- \acc x -> x : acc kind of looks like the : function, only the parameters are flipped. 
-- That's why we could have also written our reverse as foldl (flip (:)) [].

-- Another way to picture right and left folds is like this: 
--     say we have a right fold and the binary function is f and the starting value is z. 
--     If we're right folding over the list [3,4,5,6],
--     we're essentially doing this: f 3 (f 4 (f 5 (f 6 z))).
--     f is called with the last element in the list and the accumulator,
--     that value is given as the accumulator to the next to last value and so on.
--     If we take f to be + and the starting accumulator value to be 0,
--     that's 3 + (4 + (5 + (6 + 0))).
--     Or if we write + as a prefix function, that's (+) 3 ((+) 4 ((+) 5 ((+) 6 0))).
--     Similarly, doing a left fold over that list with g as the binary function 
--     and z as the accumulator is the equivalent of g (g (g (g z 3) 4) 5) 6.
--     If we use flip (:) as the binary function and [] as the accumulator (so we're reversing the list),
--     then that's the equivalent of flip (:) (flip (:) (flip (:) (flip (:) [] 3) 4) 5) 6.
--     And sure enough, if you evaluate that expression, you get [6,5,4,3].
