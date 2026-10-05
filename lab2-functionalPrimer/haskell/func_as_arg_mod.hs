-- Create a list from a to b
inpFunc a b = [a..b]

-- Calculate the sum or average
applicatorFunc inpFunc a b s =
    if s == 's'
        then sum (inpFunc a b)
        else sum (inpFunc a b) `div` 5

main = do
    -- Ask for a
    putStrLn "Enter a:"
    inputA <- getLine
    let a = read inputA :: Int

    -- Ask for b
    putStrLn "Enter b:"
    inputB <- getLine
    let b = read inputB :: Int

    -- Ask for s
    putStrLn "Enter 's' for sum or 'a' for average:"
    inputS <- getLine
    let s = head inputS

    -- Calculate and display the result
    let result = applicatorFunc inpFunc a b s
    putStrLn ("result = " ++ show result)
