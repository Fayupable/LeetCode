#Find the sum of all the primes below two million.

def isPrime(n):
    if n == 1:
        return False
    if n == 2:
        return True
    if n % 2 == 0:
        return False
    for i in range(3, int(n**0.5)+1, 2):
        if n % i == 0:
            return False
    return True

def sumPrimes(n):
    sum = 0
    for i in range(2, n):
        if isPrime(i):
            sum += i
    return sum

print(sumPrimes(2000000))

