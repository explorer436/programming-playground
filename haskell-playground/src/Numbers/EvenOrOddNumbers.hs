module Numbers.EvenOrOddNumbers where

checkIfNumberIsEvenOrOdd :: Int -> String
checkIfNumberIsEvenOrOdd a = 
    if (mod a 2) == 0
        then "even"
        else "odd"


-- tests
checkIfNumberIsEvenOrOddTest01 = checkIfNumberIsEvenOrOdd 10            

checkIfNumberIsEvenOrOddTest02 = checkIfNumberIsEvenOrOdd 7