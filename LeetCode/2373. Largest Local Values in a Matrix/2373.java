class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] maxLocal = new int[n - 2][n - 2];
        
        for (int i = 1; i <= n - 2; i++) {
            for (int j = 1; j <= n - 2; j++) {
                int maxVal = 0;
                
                // Loop over each element in the 3x3 grid centered at (i, j)
                for (int di = -1; di <= 1; di++) {
                    for (int dj = -1; dj <= 1; dj++) {
                        maxVal = Math.max(maxVal, grid[i + di][j + dj]);
                    }
                }

                maxLocal[i - 1][j - 1] = maxVal;
            }
        }

        return maxLocal;  // Move the return statement outside the outer loop.
    }
}
