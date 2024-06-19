# Import the gcd function from the math module
from math import gcd

# Define a function that takes two numbers as input and returns their least common multiple (LCM)
def lcm(a, b):
    # The LCM of two numbers is their product divided by their greatest common divisor (GCD)
    return a * b // gcd(a, b)

# Define a function that takes a list of numbers as input and returns the LCM of all the numbers
def lcm_multiple(numbers):
    # Initialize the result as the first number in the list
    result = numbers[0]
    # Iterate over the rest of the numbers in the list
    for number in numbers[1:]:
        # Update the result to the LCM of the current result and the current number
        result = lcm(result, number)
    # Return the result
    return result

# Create a list of all the numbers from 1 to 20
numbers = list(range(1, 21))
# Calculate the LCM of all the numbers in the list
result = lcm_multiple(numbers)

# Print the result
print(f"The smallest positive number that is evenly divisible by all of the numbers from 1 to 20 is: {result}")