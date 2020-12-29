module Strings.ExamScoreProcessing where

{- |
    Source: https://www.haskelltutorials.com/without-theory/lambdas.html

    Exam-score processing
    
    Say, you have parsed the exam-scores of all students from a CSV, and have it in the following data-structure:
    
    [ ("Saurabh Nanda", [("English", 84), ("Chemistry", 80), ("Physics", 95), ("Geography", 75)])
    , ("John Doe", [("Chemistry", 80), ("Physics", 95), ("Geography", 75)])
    , ("Jane Doe", [("Chemistry", 66), ("Phsyics", 33), ("Geography", 56)]) -- Note the spelling error in "Physics"
    , ("John Doe", [("Chemistry", 90), ("Economics", 45), ("Geography", 56)]) -- Note that "John Doe" is a repeat entry
    , ("Bahubali", [("Hindi", 45), ("Biology", -90), ("Geography", -75)]) -- Note the negative marks in "Biology" & "Geography"
    , ("Rajnikant", [("Tamil", 110), ("Biology", 100), ("Geography", 100)]) -- Note that marks in "Tamil" are greater than 100
    ...
    ]
    
    (Can you work out the type of the data-structure given above without inspecting it in GHCi?)
    
    Further, the list of known subjects is also available to you in the following data-structure:
    
    [ "English"
    , "Geography"
    , "Physics"
    , "Chemistry"
    , "Economics"
    , "Computer Science"
    ...
    ]
    Write the following functions:
    
    1. Calculate the average marks for a given subject taking care that invalid entries are not included in the calculation.
      - All scores that are negative should be considered invalid
      - All scores that are greater than 100 should be considered invalid
      - All scores where the subject name is not known should be considered invalid
      - All entries where the student’s name is duplicated should be considered invalid, i.e. none of the scores for those entries should be considered.
    
    2. Calculate the standard deviation for a given subject taking care of invalid entries.
    
    3. List all the students whose names are duplicated
    
    4. List all students, who have invalid scores in any subject, along with the subjects in which they have invalid scores and the reason why the score is considered invalid. For the sample data given above, the result should be:
        [ ("Jane Doe", [("Phsyics", 33, "Unknown subject")]
        , ("Bahubali", [("Biology", -90, "Negative score"), ("Geography", -75, "Negative score")])
        , ("Rajnikant", [("Tamil", 110, "Score is greater than 100")]
        ]
    
    5. Give a list of all subjects and the students who took an exam in that subject, taking care of invalid entries & scores. For example:
        [ ("English", ["Saurabh Nanda"])
        , ("Geography", ["Saurabh Nanda", "Jane Doe", "Rajnikant"])
        , ("Physics", ["Saurabh Nanda"])
        , ("Chemistry", ["Saurabh Nanda", "Jane Doe"]
        , ("Economics", [])
        , ("Computer Science", [])
        ]

    6. Group together all students that have taken the exact same exams, taking care of invalid entries & scores. Invalid scores can be considered as exams not taken. The result should be of the type [([String], [String])] where the first element of each tuple is the list of exams, and the second element is the list of students who have taken those exams.
    
    Follow-up: Generalize your solution for 1, 2, & 4 by writing your own higher-order function. Generalize your solution for 5 & 6 by writing your own higher-order function.
-}
