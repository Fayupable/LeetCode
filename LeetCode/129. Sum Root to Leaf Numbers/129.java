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
    public int sumNumbers(TreeNode root) {
        
        return Srln(root,0);
    }
    public int Srln(TreeNode node,int currentNumber){
        if(node==null){
            return 0;
        }
        currentNumber=currentNumber*10+node.val;
        if(node.left==null&&node.right==null){
            return currentNumber;
        }
        return Srln(node.left, currentNumber) + Srln(node.right, currentNumber);
    }
}