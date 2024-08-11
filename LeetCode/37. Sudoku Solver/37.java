class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        int[] emptyCell = findEmptyCell(board);
        if (emptyCell == null) {
            return true;  
        }

        int row = emptyCell[0];
        int col = emptyCell[1];

        for (char num = '1'; num <= '9'; num++) {
            if (isValid(board, row, col, num)) {
                if (placeNumber(board, row, col, num)) {
                    return true;
                }
            }
        }
        return false;  
    }

    private int[] findEmptyCell(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    return new int[]{row, col};
                }
            }
        }
        return null;
    }

    private boolean placeNumber(char[][] board, int row, int col, char num) {
        board[row][col] = num;
        if (solve(board)) {
            return true;
        }
        board[row][col] = '.';  
        return false;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) return false;  
            if (board[i][col] == num) return false;  
            if (board[row - row % 3 + i / 3][col - col % 3 + i % 3] == num) return false; 
        }
        return true;
    }
}