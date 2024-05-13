import math


class Solution(object):
    def matrixScore(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        m, n = len(grid), len(grid[0])

        # Flip rows starting with 0
        for i in range(m):
            if grid[i][0] == 0:
                for j in range(n):
                    grid[i][j] = 1 - grid[i][j]

        # Flip columns with more 0's than 1's
        for j in range(1, n):
            zero_count = sum(grid[i][j] == 0 for i in range(m))
            if zero_count > m / 2:
                for i in range(m):
                    grid[i][j] = 1 - grid[i][j]

        # Calculate the total score
        return sum(int(''.join(map(str, row)), 2) for row in grid)
    
#--------------------------------------------------------------
    def matrixScore1(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        rows = len(grid)
        cols = len(grid[0])

        for r in range(rows):
            if grid[r][0] == 0:
                for c in range(cols):
                    grid[r][c] = 1 if grid[r][c] == 0 else 0

        for c in range(1, cols):
            count = 0
            for r in range(rows):
                if grid[r][c] == 0:
                    count += 1
            if count > rows // 2:
                for r in range(rows):
                    grid[r][c] = 1 if grid[r][c] == 0 else 0
        ans = 0
        for r in range(rows):
            ans += self.getIntFromBinary(grid[r])
        return ans
    
    def getIntFromBinary(self, row):
        power = len(row) - 1
        number = 0
        for c in range(len(row)):
            if row[c] == 1:
                number += math.pow(2, power)
            power -= 1
        return int(number)