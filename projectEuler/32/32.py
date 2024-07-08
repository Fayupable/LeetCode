# Pandigital Products
# We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.
# The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.
# Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.


def find_pandigital_products():
    products = set()
    # Loop through all possible numbers
    for i in range(1, 100):
        for j in range(i, 10000):
            product = i * j
            if is_pandigital(i, j, product):
                products.add(product)
    return sum(products)
# Check if the product is pandigital
def is_pandigital(i, j, product):
    # Concatenate the three numbers
    digits = str(i) + str(j) + str(product)
    # Check if the length is 9 and if there are no zeros
    if len(digits) != 9:
        return False
    return len(set(digits)) == 9 and '0' not in digits

print(find_pandigital_products())