#Quadratic Primes

def is_prime(n):
    """Check if a number is prime."""
    if n <= 1:
        return False
    if n <= 3:
        return True
    if n % 2 == 0 or n % 3 == 0:
        return False
    i = 5
    while i * i <= n:
        if n % i == 0 or n % (i + 2) == 0:
            return False
        i += 6
    return True

def consecutive_primes(a, b):
    """Find the number of consecutive primes produced by the quadratic formula n^2 + an + b."""
    n = 0
    while True:
        result = n * n + a * n + b
        if not is_prime(result):
            break
        n += 1
    return n

def find_best_coefficients(limit):
    """Find the coefficients a and b that produce the maximum number of consecutive primes."""
    max_a = 0
    max_b = 0
    max_primes = 0

    for a in range(-limit + 1, limit):
        for b in range(-limit, limit + 1):
            primes = consecutive_primes(a, b)
            if primes > max_primes:
                max_primes = primes
                max_a = a
                max_b = b

    return max_a, max_b, max_primes

# Main execution
limit = 1000
a, b, num_primes = find_best_coefficients(limit)
print(f"The product of the coefficients a and b that produces the maximum number of primes is: {a * b}")
print(f"a: {a}, b: {b}, number of primes: {num_primes}")