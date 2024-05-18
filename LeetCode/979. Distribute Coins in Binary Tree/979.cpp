/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val; // Value of the node
 *     TreeNode *left; // Pointer to the left child
 *     TreeNode *right; // Pointer to the right child
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {} // Default constructor
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {} // Constructor that sets the value
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {} // Constructor that sets the value and the children
 * };
 */
class Solution {
public:
    int moves =0; // Variable to store the number of moves

    // Function to distribute coins
    int distributeCoins(TreeNode* root) {
        dfs(root, moves); // Call the dfs function
        return moves; // Return the number of moves
    }

private:
    // Function to perform depth-first search
    int dfs(TreeNode* root, int& moves){
        if(root == NULL) return 0; // If the node is null, return 0

        // Perform dfs on the left and right children
        int left = dfs(root->left, moves);
        int right = dfs(root->right, moves);

        // Increment the number of moves by the absolute values of left and right
        moves += abs(left) + abs(right);

        // Return the number of coins that need to be moved to/from the current node
        return root->val + left + right - 1;
    }
};