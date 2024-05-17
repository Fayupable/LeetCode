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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        // If the root is null, return null
        if(root==null){
            return null;
        }
        
        // Recursively call the function on the left child of the current node
        // The function will traverse the left subtree and remove any leaf nodes that have the value `target`
        // The result (which is the root of the modified left subtree) is then assigned back to `root.left`
        root.left=removeLeafNodes(root.left, target);
        root.right=removeLeafNodes(root.right, target);

        // If the current node is a leaf node and its value is the target, remove it by returning null
        if ((root.val==target) && (root.left==null) && (root.right==null)) {
            return null;
        } else {
            // If the current node is not a leaf node or its value is not the target, keep it
            return root;
        }
    }
}