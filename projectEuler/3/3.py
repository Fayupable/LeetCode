import math

def largest_prime_factor(n):
    largest = -1

    # Divide out the factor of 2
    while n % 2 == 0:
        largest = 2
        n //= 2

    # Divide out odd factors from 3 upwards
    for i in range(3, int(math.sqrt(n)) + 1, 2):
        while n % i == 0:
            largest = i
            n //= i

    # If n is still greater than 2, then it is prime
    if n > 2:
        largest = n

    return largest

number = 600851475143
print(f"The largest prime factor of {number} is {largest_prime_factor(number)}")