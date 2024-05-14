class Solution {
public:
    int getMaximumGold(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        
        int maxGold = 0;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] != 0){
                    maxGold = max(maxGold, dfs(grid, i, j));
                }
            }
        }
        
        return maxGold;
    }

    int dfs(vector<vector<int>>& grid, int i, int j){
        
        if(i<0 || i>=grid.size() || j<0 || j>=grid[0].size() || grid[i][j] == 0){
            return 0;
        }
        
        int gold = grid[i][j];
        grid[i][j] = 0;
        
        int maxGold = 0;
        
        maxGold = max(maxGold, gold + dfs(grid, i+1, j));
        maxGold = max(maxGold, gold + dfs(grid, i-1, j));
        maxGold = max(maxGold, gold + dfs(grid, i, j+1));
        maxGold = max(maxGold, gold + dfs(grid, i, j-1));
        
        grid[i][j] = gold;
        
        return maxGold;
    }
};