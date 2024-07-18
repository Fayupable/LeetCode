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
    int countPairs(TreeNode* root, int distance) {
        int ans = 0;
        dfs(root, distance, ans);
        return ans;
        
    }

    vector<int> dfs(TreeNode* root, int distance, int& ans) {
        if (!root) return {};
        if (!root->left && !root->right) return {1};
        vector<int> left = dfs(root->left, distance, ans);
        vector<int> right = dfs(root->right, distance, ans);
        for (int l : left) {
            for (int r : right) {
                if (l + r <= distance) {
                    ans++;
                }
            }
        }
        vector<int> res;
        for (int l : left) {
            if (l + 1 < distance) {
                res.push_back(l + 1);
            }
        }
        for (int r : right) {
            if (r + 1 < distance) {
                res.push_back(r + 1);
            }
        }
        return res;
    }
};


/*
struct NodePos
{
    int64_t depth;
    int64_t pos;
};

void dfs(TreeNode *node, std::vector<NodePos> &leaves, int64_t depth, int64_t pos)
{
    if(node->left != nullptr)
    {
        dfs(node->left, leaves, depth + 1, pos);
    }

    if(node->right != nullptr)
    {
        dfs(node->right, leaves, depth + 1, pos | (int64_t(1) << depth));
    }

    if(node->left == nullptr && node->right == nullptr)
    {
        // std::cout << ((depth)) << " " << pos;
        // std::cout << std::endl;

        NodePos p;
        p.depth = depth;
        p.pos = pos;
        leaves.emplace_back(p);

        // std::cout << depth << std::endl;
    }
}

class Solution {
public:
    int countPairs(TreeNode* root, int distance)
    {
        std::vector<NodePos> leaves;

        dfs(root, leaves, 0, 0);

        int result = 0;

        std::cout << "=========" << std::endl;

        for(size_t i = 0; i < leaves.size() - 1; i++)
        {
            for(size_t j = i + 1; j < leaves.size(); j++)
            {
                auto fd = leaves[i].depth;
                auto sd = leaves[j].depth;

                auto fp = leaves[i].pos;
                auto sp = leaves[j].pos;

                auto min = std::min(fd, sd);

                // std::cout << (int)fd << " " << (int)sd << std::endl;
                // std::cout << (int64_t)fp << " " << (int64_t)sp << std::endl;

                auto depthDiff = __builtin_ctzl(fp ^ sp);
                
                auto diff = (fd - depthDiff) + sd - depthDiff;

                if(diff == 0 && fd != sd)
                {
                    diff = std::abs(fd - sd);
                }

                result += diff <= distance;
            }
        }
        return result;

    }
};
*/