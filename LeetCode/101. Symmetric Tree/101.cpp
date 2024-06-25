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
    bool isSymmetric(TreeNode* root) {
        queue<TreeNode*> q;
        q.push(root);
        q.push(root);
        
        while(!q.empty()) {
            TreeNode* t1 = q.front();
            q.pop();
            TreeNode* t2 = q.front();
            q.pop();
            
            if(t1 == NULL && t2 == NULL) continue;
            if(t1 == NULL || t2 == NULL) return false;
            if(t1->val != t2->val) return false;
            
            q.push(t1->left);
            q.push(t2->right);
            q.push(t1->right);
            q.push(t2->left);
        }
        
        return true;
        
    }
};

//other people's solution
/*
class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        if (root == nullptr) return true;
        return subMirror(root->left,root->right);
    }
    bool subMirror(TreeNode* left, TreeNode* right){
        if(not left and not right){
            return true;
        } else if(not left or not right or left->val != right->val){
            return false;
        }
        return subMirror(left->left, right->right) and subMirror(right->left, left->right);
    }
};
*/

/*
class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        return (!root) ? true : isSS(root -> left, root -> right);
    }

    bool isSS(TreeNode* l, TreeNode* r) {
        if (!l || !r)
            return l == r;
        return (l -> val == r -> val) && isSS(l -> left, r -> right) && isSS(l -> right, r -> left);
    }
};
*/
/*
class Solution {
public:
bool isMirror(TreeNode* left, TreeNode* right) {
    if (left == NULL && right == NULL) return true;
    if (left == NULL || right == NULL) return false;
    return (left->val == right->val) && isMirror(left->left, right->right) 
                                     && isMirror(left->right, right->left);
}

    bool isSymmetric(TreeNode* root) {
        if (!root) return true;
    return isMirror(root->left, root->right);
    }
};
*/
/*
class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        queue<TreeNode*> q;
        if(root==nullptr)return true;
        if(root->left==nullptr && root->right==nullptr)return true;
        q.push(root);
        while(!q.empty()){
            vector<TreeNode*> level;
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode* node=q.front();
                q.pop();
                level.push_back(node);
                if(node!=nullptr)q.push(node->left);
                if(node!=nullptr)q.push(node->right);
            }
            // cout <<level.size()<<endl;
            // if(level.size()%2!=0){
            //     return false;
            // }
            for(int i=0;i<level.size()/2;i++){
                if(level[i]==nullptr && level[level.size()-i-1]!=nullptr)return false;
                if(level[i]!=nullptr && level[level.size()-i-1]==nullptr)return false;
             
                if(level[i]!=nullptr ){
                    if(level[i]->val!=level[level.size()-1-i]->val)return false;
                }
                else{
                    if(level[i]!=level[level.size()-1-i])return false;
                }
            
            }
        }
        return true;

    }
};
*/
/*
class Solution {
public:
    bool isSymmetric(TreeNode* root) 
    {
        queue<pair<TreeNode*,TreeNode*>>a;
        bool isSym = true;
        a.push(make_pair(root->left, root->right));
        while(!a.empty())
        {
            auto i = a.front();
            if ((i.first && !i.second) || (!i.first && i.second))
            {
                isSym = false;
                break;
            }
            if (i.first && i.second)
            {
                if (i.first->val != i.second->val)
                {
                    isSym = false;
                    break;
                }
                a.push(make_pair(i.first->left,i.second->right));
                a.push(make_pair(i.first->right,i.second->left));
            }
            a.pop();
        }
        return isSym;
    }
};
*/