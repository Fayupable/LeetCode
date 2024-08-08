//other peoples solution
class Solution {
    int minX, minY, maxX, maxY, index;

    int[][] result;

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

        int n = cols * rows;
        result = new int[n][];

        minX = cStart;
        maxX = cStart + 1;
        minY = rStart;
        maxY = rStart;
        index = 0;
        result[index++] = new int[] { rStart, cStart };

        while (true) {
            if (minY >= 0) {
                right(Math.max(0, minX + 1), Math.min(cols - 1, maxX));
            }
            maxY++;
            if (index >= n)
                break;

            if (maxX < cols)
                down(Math.max(0, minY + 1), Math.min(rows - 1, maxY));
            minX--;
            if (index >= n)
                break;

            if (maxY < rows)
                left(Math.min(cols - 1, maxX - 1), Math.max(0, minX));
            minY--;
            if (index >= n)
                break;

            if (minX >= 0)
                up(Math.min(rows - 1, maxY - 1), Math.max(0, minY));
            maxX++;
            if (index >= n)
                break;
        }
        return result;
    }

    public void right(int start, int end) {
        for (int i = start; i <= end; i++)
            result[index++] = new int[] { minY, i };
    }

    public void left(int start, int end) {
        for (int i = start; i >= end; i--)
            result[index++] = new int[] { maxY, i };
    }

    public void down(int start, int end) {
        for (int i = start; i <= end; i++)
            result[index++] = new int[] { i, maxX };
    }

    public void up(int start, int end) {
        for (int i = start; i >= end; i--)
            result[index++] = new int[] { i, minX };
    }
}

/*
 * class Solution {
 * public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
 * // Directions: right, down, left, up
 * int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
 * int totalCells = rows * cols;
 * int[][] result = new int[totalCells][2];
 * int direction = 0; // Start facing right
 * int steps = 1; // Start with 1 step in the first direction
 * 
 * int index = 0;
 * int r = rStart, c = cStart;
 * 
 * result[index++] = new int[]{r, c};
 * 
 * while (index < totalCells) {
 * for (int i = 0; i < 2; ++i) { // We make steps twice per direction increment
 * for (int j = 0; j < steps; ++j) {
 * r += directions[direction][0];
 * c += directions[direction][1];
 * 
 * if (r >= 0 && r < rows && c >= 0 && c < cols) {
 * result[index++] = new int[]{r, c};
 * }
 * }
 * direction = (direction + 1) % 4; // Change direction
 * }
 * steps++; // Increase the step size after completing a loop of four directions
 * }
 * 
 * return result;
 * }
 * }
 */