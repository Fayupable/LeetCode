#Digit Cancelling Fractions
# Problem: The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.
# We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
#If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
from fractions import Fraction

def find_digit_cancelling_fractions():
    product = Fraction(1, 1)  # Start with a fraction of 1 to multiply with
    for numerator in range(10, 100):
        for denominator in range(numerator + 1, 100):  # Ensure fraction is less than 1
            n_str, d_str = str(numerator), str(denominator)
            for digit in n_str:
                if digit in d_str and digit != '0':  # Check for common digit and ignore '0'
                    n_new, d_new = n_str.replace(digit, '', 1), d_str.replace(digit, '', 1)
                    if n_new and d_new and d_new != '0':  # Avoid division by zero
                        fraction_original = Fraction(numerator, denominator)
                        fraction_new = Fraction(int(n_new), int(d_new))
                        if fraction_original == fraction_new:  # Check if fractions are equal
                            product *= fraction_original
    return product.denominator

# Find the denominator of the product of the digit-cancelling fractions in its lowest terms
denominator = find_digit_cancelling_fractions()
print(denominator)