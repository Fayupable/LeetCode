#Special Pythagorean Triplet

# A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
# a^2 + b^2 = c^2
# a+b+c=1000

def find_triplet():
    # Iterate through all possible values of a and b
    for a in range(1,1000):
        # b starts at a to avoid duplicate triplets
        for b in range(a,1000):
            # Calculate c based on the given conditions
            c = 1000 - a - b
            # Check if the current values of a, b, and c form a Pythagorean triplet
            if a**2 + b**2 == c**2:
                # Return the product of the triplet
                print(a,b,c)
                return a*b*c
            
print(find_triplet())