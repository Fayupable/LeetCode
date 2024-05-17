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
        if root is None:
            return None
        root.left=self.removeLeafNodes(root.left,target)
        root.right=self.removeLeafNodes(root.right,target)

        if root.left is None and root.right is None and root.val==target:
            return None
        else:
            return root
        