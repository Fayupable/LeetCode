def count_divisors(n):
    count = 0
    sqrt_n = int(n ** 0.5)
    for i in range(1, sqrt_n + 1):
        if n % i == 0:
            count += 2  # i and n // i
    if sqrt_n * sqrt_n == n:
        count -= 1  # Correct the double count if n is a perfect square
    return count

def find_triangle_number_with_divisors(divisor_limit):
    n = 1
    while True:
        triangle_number = n * (n + 1) // 2
        if count_divisors(triangle_number) > divisor_limit:
            return triangle_number
        n += 1

# Find the first triangle number with over 500 divisors
divisor_limit = 500
result = find_triangle_number_with_divisors(divisor_limit)
print(f"The first triangle number with over {divisor_limit} divisors is: {result}")