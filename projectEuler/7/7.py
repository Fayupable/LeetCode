#What is the 10001st prime number?

# Returns True if n is prime, False otherwise
def isPrime(n):
    if n == 2:
        return True
    if n < 2 or n % 2 == 0:
        return False
    # Check divisibility by odd numbers up to the square root of n
    for i in range(3, int(n**0.5)+1, 2):
        # If n is divisible by i, it is not prime
        if n % i == 0:
            return False
    return True

def nthPrime(n):
    primes = 0
    i = 2
    while primes < n:
        if isPrime(i):
            # Increment the number of primes found
            primes += 1
        # If the number of primes found is equal to n, return i
        i += 1
    return i-1

print(nthPrime(10001))

