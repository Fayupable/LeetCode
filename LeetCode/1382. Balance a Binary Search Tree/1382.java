/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        // Perform inorder traversal to get sorted elements
        inorder(root, list);
        
        // Build balanced BST from sorted elements
        return buildBalancedBST(list, 0, list.size() - 1);
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        
        inorder(root.left, list);  // Traverse left subtree
        list.add(root.val);        // Add root value
        inorder(root.right, list); // Traverse right subtree
    }

    private TreeNode buildBalancedBST(List<Integer> list, int start, int end) {
        if (start > end) return null;
        
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        
        root.left = buildBalancedBST(list, start, mid - 1); // Build left subtree
        root.right = buildBalancedBST(list, mid + 1, end);  // Build right subtree
        
        return root;
    }
}

//other people's solution
/*
 class Solution {
    public TreeNode balanceBST(TreeNode root) {
        inOrder(root);
        return bst(0, ordered.size() - 1);
    }
    private TreeNode bst(int start, int end) {
        if (start > end) return null;
        else if (start == end) {
            TreeNode ret = ordered.get(start);
            ret.left = null;
            ret.right = null;
            return ret;
        } else {
            int mid = start + (end - start) / 2;
            TreeNode ret = ordered.get(mid);
            ret.left = bst(start, mid - 1);
            ret.right = bst(mid + 1, end);
            return ret;
        }
    }
    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        ordered.add(node);
        inOrder(node.right);
    }
    private List<TreeNode> ordered = new ArrayList<>();
}
 */