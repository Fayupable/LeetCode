class Solution(object):
    def specialArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        for x in range(len(nums) + 1):
            if sum(i >= x for i in nums) == x:
                return x
        return -1
    

    '''
    class Solution(object):
    def specialArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # Sort the array in non-decreasing order
        nums.sort()
        # Get the length of the array
        n = len(nums)
        
        # Iterate through the sorted array
        for i in range(n):
            # Check if the current element is greater than or equal to the number of elements remaining in the array
            if nums[i] >= n - i:
                # Check if the current element is the first element or if the previous element is smaller than the count
                if i == 0 or nums[i-1] < n - i:
                    # If conditions are met, return the count
                    return n - i
        # If no such number is found, return -1
        return -1
    '''

    '''
    class Solution:
    def specialArray(self, nums: List[int]) -> int:
        nums.sort()
        n = len(nums)
    
        for x in range(1, n + 1):
            count = 0
            for num in nums:
                if num >= x:
                    count += 1
            if count == x:
                return x
        return -1
    '''