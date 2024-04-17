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
    public String smallestFromLeaf(TreeNode root) {
     return dfs(root, "");
 }

 private String dfs(TreeNode node, String suffix) {
     if (node == null) return null;

     // Convert the current node's value to the corresponding character
     char currentChar = (char) ('a' + node.val);
     // Append to the beginning since we are building from leaf to root
     String newSuffix = currentChar + suffix;

     if (node.left == null && node.right == null) {
         // If it's a leaf, return the current string
         return newSuffix;
     }

     // Recursively find the smallest string from both children
     String leftSmallest = dfs(node.left, newSuffix);
     String rightSmallest = dfs(node.right, newSuffix);

     // Determine the lexicographically smallest string
     if (leftSmallest == null) return rightSmallest;
     if (rightSmallest == null) return leftSmallest;
     return leftSmallest.compareTo(rightSmallest) <= 0 ? leftSmallest : rightSmallest;
 }
}