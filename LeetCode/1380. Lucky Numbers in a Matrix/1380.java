class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        /*
         * Given an m x n matrix of distinct numbers, return all lucky numbers in the
         * matrix in any order.
         * 
         * A lucky number is an element of the matrix such that it is the minimum
         * element in its row and maximum in its column.
         */
        List<Integer> luckyNumbers = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[] rowMin = new int[m];
        int[] colMax = new int[n];
        Arrays.fill(rowMin, Integer.MAX_VALUE);
        Arrays.fill(colMax, Integer.MIN_VALUE);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowMin[i] = Math.min(rowMin[i], matrix[i][j]);
                colMax[j] = Math.max(colMax[j], matrix[i][j]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowMin[i] == colMax[j]) {
                    luckyNumbers.add(rowMin[i]);
                }
            }
        }

        return luckyNumbers;

    }
}
/*
 * class Solution {
 * public List<Integer> luckyNumbers (int[][] matrix) {
 * List<Integer> lsRes = new ArrayList<>();
 * 
 * for(int i = 0; i < matrix.length; i++)
 * {
 * int col = findMin(matrix, i);
 * 
 * int maxCol = matrix[i][col];
 * if(maxInCol(matrix, maxCol, col))
 * lsRes.add(maxCol);
 * // for(int r = 0; r < matrix.length; r++)
 * // {
 * // if(matrix[r][col] > maxCol)
 * // maxCol = matrix[r][col];
 * // }
 * 
 * // if(minRow == maxCol)
 * // lsRes.add(matrix[i][col]);
 * }
 * 
 * return lsRes;
 * }
 * private int findMin(int[][] matrix, int row){
 * int val= matrix[row][0], col=0;
 * for(int i=1;i<matrix[row].length;i++){
 * if(matrix[row][i]<val){
 * val=matrix[row][i];
 * col=i;
 * }
 * }
 * return col;
 * }
 * private boolean maxInCol(int[][] matrix, int val, int col){
 * for(int i=0;i<matrix.length;i++){
 * if(matrix[i][col]>val)
 * return false;
 * }
 * return true;
 * }
 * }
 */