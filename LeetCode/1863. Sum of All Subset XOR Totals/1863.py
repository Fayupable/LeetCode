class Solution(object):
    def subsetXORSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # 'bits' will store the bitwise OR of all numbers
        bits = 0
        for n in nums:
            # Accumulate set bits across all numbers
            bits = bits | n        
            # Return the total sum by multiplying 'bits' by 2 raised to the power of (length of 'nums' - 1)
        return bits * 2**(len(nums)-1)