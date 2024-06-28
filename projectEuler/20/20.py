#Factorial Digit Sum

def factorial(n):
    if n ==0:
        return 1
    else:
        return n*factorial(n-1)
    
def sum_of_digits(n):
    sum = 0
    #convert n to string to iterate over each digit
    for i in str(n):
        #convert each digit back to int and add to sum
        sum += int(i)
    return sum

print(sum_of_digits(factorial(100)))