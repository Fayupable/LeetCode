class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid or len(grid) == 0:
            return 0

        num_islands = 0
        rows = len(grid)
        cols = len(grid[0])

        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == '1':
                    num_islands += 1
                    self.dfs(grid, i, j)

        return num_islands

    def dfs(self, grid, row, col):
        rows = len(grid)
        cols = len(grid[0])

        if row < 0 or col < 0 or row >= rows or col >= cols or grid[row][col] == '0':
            return

        # Mark the current cell as visited
        grid[row][col] = '0'

        # Explore adjacent cells
        self.dfs(grid, row - 1, col)  # Up
        self.dfs(grid, row + 1, col)  # Down
        self.dfs(grid, row, col - 1)  # Left
        self.dfs(grid, row, col + 1)  # Right
