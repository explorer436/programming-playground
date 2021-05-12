module Numbers.Absolute (absolute) where

absolute :: Int -> Int
absolute n = if n < 0 then negate n else n
