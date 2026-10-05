module Main where

-- 'sort' is not in the Prelude; it comes from Data.List.
import Data.List (sort)

-- Sort into descending order.
-- The composition (reverse . sort) is a pipeline: the list is first
-- sorted ascending by 'sort', then that result is passed to 'reverse'.
desort :: Ord a => [a] -> [a]
desort = reverse . sort

-- Example: the unordered list below sorted from 10 down to 1.
countdown :: [Int]
countdown = desort [2,8,7,10,1,9,5,3,4,6]

main :: IO ()
main = print countdown
