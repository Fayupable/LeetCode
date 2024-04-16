# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def addOneRow(self, root, val, depth):
        if depth == 1:
            new_root = TreeNode(val)
            new_root.left = root
            return new_root
        
        def addRow(node, current_depth):
            if node is None:
                return
            if current_depth == depth - 1:
                new_left = TreeNode(val, node.left, None)
                new_right = TreeNode(val, None, node.right)
                node.left = new_left
                node.right = new_right
            else:
                addRow(node.left, current_depth + 1)
                addRow(node.right, current_depth + 1)
        
        addRow(root, 1)
        return root