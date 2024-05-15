#include <vector>
#include <queue>
#include <algorithm>
#include <climits>

using namespace std;

class Solution {
public:
    int maximumSafenessFactor(vector<vector<int>>& grid) {
        int n = grid.size();
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return 0;
        }

        vector<vector<int>> dist(n, vector<int>(n, INT_MAX));
        queue<pair<int, int>> queue;
        vector<pair<int, int>> directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    queue.push({r, c});
                    dist[r][c] = 0;
                }
            }
        }

        while (!queue.empty()) {
            auto [r, c] = queue.front();
            queue.pop();
            for (auto [dr, dc] : directions) {
                int nr = r + dr, nc = c + dc;
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && dist[nr][nc] == INT_MAX) {
                    dist[nr][nc] = dist[r][c] + 1;
                    queue.push({nr, nc});
                }
            }
        }

        priority_queue<vector<int>> maxHeap;
        vector<vector<bool>> visited(n, vector<bool>(n, false));
        maxHeap.push({dist[0][0], 0, 0});
        
        while (!maxHeap.empty()) {
            auto cell = maxHeap.top();
            maxHeap.pop();
            int safeness = cell[0], r = cell[1], c = cell[2];
            
            if (r == n - 1 && c == n - 1) {
                return safeness;
            }

            if (visited[r][c]) {
                continue;
            }

            visited[r][c] = true;

            for (auto [dr, dc] : directions) {
                int nr = r + dr, nc = c + dc;
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    maxHeap.push({min(safeness, dist[nr][nc]), nr, nc});
                }
            }
        }

        return 0;
    }
};
