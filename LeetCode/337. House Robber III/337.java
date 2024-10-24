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
    public int rob(TreeNode root) {
       int[] result = heist(root);
       return Math.max(result[0], result[1]);
   }

   private int[] heist(TreeNode root) {
       if (root == null) {
           return new int[] { 0, 0 };
       }
       int[] leftSubtree = heist(root.left);
       int[] rightSubtree = heist(root.right);
       int includeRoot = root.val + leftSubtree[1] + rightSubtree[1];
       int excludeRoot = Math.max(leftSubtree[0], leftSubtree[1]) + Math.max(rightSubtree[0], rightSubtree[1]);
       return new int[] { includeRoot, excludeRoot };
   }
}