# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def S(node,currentNumber):
            if not node:
                return 0
            currentNumber=currentNumber*10+node.val
            if not node.left and not node.right:
                return currentNumber
            return S(node.left,currentNumber)+S(node.right,currentNumber)
        return S(root,0)