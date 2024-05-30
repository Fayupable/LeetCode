class Solution(object):
    def findMaxK(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # Convert the list of numbers into a set for faster lookup
        num_set = set(nums)

        # Initialize max_k to -1. This variable will keep track of the maximum number that also has its negative in the list.
        max_k = -1

        # Iterate over all numbers in the list
        for num in nums:
            # If the number is positive and its negative is in the set
            if num > 0 and -num in num_set:
                # Update max_k with the maximum of max_k and the current number
                max_k = max(max_k, num)

        # Return max_k, which is the maximum number that also has its negative in the list, or -1 if there is no such number
        return max_k