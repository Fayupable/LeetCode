#Power Digit Sum

def power_digit_sum(n):
    return sum([int(x) for x in str(2**n)])

print(power_digit_sum(1000))