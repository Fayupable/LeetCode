# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def removeLeafNodes(self, root, target):
        """
        :type root: TreeNode
        :type target: int
        :rtype: TreeNode
        """
        # if root is null, return None
        if root is None:
            return None

        
        # Recursively call the function on the left child of the current node
        # The function will traverse the left subtree and remove any leaf nodes that have the value `target`
        # The result (which is the root of the modified left subtree) is then assigned back to `root.left`
        root.left=self.removeLeafNodes(root.left,target)
        root.right=self.removeLeafNodes(root.right,target)

        # if the root is a leaf node and its value is equal to target, return None
        if root.left is None and root.right is None and root.val==target:
            return None
        else:
            return root
        