module MySolutions.Numbers.CalculateEndTimeByStartTimeAndDuration where

-- Let’s understand by using divMod in a real-world example of time arithemetic. 
-- Say, you want to write a function that calculates the end-time of an event, given the start-time and the duration of the event (in minutes):

calculateEndTime :: Int -> Int -> Int -> (Int, Int)
calculateEndTime hr mn durationInMins =
  let (addHour, finalMins) = divMod (mn + durationInMins) 60
  in (hr + addHour, finalMins)

testCalculateEndTime01 = calculateEndTime 10 30 45
-- (11, 15)

testCalculateEndTime02 = calculateEndTime 10 30 115
-- (12, 25)
