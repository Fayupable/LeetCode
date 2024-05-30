class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # If the list is empty, return 0
        if not nums:
            return 0

        # Initialize the counter i
        i = 0

        # Iterate over the list starting from the second element
        for j in range(1, len(nums)):
            # If the current element is not equal to the previous one
            if nums[j] != nums[i]:
                # Increment the counter
                i += 1
                # Replace the element at the next position of the counter with the current element
                nums[i] = nums[j]

        # Return the counter incremented by 1 (because it's zero-indexed)
        return i + 1