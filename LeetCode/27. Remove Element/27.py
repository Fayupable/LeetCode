class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        # Initialize the counter k
        k = 0

        # Iterate over the list
        for num in nums:
            # If the current element is not equal to the value to be removed
            if num != val:
                # Replace the element at the position of the counter with the current element
                nums[k] = num
                # Increment the counter
                k += 1

        # Return the counter
        return k