# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution(object):
    def delNodes(self, root, to_delete):
        """
        :type root: TreeNode
        :type to_delete: List[int]
        :rtype: List[TreeNode]
        """
        to_delete = set(to_delete)
        res = []

        def dfs(node, is_root):
            if not node:
                return None
            if node.val in to_delete:
                node.left = dfs(node.left, True)
                node.right = dfs(node.right, True)
                return None
            else:
                if is_root:
                    res.append(node)
                node.left = dfs(node.left, False)
                node.right = dfs(node.right, False)
                return node

        dfs(root, True)
        return res
        
        #other people's solution
        '''
        class Solution(object):
    def delNodes(self, root, to_delete):
        """
        :type root: TreeNode
        :type to_delete: List[int]
        :rtype: List[TreeNode]
        """
        if not root:
            return []
        result = []
        to_delete_set = set(to_delete)
        self.dfs(root, to_delete_set, result)
        if root.val not in to_delete_set:
            result.append(root)
        return result
        
    def dfs(self, node, to_delete_set, result):
        if not node:
            return None
        node.left = self.dfs(node.left, to_delete_set, result)
        node.right = self.dfs(node.right, to_delete_set, result)
        if node.val in to_delete_set:
            if node.left:
                result.append(node.left)
            if node.right:
                result.append(node.right)
            return None
        else:
            return node
        '''