def sum_of_multiples(limit):
    total = 0
    for i in range(1, limit):
        # Check if i is a multiple of 3 or 5
        if i % 3 == 0 or i % 5 == 0:
            total += i
    return total

result = sum_of_multiples(1000)
print(f"Sum of multiples of 3 or 5 below 1000: {result}")
#233168