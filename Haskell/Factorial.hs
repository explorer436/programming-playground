-- To run this, load tthis into Prelude (:l Factorial.hs) and call the fac function with a parameter.
-- fac 5

fac 0 = 1
fac n = n * fac (n-1)

-- main = print (fac 42)
