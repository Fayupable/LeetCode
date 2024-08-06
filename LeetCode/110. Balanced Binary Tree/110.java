/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkAndGetHeight(root) != -1;
    }

    private int checkAndGetHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // The tree is not balanced
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        if (leftHeight == -1) {
            return -1; // Propagate failure if the left subtree is not balanced
        }

        int rightHeight = getHeight(node.right);
        if (rightHeight == -1) {
            return -1; // Propagate failure if the right subtree is not balanced
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Current node is not balanced
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}

/*

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        if (Math.abs(rh - lh) > 1)
            return false;
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);

        if (!left || !right)
            return false;

        return true;
    }

    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        int lh=maxDepth(root.left);
        int rh=maxDepth(root.right);

        return 1+Math.max(lh,rh);
    }
}*/