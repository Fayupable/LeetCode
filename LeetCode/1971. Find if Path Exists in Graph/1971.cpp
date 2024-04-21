class Solution {
public:
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        // Create adjacency list representation of the graph
        vector<vector<int>> adjList(n);
        for (const auto& edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList[u].push_back(v);
            adjList[v].push_back(u); // Considering it's a bidirectional graph
        }
        
        // Perform BFS
        queue<int> q;
        unordered_set<int> visited;
        q.push(source);
        visited.insert(source);
        
        while (!q.empty()) {
            int current = q.front();
            q.pop();
            if (current == destination) {
                return true; // Found a path
            }
            for (int neighbor : adjList[current]) {
                if (visited.find(neighbor) == visited.end()) {
                    visited.insert(neighbor);
                    q.push(neighbor);
                }
            }
        }
        
        return false; // No path found
    }
};