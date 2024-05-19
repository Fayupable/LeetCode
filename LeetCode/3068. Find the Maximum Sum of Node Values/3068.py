from collections import defaultdict

class Solution(object):
    def maximumValueSum(self, nums, k, edges):
        """
        :type nums: List[int]
        :type k: int
        :type edges: List[List[int]]
        :rtype: int
        """
        # Step 1: Calculate the initial sum of the nums array
        total = sum(nums)
        
        # Initialize variables to keep track of the total positive difference
        total_diff = 0
        positive_count = 0
        min_abs_diff = float('inf')
        
        # Step 2: Iterate over the nums array to calculate differences
        for num in nums:
            diff = (num ^ k) - num
            
            if diff > 0:
                total_diff += diff
                positive_count += 1
            min_abs_diff = min(min_abs_diff, abs(diff))
        
        # Step 3: Adjust the total difference if the count of positive differences is odd
        if positive_count % 2 == 1:
            total_diff -= min_abs_diff
        
        # Step 4: Calculate the maximum possible sum
        return total + total_diff