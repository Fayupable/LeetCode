import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            traverseRight(matrix, result, top, left, right);
            top++;
            if (top > bottom)
                break;

            traverseDown(matrix, result, right, top, bottom);
            right--;
            if (left > right)
                break;

            traverseLeft(matrix, result, bottom, left, right);
            bottom--;
            if (top > bottom)
                break;

            traverseUp(matrix, result, left, top, bottom);
            left++;
        }

        return result;
    }

    private void traverseRight(int[][] matrix, List<Integer> result, int row, int left, int right) {
        for (int col = left; col <= right; col++) {
            result.add(matrix[row][col]);
        }
    }

    private void traverseDown(int[][] matrix, List<Integer> result, int col, int top, int bottom) {
        for (int row = top; row <= bottom; row++) {
            result.add(matrix[row][col]);
        }
    }

    private void traverseLeft(int[][] matrix, List<Integer> result, int row, int left, int right) {
        for (int col = right; col >= left; col--) {
            result.add(matrix[row][col]);
        }
    }

    private void traverseUp(int[][] matrix, List<Integer> result, int col, int top, int bottom) {
        for (int row = bottom; row >= top; row--) {
            result.add(matrix[row][col]);
        }
    }
}

/*
 * class Solution {
 * public List<Integer> spiralOrder(int[][] matrix) {
 * List<Integer> ans=new ArrayList<>();
 * int count=0;
 * int rows=matrix.length;
 * int cols= matrix[0].length;
 * if(rows==0){
 * return ans;
 * }
 * int total=rows*cols;
 * int rowstart=0,rowend=rows-1,colstart=0,colend=cols-1;
 * while(count<total){
 * for( int j=colstart;j<=colend&&count<total;j++){
 * ans.add(matrix[rowstart][j]);
 * count++;
 * }
 * rowstart++;
 * for( int i=rowstart;i<=rowend&&count<total;i++){
 * ans.add(matrix[i][colend]);
 * count++;
 * }
 * colend--;
 * for(int j=colend;j>=colstart&&count<total;j--){
 * ans.add(matrix[rowend][j]);
 * count++;
 * }
 * rowend--;
 * for( int i=rowend;i>=rowstart&&count<total;i--){
 * ans.add(matrix[i][colstart]);
 * count++;
 * }
 * colstart++;
 * }
 * return ans;
 * }
 * }
 */