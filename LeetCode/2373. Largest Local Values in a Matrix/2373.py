class Solution(object):
    def largestLocal(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: List[List[int]]
        """
        n = len(grid)
        maxLocal = [[0] * (n - 2) for _ in range(n - 2)]
        
        # Loop through each possible center of a 3x3 matrix
        for i in range(1, n - 1):
            for j in range(1, n - 1):
                max_value = 0
                # Consider all elements in the 3x3 matrix centered at (i, j)
                for di in range(-1, 2):
                    for dj in range(-1, 2):
                        max_value = max(max_value, grid[i + di][j + dj])
                # Store the maximum value in the corresponding position in maxLocal
                maxLocal[i - 1][j - 1] = max_value
        
        return maxLocal
