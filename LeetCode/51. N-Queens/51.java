class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];
        initializeBoard(board);
        solve(solutions, board, 0);
        return solutions;
    }

    private void initializeBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '.');
        }
    }

    private void solve(List<List<String>> solutions, char[][] board, int row) {
        if (row == board.length) {
            solutions.add(createSolution(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                solve(solutions, board, row + 1);
                board[row][col] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private List<String> createSolution(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }
}