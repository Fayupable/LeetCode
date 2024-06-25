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
    int sum = 0;
public:
    TreeNode* bstToGst(TreeNode* root) {
        if (root != nullptr) {
            // Traverse the right subtree first
            bstToGst(root->right);
            
            // Update the current node
            sum += root->val;
            root->val = sum;
            
            // Traverse the left subtree
            bstToGst(root->left);
        }
        return root;
    }
};



//other poeples solution
/*
class Solution {
public:
    TreeNode* bstToGst(TreeNode* root) {
        int acc_sum = 0;
        sum_node(root,acc_sum);
        return root;
    }
    
    void sum_node(TreeNode* node, int& acc_sum){
        if (node == NULL)  return;
        sum_node(node->right,acc_sum);
        node->val += acc_sum;
        acc_sum = node->val;
        sum_node(node->left, acc_sum);
    }
};
*/
/*
class Solution {
public:

    int sum(TreeNode* root,vector<int> in){
        if(root==NULL){
            return 0;
        }
        int sum=0;
        for(int i=0;i<in.size();i++){
            if(in[i]>root->val){
                sum+=in[i];
            }
        }
        return sum;
    }

    void BST(TreeNode*& root,vector<int> in){
        if(root==NULL){
            return;
        }
        root->val+=sum(root,in);
        BST(root->left,in);
        BST(root->right,in);
    }

    void inorder(TreeNode* root,vector<int>& in){
        if(root==NULL){
            return;
        }
        inorder(root->left,in);
        in.push_back(root->val);
        inorder(root->right,in);
    }

    TreeNode* bstToGst(TreeNode* root) {
        vector<int> in;
        inorder(root,in);
        BST(root,in);
        return root;
    }
};
*/