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

    public int maxPathSum(TreeNode root) {
        int[] maxi= new int[1];   
        maxi[0]= Integer.MIN_VALUE;
        height(root, maxi);
        return maxi[0];
    }

    public int height(TreeNode root, int[] maxi) {
        if(root == null) return 0;

        int left= Math.max(0 , height(root.left, maxi));  
        int right= Math.max(0 , height(root.right, maxi));
        maxi[0]= Math.max(maxi[0], left + right + root.val);   
        return root.val + Math.max(left , right);
    }
}