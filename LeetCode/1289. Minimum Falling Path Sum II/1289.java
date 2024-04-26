class Solution {
    public int minFallingPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        for (int r = 1; r < row; r++) {
            // Her satır için bir önceki satırdaki minimum iki değeri bul
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            for (int c = 0; c < col; c++) {
                if (grid[r - 1][c] < min1) {
                    min2 = min1;
                    min1 = grid[r - 1][c];
                } else if (grid[r - 1][c] < min2) {
                    min2 = grid[r - 1][c];
                }
            }
            
            // Mevcut satırdaki her hücreyi güncelle
            for (int c = 0; c < col; c++) {
                if (grid[r - 1][c] == min1) {
                    grid[r][c] += min2;
                } else {
                    grid[r][c] += min1;
                }
            }
        }
        
        // Son satırdaki minimum toplamı bul
        int minSum = Integer.MAX_VALUE;
        for (int sum : grid[row - 1]) {
            minSum = Math.min(minSum, sum);
        }
        
        return minSum;
    }
}
