/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* removeLeafNodes(TreeNode* root, int target) {
        // If the root is null, return null
        if(root == nullptr){
            return nullptr;
        }
        
        // Recursively call the function on the left child of the current node
        // The function will traverse the left subtree and remove any leaf nodes that have the value `target`
        // The result (which is the root of the modified left subtree) is then assigned back to `root->left`
        root->left = removeLeafNodes(root->left, target);
        root->right = removeLeafNodes(root->right, target);

        // If the current node is a leaf node and its value is the target, remove it by returning null
        if(root->val == target && root->left == nullptr && root->right == nullptr){
            return nullptr;
        } else {
            // If the current node is not a leaf node or its value is not the target, keep it
            return root;
        }
    }
};