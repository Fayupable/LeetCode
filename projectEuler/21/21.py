#Amicable Numbers

def sumOfDivisors(n):
    sum = 0
    for i in range(1,n):
        if n%i == 0:
            sum += i
    return sum

def amicableNumbers(n):
    sum = 0
    for i in range(1,n):
        if sumOfDivisors(sumOfDivisors(i)) == i and sumOfDivisors(i) != i:
            sum += i
    return sum

print(amicableNumbers(10000))


