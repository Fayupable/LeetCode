# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def sumOfLeftLeaves(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def sumOfLeft(node,isLeft):
            if node is None:
                return 0
            if node.left is None and node.right is None:
                if isLeft:
                    return node.val
                else:
                    return 0
            leftSum = sumOfLeft(node.left, True)
            rightSum = sumOfLeft(node.right, False)
            
            return leftSum + rightSum

        return sumOfLeft(root,False)
    
    
    