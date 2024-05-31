class Solution:
    def singleNumber(self, nums):
        # Step 1: XOR all the elements
        xor_all = 0
        for num in nums:
            xor_all ^= num
        
        # Step 2: Find the rightmost set bit in xor_all
        rightmost_set_bit = xor_all & -xor_all
        
        # Step 3: Partition the numbers into two groups and XOR each group
        num1, num2 = 0, 0
        for num in nums:
            if num & rightmost_set_bit:
                num1 ^= num
            else:
                num2 ^= num
        
        return [num1, num2]

#other people's solution
'''
class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        d={}
        l=[]
        for i in nums:
            if i in d:
                d[i]+=1
            else:
                d[i]=1
        for k,v in d.items():
            if(v==1):
                l.append(k)
        return l
'''
'''
class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        res = []
        for i in nums:
            try:
                res.remove(i)
            except:
                res.append(i)
        return res
'''
'''
class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        seen = []
        for n in nums:
            if n not in seen:
                seen.append(n)
            else:
                seen.remove(n)
        return seen
'''
'''
class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        a=[]
        for n in nums:
            if nums.count(n)==1:
                a.append(n)
        return a
        
'''