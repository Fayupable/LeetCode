class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = countLiveNeighbors(board, i, j, m, n);

                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = 2; 
                } else if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 3; 
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) board[i][j] = 0;
                if (board[i][j] == 3) board[i][j] = 1;
            }
        }
    }

    private int countLiveNeighbors(int[][] board, int row, int col, int m, int n) {
        int count = 0;
        int[] directions = {-1, 0, 1};
        
        for (int dr : directions) {
            for (int dc : directions) {
                if (dr == 0 && dc == 0) continue;
                int r = row + dr, c = col + dc;
                if (r >= 0 && r < m && c >= 0 && c < n && (board[r][c] == 1 || board[r][c] == 2)) {
                    count++;
                }
            }
        }
        return count;
    }
}