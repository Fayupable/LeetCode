class Solution(object):
    def fib(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 0:
            return 0
        if n == 1:
            return 1
        a, b = 0, 1
        for i in range(2, n+1):
            a, b = b, a+b
        return b
    

class Solution:
    def fib(self, n: int) -> int:
        fib =0
        a =1

        for i in range(n):
            temp = fib +a 
            fib = a
            a = temp
        return fib
    

'''
class Solution:
    def fib(self, n: int) -> int:
        mylist = [-1]*(n+1)
        mylist[0] = 0
        if n > 0:
            mylist[1] = 1
            for j in range(2, n+1):
                mylist[j] = mylist[j-1] + mylist[j-2]
        return mylist[n]
        
'''
'''
from numpy import sqrt, power, dot, array
class Solution:
    def fib(self, n: int) -> int:
        c1 = 2/(sqrt(5)+5)
        c2 = 2/(5-sqrt(5))
        c = array([c1, c2])
        lambda1 = (1 + sqrt(5))/2
        lambda2 = (1 - sqrt(5))/2
        l = array([lambda1, lambda2])
        return round(dot(power(l, n+1), c))
'''
'''
class Solution:
    def fib(self, n):
        if n<=1:
            return n
        else:
            return (Solution.fib(self, n-1) + Solution.fib(self, n-2))
'''