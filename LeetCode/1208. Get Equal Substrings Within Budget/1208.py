# for python 
#Time complexity : O(n)
class Solution(object):
    def equalSubstring(self, s, t, maxCost):
        """
        :type s: str
        :type t: str
        :type maxCost: int
        :rtype: int
        """
        # Calculate the absolute difference between ASCII values of characters in s and t
        diff = [abs(ord(a) - ord(b)) for a, b in zip(s, t)]
        
        # Initialize the left pointer of the sliding window
        left = 0
        
        # Iterate over the diff list with the right pointer
        for right in range(len(diff)):
            # Subtract the current diff value from maxCost
            maxCost -= diff[right]
            
            # If maxCost is less than 0, move the left pointer to the right and add the diff value at the left pointer to maxCost
            if maxCost < 0:
                maxCost += diff[left]
                left += 1
                
        # Return the maximum length of a substring that can be changed to be the same as the corresponding substring of t with a cost less than or equal to maxCost
        return right - left + 1
    

'''
Time complexity : O(n) 
for pyython3
class Solution:
    def equalSubstring(self, s: str, t: str, maxCost: int) -> int:
        # Calculate the absolute difference between ASCII values of characters in s and t
        diff = [abs(ord(a) - ord(b)) for a, b in zip(s, t)]
        
        # Initialize the left pointer of the sliding window
        left = 0
        
        # Iterate over the diff list with the right pointer
        for right in range(len(diff)):
            # Subtract the current diff value from maxCost
            maxCost -= diff[right]
            
            # If maxCost is less than 0, move the left pointer to the right and add the diff value at the left pointer to maxCost
            if maxCost < 0:
                maxCost += diff[left]
                left += 1
                
        # Return the maximum length of a substring that can be changed to be the same as the corresponding substring of t with a cost less than or equal to maxCost
        return right - left + 1
'''