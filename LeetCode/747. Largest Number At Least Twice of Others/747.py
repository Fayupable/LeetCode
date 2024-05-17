class Solution(object):
    def dominantIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max_val=max(nums)
        max_index=nums.index(max_val)

        for i in range(len(nums)):
            if i!=max_index and nums[i]*2>max_val:
                return -1
        return max_index

        