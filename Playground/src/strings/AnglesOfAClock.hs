{- |
    Hi, here's your problem today. This problem was recently asked by Microsoft:
    
    Given a time in the format of hour and minute, calculate the angle of the hour and minute hand on a clock.
    
    def calcAngle(h, m):
      # Fill this in.
    
    print calcAngle(3, 30)
    # 75
    print calcAngle(12, 30)
    # 165
-}

minutesAngle :: (Integral b, Integral a) => a -> b
minutesAngle n = floor $ (fromIntegral n) * (360 / 60)
testMinutesAngle01 = minutesAngle 15 -- 90.0
testMinutesAngle02 = minutesAngle 27 -- 162.0
testMinutesAngle03 = minutesAngle 55 -- 330.0

hoursAngle :: (Integral b, Integral a1, Integral a2) => a1 -> a2 -> b
hoursAngle h m = floor $ ((fromIntegral (h `mod` 12)) * (360 / 12)) + (fromIntegral m * (30 / 60))
testHoursAngle01 = hoursAngle 3 0 -- 90.0
testHoursAngle02 = hoursAngle 3 30 -- 105.0
testHoursAngle03 = hoursAngle 15 0 -- 90.0

calcAngle :: (Integral a1, Integral a2, Integral a3) => (a2, a3) -> a1
calcAngle t = abs $ (hoursAngle (fst t) (snd t)) - minutesAngle (snd t)
testCalcAngle01 = calcAngle (3, 30) -- 75.0
testCalcAngle02 = calcAngle (12, 30) -- 165.0

{- |
    Reference : https://wiki.haskell.org/Converting_numbers
    
    Conversion between numerical types in Haskell must be done explicitly. 
    This is unlike many traditional languages (such as C or Java) that automatically coerce between numerical types.
    
    Integral types contain only whole numbers and not fractions. The most commonly used integral types are:
        Integer and
        Int
    
    The workhorse for converting from integral types is fromIntegral, which will convert from any Integral type into any Numeric type (which includes Int, Integer, Rational, and Double).
    fromIntegral :: (Num b, Integral a) => a -> b

    For example, given an Int value n, one does not simply take its square root by typing sqrt n, since sqrt can only be applied to Floating-point numbers. Instead, one must write sqrt (fromIntegral n) to explicitly convert n to a floating-point number.

    http://zvon.org/other/haskell/Outputprelude/J_o.html
    Similarly, division can only be applied to Floating-point numbers.
    Note : http://zvon.org/other/haskell/Outputprelude/J_o.html is different from http://zvon.org/other/haskell/Outputprelude/div_f.html

    http://zvon.org/other/haskell/Outputprelude/floor_f.html-
    Description:	returns the greatest integer not greater than argument
-}
