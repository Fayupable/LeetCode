#Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

# The sum of the squares of the first n natural numbers is given by the formula n(n+1)(2n+1)/6
def sumOfSquares(n):
    return n*(n+1)*(2*n+1)/6
# The square of the sum of the first n natural numbers is given by the formula (n(n+1)/2)^2
def squareOfSum(n):
    return (n*(n+1)/2)**2
# The difference between the sum of the squares and the square of the sum is given by the difference of the two formulas
def difference(n):
    return squareOfSum(n) - sumOfSquares(n)
# Test the function with n = 100
print(difference(100))

