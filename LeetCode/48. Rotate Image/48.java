class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}


/*
 class Solution {
    public void rotate(int[][] matrix) {
        int k=matrix.length;
        int temp;
        for(int i=0;i<k;i++){
            for(int j=i;j<k;j++){
                temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
                
            }
        }
        for(int x=0;x<matrix.length;x++){
            int left=0;
            int right=matrix.length-1;
            while(left<right){
                temp=matrix[x][right];
                matrix[x][right]=matrix[x][left];
                matrix[x][left]=temp;
                left++;
                right--;
                
            }
        }

    }
}
 */
/*
 class Solution {
    public void rotate(int[][] matrix) {
        int l = matrix.length;
        int i=0;
        int j= l-1;
        while(i<j) {
            for(int count=0; i+count<j; count++){
                rotate(matrix, i, j, count);
            }
            i++; j--;
        }
    }

    public void rotate(int[][] matrix, int i, int j, int count ) {
        int temp = matrix[i][i+count];
        matrix[i][i+count] = matrix[j-count][i];
        matrix[j-count][i] = matrix[j][j-count];
        matrix[j][j-count] = matrix[i+count][j];
        matrix[i+count][j] = temp;
    }
}
 */

 /*
  class Solution {
    private void transpose(int[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=i; j<matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    private void reverseRows(int[][] matrix) {
        for(int r=0; r<matrix.length; r++) {
            int left = 0;
            int right = matrix.length-1;

            while(left < right) {
                int temp = matrix[r][left];
                matrix[r][left] = matrix[r][right];
                matrix[r][right] = temp;

                left++;
                right--;
            }
        }

    }
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverseRows(matrix);
    }
}
  */