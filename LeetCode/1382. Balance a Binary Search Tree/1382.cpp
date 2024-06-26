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
    TreeNode* balanceBST(TreeNode* root) {
        vector<int> list;
        
        // Perform inorder traversal to get sorted elements
        inorder(root, list);
        
        // Build balanced BST from sorted elements
        return buildBalancedBST(list, 0, list.size() - 1);
    }

private:
    void inorder(TreeNode* root, vector<int>& list) {
        if (root == nullptr) return;
        
        inorder(root->left, list);  // Traverse left subtree
        list.push_back(root->val);  // Add root value
        inorder(root->right, list); // Traverse right subtree
    }

    TreeNode* buildBalancedBST(const vector<int>& list, int start, int end) {
        if (start > end) return nullptr;
        
        int mid = start + (end - start) / 2;
        TreeNode* root = new TreeNode(list[mid]);
        
        root->left = buildBalancedBST(list, start, mid - 1); // Build left subtree
        root->right = buildBalancedBST(list, mid + 1, end);  // Build right subtree
        
        return root;
    }
};

//other people's solution
/*
class Solution {
    void inorder(TreeNode* root , vector<TreeNode*> &nodes){
        if(root==NULL) return ;
        inorder(root->left,nodes);
        nodes.push_back(root);
        inorder(root->right,nodes);
    }
    TreeNode* solve(vector<TreeNode*> &nodes,int start , int end){
        if(end<start) return NULL;
        int mid = (end-start)/2+start;
        TreeNode* root = nodes[mid];
        root->left = solve(nodes,start,mid-1);
        root->right = solve(nodes,mid+1,end);
        return root;
    }

public:
    TreeNode* balanceBST(TreeNode* root) {
        if(root==NULL) return NULL;
        vector<TreeNode*> inorder_traversal;
        inorder(root,inorder_traversal);
        return solve(inorder_traversal,0,inorder_traversal.size()-1);
    }
};
*/
/*
class Solution {
public:
    TreeNode* balanceBST(TreeNode* root) {
        if (!root) return nullptr;

        // Step 1: Create the backbone (vine)
        // Temporary dummy node
        TreeNode* vineHead = new TreeNode(0);
        vineHead->right = root;
        TreeNode* current = vineHead;
        while (current->right) {
            if (current->right->left) {
                rightRotate(current, current->right);
            } else {
                current = current->right;
            }
        }

        // Step 2: Count the nodes
        int nodeCount = 0;
        current = vineHead->right;
        while (current) {
            ++nodeCount;
            current = current->right;
        }

        // Step 3: Create a balanced BST
        int m = pow(2, floor(log2(nodeCount + 1))) - 1;
        makeRotations(vineHead, nodeCount - m);
        while (m > 1) {
            m /= 2;
            makeRotations(vineHead, m);
        }

        TreeNode* balancedRoot = vineHead->right;
        // Delete the temporary dummy node
        delete vineHead;
        return balancedRoot;
    }

    // Function to perform a right rotation
    void rightRotate(TreeNode* parent, TreeNode* node) {
        TreeNode* tmp = node->left;
        node->left = tmp->right;
        tmp->right = node;
        parent->right = tmp;
    }

    // Function to perform a left rotation
    void leftRotate(TreeNode* parent, TreeNode* node) {
        TreeNode* tmp = node->right;
        node->right = tmp->left;
        tmp->left = node;
        parent->right = tmp;
    }

    // Function to perform a series of left rotations to balance the vine
    void makeRotations(TreeNode* vineHead, int count) {
        TreeNode* current = vineHead;
        for (int i = 0; i < count; ++i) {
            TreeNode* tmp = current->right;
            leftRotate(current, tmp);
            current = current->right;
        }
    }
};
*/