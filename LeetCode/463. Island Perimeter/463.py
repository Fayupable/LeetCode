class Solution(object):
    def islandPerimeter(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        rows = len(grid)
        cols = len(grid[0])
        perimeter = 0

        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == 1:  # If it's land
                    # Check each of the four possible sides:
                    # Check above
                    if i == 0 or grid[i - 1][j] == 0:
                        perimeter += 1
                    # Check below
                    if i == rows - 1 or grid[i + 1][j] == 0:
                        perimeter += 1
                    # Check left
                    if j == 0 or grid[i][j - 1] == 0:
                        perimeter += 1
                    # Check right
                    if j == cols - 1 or grid[i][j + 1] == 0:
                        perimeter += 1

        return perimeter
