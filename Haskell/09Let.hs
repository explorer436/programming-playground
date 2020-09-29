-----------------------------------------------------------------------
-- LET

{- |
`let` bindings are very similar to `where` bindings. 
Where bindings are a syntactic construct that let you bind to variables at the end of a function 
    and the whole function can see them, 
    including all the guards. 
`Let` bindings let you bind to variables anywhere and are expressions themselves, 
    but are very local, 
    so they don't span across guards. 
Just like any construct in Haskell that is used to bind values to names, 
    let bindings can be used for pattern matching. 
This is how we could define a function that 
    gives us a cylinder's surface area based on its height and radius:
-}

cylinderSurfaceAreaUsingLetBinding :: (RealFloat a) => a -> a -> a  
cylinderSurfaceAreaUsingLetBinding r h = 
    let sideArea = 2 * pi * r * h  
        topArea = pi * r ^2  
    in  sideArea + 2 * topArea  


cylinderSurfaceAreaUsingWhereBinding :: (RealFloat a) => a -> a -> a  
cylinderSurfaceAreaUsingWhereBinding r h = sideArea + 2 * topArea  
    where sideArea = 2 * pi * r * h  
          topArea  = pi * r ^2  

cylinderSurfaceAreaUsingLetBindingTest1 = cylinderSurfaceAreaUsingLetBinding 2 3             
cylinderSurfaceAreaUsingWhereBindingTest1 = cylinderSurfaceAreaUsingWhereBinding 2 3

{- |
The form is `let <bindings> in <expression>`. 
The names that you define in the `let` part are accessible to the expression after the `in` part. 
As you can see, we could have also defined this with a `where` binding. 
Notice that the names are also aligned in a single column. 
So what's the difference between the two? 
For now it just seems that `let` puts the bindings first and 
    the expression that uses them later whereas `where` is the other way around.
 

The difference is that let bindings are expressions themselves. 
    where bindings are just syntactic constructs. 
    Remember when we did the if statement and 
    it was explained that an if else statement is an expression and 
    you can cram it in almost anywhere?
 
    ghci> [if 5 > 3 then "Woo" else "Boo", if 'a' > 'b' then "Foo" else "Bar"]  
    ["Woo", "Bar"]  
    ghci> 4 * (if 10 > 5 then 10 else 0) + 2  
    42  

You can also do that with let bindings.

    ghci> 4 * (let a = 9 in a + 1) + 2  
    42  

They can also be used to introduce functions in a local scope:

    ghci> [let square x = x * x in (square 5, square 3, square 2)]  
    [(25,9,4)]  

If we want to bind to several variables inline, 
    we obviously can't align them at columns. 
That's why we can separate them with semicolons.

    ghci> (let a = 100; b = 200; c = 300 in a*b*c, let foo="Hey "; bar = "there!" in foo ++ bar)  
    (6000000,"Hey there!")  

You don't have to put a semicolon after the last binding but you can if you want. 
Like we said before, you can pattern match with let bindings. 
They're very useful for quickly dismantling a tuple into components 
    and binding them to names and such.

    ghci> (let (a,b,c) = (1,2,3) in a+b+c) * 100  
    600  

You can also put let bindings inside list comprehensions. 
Let's rewrite our previous example of calculating lists of weight-height pairs 
to use a let inside a list comprehension instead of defining an auxiliary function with a where.
-}

{- |
calcBmis :: (RealFloat a) => [(a, a)] -> [a]  
calcBmis xs = [bmi | (w, h) <- xs, let bmi = w / h ^ 2]  
-}


{- |
We include a `let` inside a list comprehension much like we would a predicate, 
    only it doesn't filter the list, it only binds to names. 
The names defined in a let inside a list comprehension are visible to the output function 
    (the part before the |) and 
    all predicates and sections that come after of the binding. 
So we could make our function return only the BMIs of fat people:
-}


calcBmis :: (RealFloat a) => [(a, a)] -> [a]  
calcBmis xs = [bmi | (w, h) <- xs, let bmi = w / h ^ 2, bmi >= 25.0]  
-- We can't use the bmi name in the (w, h) <- xs part 
-- because it's defined prior to the let binding.



{- |

We omitted the `in` part of the `let` binding when we used them in list comprehensions because 
the visibility of the names is already predefined there. 
However, we could use a `let` in binding in a predicate and 
the names defined would only be visible to that predicate. 
The `in` part can also be omitted when defining functions and 
constants directly in GHCi. 
If we do that, then the names will be visible throughout the entire interactive session.

    ghci> let zoot x y z = x * y + z  
    ghci> zoot 3 9 2  
    29  
    ghci> let boot x y z = x * y + z in boot 3 4 2  
    14  
    ghci> boot  
    <interactive>:1:0: Not in scope: `boot'  

If `let` bindings are so cool, why not use them all the time instead of `where` bindings, you ask? 
Well, since `let` bindings are expressions and are fairly local in their scope, 
    they can't be used across guards. 
Some people prefer `where` bindings because 
    the names come after the function they're being used in. 
That way, the function body is closer to its name and type declaration and 
    that is more readable.
-}
