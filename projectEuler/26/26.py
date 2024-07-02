def get_recurring_cycle_length(d):
    """Return the length of the recurring cycle in the decimal fraction of 1/d."""
    remainders = {}
    value = 1
    position = 0

    while value != 0:
        if value in remainders:
            return position - remainders[value]
        remainders[value] = position
        value = (value * 10) % d
        position += 1

    return 0

def find_longest_recurring_cycle(limit):
    """Find the number less than limit with the longest recurring cycle in its decimal fraction part."""
    max_length = 0
    max_d = 0
    for d in range(2, limit):
        cycle_length = get_recurring_cycle_length(d)
        if cycle_length > max_length:
            max_length = cycle_length
            max_d = d

    return max_d

limit = 1000
result = find_longest_recurring_cycle(limit)
print(f"The value of d < {limit} for which 1/d has the longest recurring cycle is: {result}")