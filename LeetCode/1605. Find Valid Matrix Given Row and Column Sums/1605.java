class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] matrix = new int[m][n];

        // Fill the matrix with the minimum value of rowSum[i] and colSum[j]
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Find the minimum value of rowSum[i] and colSum[j]
                int minValue = Math.min(rowSum[i], colSum[j]);
                // Fill the matrix with the minimum value
                matrix[i][j] = minValue;
                // Update the rowSum[i] and colSum[j]
                rowSum[i] -= minValue;
                // If rowSum[i] is 0, break the loop
                colSum[j] -= minValue;
            }
        }

        return matrix;
    }
}