Function Composition

The operator called the function composition operator (.) glues two functions together. 
It turns them into a single function that does the same as calling the first one on the result of calling the second one. 
You can think of it as feeding the “output” of the function on the right into the “input” of the function on the left.
The dot operator chains two functions together to form a new one that does the work of both, as long as they have a common type between them.

Sometimes it makes more sense to use normal function application and other times it makes more sense to use function composition, but they mean the same thing.
