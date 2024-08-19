class Solution {

    public long maxPoints(int[][] points) {
        int cols = points[0].length;
        long[] currentRow = new long[cols], previousRow = new long[cols];

        for (int[] row : points) {
            long runningMax = 0;

            for (int col = 0; col < cols; ++col) {
                runningMax = Math.max(runningMax - 1, previousRow[col]);
                currentRow[col] = runningMax;
            }

            runningMax = 0;
            for (int col = cols - 1; col >= 0; --col) {
                runningMax = Math.max(runningMax - 1, previousRow[col]);
                currentRow[col] = Math.max(currentRow[col], runningMax) +
                row[col];
            }

            previousRow = currentRow;
        }

        long maxPoints = 0;
        for (int col = 0; col < cols; ++col) {
            maxPoints = Math.max(maxPoints, previousRow[col]);
        }

        return maxPoints;
    }
}