class Solution {
    public int totalNQueens(int n) {
        int[] result = new int[1];
        int[] positions = new int[n];
        solveNQueens(n, 0, positions, result);
        return result[0];
    }

    private void solveNQueens(int n, int row, int[] positions, int[] result) {
        if (row == n) {
            result[0]++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValidPosition(positions, row, col)) {
                positions[row] = col;
                solveNQueens(n, row + 1, positions, result);
            }
        }
    }

    private boolean isValidPosition(int[] positions, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (positions[i] == col || positions[i] - i == col - row || positions[i] + i == col + row) {
                return false;
            }
        }
        return true;
    }
}

/*
 * class Solution {
 * public int cnt=0;
 * public int totalNQueens(int n) {
 * 
 * int left[]=new int[n];
 * int ldia[]=new int[2*n-1];
 * int rdia[]=new int[2*n-1];
 * char board[][]=new char[n][n];
 * for(int i=0;i<n;i++){
 * for(int j=0;j<n;j++){
 * board[i][j]='.';
 * }
 * }
 * solve(0,board,left,ldia,rdia);
 * return cnt;
 * }
 * 
 * public void solve(int col,char[][] board,int[]left,int[]ldia,int[]rdia){
 * if(col==board.length){
 * cnt++;
 * return;
 * }
 * for(int row=0;row<board.length;row++){
 * if(left[row]==0&&ldia[row+col]==0&&rdia[board.length-1+col-row]==0){
 * left[row]=1;
 * ldia[row+col]=1;
 * rdia[board.length-1+col-row]=1;
 * board[row][col]='Q';
 * solve(col+1,board,left,ldia,rdia);
 * left[row]=0;
 * ldia[row+col]=0;
 * rdia[board.length-1+col-row]=0;
 * board[row][col]='.';
 * }
 * }
 * }
 * }
 */