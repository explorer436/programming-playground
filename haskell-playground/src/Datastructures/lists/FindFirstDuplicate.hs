-- find the firstDuplicate: [2,1,3,5,3,2] should return 3.
-- Using a HashSet is the bruteforce method.
-- Efficient method : Look at a number and subtract one from it's absolute value and make it negative. 
-- If the value is already negative, it men that we already traversed it and that is the answer.

// TODO