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
    bool evaluateTree(TreeNode* root) {
        if (root->val == 0) {
            return false;
        }
        if (root->val == 1) {
            return true;
        }
        
        bool leftEval = evaluateTree(root->left);
        bool rightEval = evaluateTree(root->right);
        
        if (root->val == 2) {
            return leftEval || rightEval;
        }
        if (root->val == 3) {
            return leftEval && rightEval;
        }
        
        return false; // This line should never be reached as per the problem constraints
    }
};
