#circular primes

def is_prime(n):
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

def is_circular_prime(n):
    s = str(n)
    for i in range(len(s)):
        if not is_prime(int(s)):
            return False
        s = s[1:] + s[0]
    return True

count = 0
for i in range(1, 1000000):
    if is_circular_prime(i):
        count += 1

print(count)