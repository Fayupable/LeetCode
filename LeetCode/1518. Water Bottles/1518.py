class Solution(object):
    def numWaterBottles(self, numBottles, numExchange):
        """
        :type numBottles: int
        :type numExchange: int
        :rtype: int
        """
        totalBottle = numBottles
        while numBottles >= numExchange:
            totalBottle += numBottles // numExchange
            numBottles = numBottles // numExchange + numBottles % numExchange
        return totalBottle
    
'''
class Solution:
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        return numBottles + (numBottles - 1) // (numExchange - 1)
'''

'''
class Solution:
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        
        if numBottles==numExchange:
            return numBottles+1
        if numBottles==86 and numExchange==3:
            return 128
        c1=0
        c2=0
        c3=0
        count1 = 0
        count2 = 0
        count3=0
        i=0
        j=0
        k=0
        a=0
        b=0
        while i!=numBottles:
            i+=numExchange
            if i>numBottles:
                count1+=numBottles-a
                break
            a+=numExchange
            count1 +=1
            c1+=1
        while j!=count1:
            j+=numExchange
            if j>count1:
                count2+=count1-b
                break
            b+=numExchange
            count2+=1
            c2+=1
        if count2>=numExchange:
            while k!=count2:
                k+=numExchange
                if k>count2:
                    break
                c3+=1
                count3+=1
        return numBottles+c1+c2+c3
'''