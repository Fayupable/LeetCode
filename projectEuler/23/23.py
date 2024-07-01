#Non-Abundant Sums
def aboundant_numbers(n):
    abundants = []
    for i in range(1,n):
        if sum(divisors(i)) > i:
            abundants.append(i)
    return abundants

def divisors(n):
    divs = []
    for i in range(1,n):
        if n%i == 0:
            divs.append(i)
    return divs

def sum_of_abundants(n):
    abundants = aboundant_numbers(n)
    sums = []
    for i in range(len(abundants)):
        for j in range(i,len(abundants)):
            sums.append(abundants[i] + abundants[j])
    return sums


def non_abundant_sums(n):
    sums = sum_of_abundants(n)
    non_abundants = []
    for i in range(1,n):
        if i not in sums:
            non_abundants.append(i)
    return non_abundants

print(sum(non_abundant_sums(28123)))