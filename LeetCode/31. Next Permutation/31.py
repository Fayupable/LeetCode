class Solution(object):
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        n=len(nums)
        i=n-2

        #find the decreasing num
        while i>=0 and nums[i]>=nums[i+1]:
            i-=1
        
        if i==-1:
            nums.reverse()
            return
        #find the larger than the found el
        j=n-1
        while nums[j]<=nums[i]:
            j-=1
        #swap
        nums[i],nums[j]=nums[j],nums[i]

        #reverse
        nums[i+1:] = reversed(nums[i+1:])
