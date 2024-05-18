/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val; // Value of the node
 *     TreeNode left; // Pointer to the left child
 *     TreeNode right; // Pointer to the right child
 *     TreeNode() {} // Default constructor
 *     TreeNode(int val) { this.val = val; } // Constructor that sets the value
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val; // Set the value
 *         this.left = left; // Set the left child
 *         this.right = right; // Set the right child
 *     }
 * }
 */
class Solution {
    int moves = 0; // Variable to store the number of moves

    // Function to distribute coins
    public int distributeCoins(TreeNode root) {
        dfs(root); // Call the dfs function
        return moves; // Return the number of moves
    }

    // Function to perform depth-first search
    private int dfs(TreeNode node){
        if(node == null){ // If the node is null, return 0
            return 0;
        } 
        // Perform dfs on the left and right children
        int left = dfs(node.left);
        int right = dfs(node.right);

        // Increment the number of moves by the absolute values of left and right
        moves += Math.abs(left) + Math.abs(right);

        // Return the number of coins that need to be moved to/from the current node
        return node.val + left + right - 1;
    }
}