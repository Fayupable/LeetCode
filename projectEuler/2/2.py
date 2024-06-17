def sum_of_even_fibonacci(limit):
    a, b = 1, 2
    total = 0
    while a <= limit:
        if a % 2 == 0:
            total += a
        a, b = b, a + b
    return total

result = sum_of_even_fibonacci(4000000)
print(f"Sum of even-valued terms in Fibonacci sequence below 4 million: {result}")
#4613732