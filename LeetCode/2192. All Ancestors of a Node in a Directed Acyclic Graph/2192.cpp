#include <vector>
#include <queue>
#include <set>
#include <algorithm>
using namespace std;

class Solution {
public:
    vector<vector<int>> getAncestors(int n, vector<vector<int>>& edges) {
        vector<set<int>> ancestors(n);
        vector<vector<int>> graph(n);

        // Build the reversed graph
        for (const auto& edge : edges) {
            graph[edge[1]].push_back(edge[0]);
        }

        // Use BFS to find all ancestors for each node
        for (int i = 0; i < n; i++) {
            queue<int> queue;
            queue.push(i);

            while (!queue.empty()) {
                int current = queue.front();
                queue.pop();

                for (int parent : graph[current]) {
                    // If this ancestor is newly discovered for node i
                    if (ancestors[i].insert(parent).second) {
                        queue.push(parent);
                    }
                }
            }
        }

        // Convert sets to sorted lists
        vector<vector<int>> result(n);
        for (int i = 0; i < n; i++) {
            result[i] = vector<int>(ancestors[i].begin(), ancestors[i].end());
            sort(result[i].begin(), result[i].end());
        }

        return result;
    }
};

/*
class Solution {
public:
    vector<vector<int>> getAncestors(int n, vector<vector<int>>& edges) {
        vector<vector<int>> adj(n), ans(n);

        for (auto& edge: edges) {
            adj[edge[0]].push_back(edge[1]);
        }

        for (int i = 0; i < n; i++) {
            dfs(adj,ans,i,i);
        }
        
        return ans;
    }
    void dfs(vector<vector<int>>& adj, vector<vector<int>>& ans, int& parent, int& child) {
        for (auto& ch: adj[child]) {
            if (ans[ch].size() == 0 || ans[ch].back() != parent) {
                ans[ch].push_back(parent);
                dfs(adj,ans,parent,ch);
            }
            
        }
    }
};
*/
/*
class Solution {
    void dfs(vector<vector<int>> &graph, int i, int j, vector<vector<int>> &ans){
        for(auto &x : graph[j]){
            if(ans[x].empty() || ans[x].back() != i){
                ans[x].push_back(i);
                dfs(graph, i, x, ans);
            }
        }
    }

public:
    vector<vector<int>> getAncestors(int n, vector<vector<int>>& edges) {
        vector<vector<int>> ans(n);
        vector<vector<int>> graph(n);
        for(auto &v : edges){
            graph[v[0]].push_back(v[1]);
        }

        for(int i = 0; i < n; ++i){
            dfs(graph, i, i, ans);
        }

        return ans;
    }
};
*/