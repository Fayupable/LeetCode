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
    public boolean evaluateTree(TreeNode root) {
        if (root.val == 0) {
            return false;
        }
        if (root.val == 1) {
            return true;
        }
        
        boolean leftEval = evaluateTree(root.left);
        boolean rightEval = evaluateTree(root.right);
        
        if (root.val == 2) {
            return leftEval || rightEval;
        }
        if (root.val == 3) {
            return leftEval && rightEval;
        }
        
        return false; // This line should never be reached as per the problem constraints
    }
}
