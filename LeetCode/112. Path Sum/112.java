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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return hasPathSumHelper(root, targetSum);
    }

    // Helper function to check if there is a path with the given sum
    private boolean hasPathSumHelper(TreeNode node, int remainingSum) {
        if (node == null) {
            return false;
        }

        if (isLeafNode(node) && node.val == remainingSum) {
            return true;
        }
        int newRemainingSum = remainingSum - node.val;
        return hasPathSumHelper(node.left, newRemainingSum) || hasPathSumHelper(node.right, newRemainingSum);
    }

    // Function to check if a node is a leaf node
    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}