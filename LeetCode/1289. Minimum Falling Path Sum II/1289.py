class Solution(object):
    def minFallingPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        row = len(grid)
        col = len(grid[0])
        
        for r in range(1, row):
            # Her satır için bir önceki satırdaki minimum iki değeri bul
            min1, min2 = float('inf'), float('inf')
            for c in range(col):
                if grid[r - 1][c] < min1:
                    min2 = min1
                    min1 = grid[r - 1][c]
                elif grid[r - 1][c] < min2:
                    min2 = grid[r - 1][c]
            
            # Mevcut satırdaki her hücreyi güncelle
            for c in range(col):
                if grid[r - 1][c] == min1:
                    grid[r][c] += min2
                else:
                    grid[r][c] += min1
        
        # Son satırdaki minimum toplamı döndür
        return min(grid[-1])
