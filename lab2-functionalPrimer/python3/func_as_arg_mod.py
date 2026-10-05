import sys

# Create a list of integers from a to b
def listFunc(a, b):
    return [i for i in range(a, b + 1)]

# Calculate the sum or average
def applicatorFunc(inpFunc, a, b, s):
    if s == 's':
        return sum(inpFunc(a, b))
    else:
        return sum(inpFunc(a, b)) / len(inpFunc(a, b))

# Read command-line arguments
a = int(sys.argv[1])
b = int(sys.argv[2])
s = sys.argv[3]

# Calculate the result
result = applicatorFunc(listFunc, a, b, s)

# Display the result
print("result =", result)
