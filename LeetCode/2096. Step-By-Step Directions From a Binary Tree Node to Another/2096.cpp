class Solution
{
public:
    string getDirections(TreeNode *root, int startValue, int destValue)
    {
        TreeNode *lca = findLCA(root, startValue, destValue);

        string pathToStart = "";
        string pathToDest = "";

        getPath(lca, startValue, pathToStart);
        getPath(lca, destValue, pathToDest);

        // Reverse the paths since they are built backwards (from target to LCA)
        std::reverse(pathToStart.begin(), pathToStart.end());
        std::reverse(pathToDest.begin(), pathToDest.end());

        string result = string(pathToStart.size(), 'U'); // Convert path to start into 'U's
        result += pathToDest;                            // Add path to destination
        return result;
    }

private:
    TreeNode *findLCA(TreeNode *root, int p, int q)
    {
        if (!root || root->val == p || root->val == q)
            return root;
        TreeNode *left = findLCA(root->left, p, q);
        TreeNode *right = findLCA(root->right, p, q);
        if (left && right)
            return root;
        return left ? left : right;
    }

    bool getPath(TreeNode *node, int val, string &path)
    {
        if (!node)
            return false;
        if (node->val == val)
            return true;

        if (getPath(node->left, val, path))
        {
            path.push_back('L');
            return true;
        }
        else if (getPath(node->right, val, path))
        {
            path.push_back('R');
            return true;
        }
        return false;
    }
};
/*
class Solution {
public:
    bool findPath(TreeNode* root, int tar, string &str){
        if(root == NULL) return false;
        if(root->val == tar) return true;
        bool left = findPath( root->left, tar, str);
        if(left){
            str += 'L';
            return true;
        }
        bool right = findPath( root->right, tar, str);
        if(right){
            str += 'R';
            return true;
        }
        return false;
    }
    string getDirections(TreeNode* root, int startValue, int destValue) {
       string rootToSrc="";
       findPath(root,startValue,rootToSrc);

       string rootToDst="";
       findPath(root,destValue,rootToDst);
       cout<<"src "<<rootToSrc<<endl;
       cout<<"dst "<<rootToDst<<endl;
       int i = rootToSrc.size() - 1;
        int j = rootToDst.size() - 1;
         while(i>=0 && j>=0 && rootToSrc[i] == rootToDst[j]){
            rootToSrc.pop_back();
            rootToDst.pop_back();
            i--;
            j--;
        }
        i = rootToSrc.size();
        for(int j=0; j<i; j++){
            rootToSrc[j] = 'U';
        }
        reverse(rootToDst.begin(), rootToDst.end());
        return rootToSrc + rootToDst;
    }
};
*/
/*
class Solution {
public:
    unordered_map<TreeNode *, TreeNode *> parent;
    TreeNode *start, *end;
    string getDirections(TreeNode* root, int startValue, int destValue) {
        dfs(root, startValue, destValue);

        string path1 = getPath(root, start);
        string path2 = getPath(root, end);

        int m = path1.size();
        int n = path2.size();

        int i = 0;
        while(i < min(m, n) && path1[i] == path2[i])
            ++i;

        string res;
        res.resize(m + n - 2*i, 'U');

        for(int j = m-i; i < n; ++i, ++j) {
            res[j] = path2[i];
        }

        return res;
    }

    void dfs(TreeNode* node, int startValue, int destValue) {
        if(node->val == startValue) {
            start = node;
        } else if(node->val == destValue) {
            end = node;
        }

        if(node->left) {
            parent[node->left] = node;
            dfs(node->left, startValue, destValue);
        }

        if(node->right) {
            parent[node->right] = node;
            dfs(node->right, startValue, destValue);
        }
    }

    string getPath(TreeNode* root, TreeNode *node) {
        string res;
        while(node != root) {
            TreeNode *p = parent[node];

            if(node == p->left)
                res.push_back('L');
            else
                res.push_back('R');

            node = p;
        }

        reverse(res.begin(), res.end());

        return res;
    }
};
*/