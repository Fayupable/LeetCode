# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def smallestFromLeaf(self, root):
        """
        :type root: TreeNode
        :rtype: str
        """
        return self.dfs(root, "")
    
    def dfs(self, node, suffix):
        if not node:
            return None
        
        # Convert the current node's value to the corresponding character
        current_char = chr(node.val + ord('a'))
        # Append to the beginning since we are building from leaf to root
        new_suffix = current_char + suffix
        
        if not node.left and not node.right:  # If it's a leaf node
            return new_suffix
        
        # Recursively find the smallest string from both children
        left_smallest = self.dfs(node.left, new_suffix)
        right_smallest = self.dfs(node.right, new_suffix)
        
        # Determine the lexicographically smallest string
        if left_smallest is None:
            return right_smallest
        if right_smallest is None:
            return left_smallest
        return min(left_smallest, right_smallest)