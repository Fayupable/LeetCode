#Digit Factorials
#145 = 1! + 4! + 5! = 1 + 24 + 120 = 145

def factorial(n):
    if n == 0:
        return 1
    else:
        return n*factorial(n-1)

def sumFactorial(n):
    sum =0
    while n>0:
        sum += factorial(n%10)
        n = n//10
    return sum

def main():
    sum = 0
    for i in range(3,100000):
        if i == sumFactorial(i):
            sum += i
    print(sum)   

if __name__ == "__main__":
    main()
       