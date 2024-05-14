class Solution(object):
    def getMaximumGold(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """

        
        
        def dfs(i, j):
            if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]) or grid[i][j] == 0:
                return 0
            origin = grid[i][j]
            grid[i][j] = 0
            res = origin + max(dfs(i + 1, j), dfs(i - 1, j), dfs(i, j + 1), dfs(i, j - 1))
            grid[i][j] = origin
            return res
        
        res = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] != 0:
                    res = max(res, dfs(i, j))
        return res
    