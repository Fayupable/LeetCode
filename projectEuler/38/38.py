def is_pandigital(num_str):
    """Check if a number string is 1 to 9 pandigital."""
    return len(num_str) == 9 and set(num_str) == set("123456789")

def concatenated_product(num, n):
    """Return the concatenated product of num and (1, 2, ..., n)."""
    concatenated = ''.join(str(num * i) for i in range(1, n + 1))
    return concatenated

def largest_pandigital():
    largest = 0

    # We only need to check numbers up to 9999
    for num in range(1, 10000):
        concatenated = ""
        n = 1
        while len(concatenated) < 9:
            concatenated += str(num * n)
            n += 1
        if is_pandigital(concatenated):
            largest = max(largest, int(concatenated))

    return largest

# Find the largest 1 to 9 pandigital 9-digit number
result = largest_pandigital()
print(f"The largest 1 to 9 pandigital 9-digit number is: {result}")