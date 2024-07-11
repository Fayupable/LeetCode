#Truncatable Primes
# Find the sum of the only eleven primes that are both truncatable from left to right and right to left.


def is_prime(n):
    if n < 2:
        return False
    if n == 2:
        return True
    if n % 2 == 0:
        return False
    for i in range(3, int(n**0.5)+1, 2):
        if n % i == 0:
            return False
    return True

def is_truncatable_prime(n):
    if not is_prime(n):
        return False
    s = str(n)
    for i in range(1, len(s)):
        if not is_prime(int(s[i:])):
            return False
        if not is_prime(int(s[:-i])):
            return False
    return True

def truncatable_primes():
    count = 0
    i = 11
    total = 0
    while count < 11:
        if is_truncatable_prime(i):
            count += 1
            total += i
        i += 2
    return total

print(truncatable_primes())
