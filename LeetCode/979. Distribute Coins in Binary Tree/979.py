# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def distributeCoins(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.moves = 0  # Variable to store the number of moves

        def dfs(node):
            if not node:  # If the node is null, return 0
                return 0

            # Perform dfs on the left and right children
            left = dfs(node.left)
            right = dfs(node.right)

            # Increment the number of moves by the absolute values of left and right
            self.moves += abs(left) + abs(right)

            # Return the number of coins that need to be moved to/from the current node
            return node.val + left + right - 1

        dfs(root)  # Call the dfs function
        return self.moves  # Return the number of moves