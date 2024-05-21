class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result=[[]]
        for num in nums:
            result+=[i+[num] for i in result]
        return result