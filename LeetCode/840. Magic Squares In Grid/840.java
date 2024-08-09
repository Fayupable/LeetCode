class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int r = 0; r <= rows - 3; r++) {
            for (int c = 0; c <= cols - 3; c++) {
                if (isMagicSquare(grid, r, c)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isMagicSquare(int[][] grid, int row, int col) {
        // Check all values must be distinct and between 1 and 9
        boolean[] seen = new boolean[10];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                int val = grid[row + r][col + c];
                if (val < 1 || val > 9 || seen[val]) {
                    return false;
                }
                seen[val] = true;
            }
        }

        // Check rows, columns and diagonals sums
        int sum = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];
        
        // Check rows
        for (int r = 0; r < 3; r++) {
            if (grid[row + r][col] + grid[row + r][col + 1] + grid[row + r][col + 2] != sum) {
                return false;
            }
        }
        
        // Check columns
        for (int c = 0; c < 3; c++) {
            if (grid[row][col + c] + grid[row + 1][col + c] + grid[row + 2][col + c] != sum) {
                return false;
            }
        }
        
        // Check diagonals
        if (grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2] != sum) {
            return false;
        }
        if (grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col] != sum) {
            return false;
        }

        return true;
    }
}