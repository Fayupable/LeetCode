class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = -1;
        int m = matrix.length;
        int n = matrix[0].length;

        // Determine which row the target could be in
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] <= target && matrix[i][n - 1] >= target) {
                row = i;
                break;
            }
        }

        // If the target could not be in any row, return false
        if (row == -1) {
            return false;
        }

        // Perform binary search in the determined row
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // If the target is not found, return false
        return false;
    }
}
/*
 * class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left=0;
        int right=matrix.length-1;

        while(left<=right){
            int mid=left+(right-left)/2;
            int innerleft=0;
            int inneright=matrix[mid].length-1;
            if(matrix[mid][0]<=target && matrix[mid][inneright]>=target){
                while(innerleft<=inneright){
                    int innermid=innerleft+(inneright-innerleft)/2;
                    if(matrix[mid][innermid]==target){
                        return true;
                    }else if(matrix[mid][innermid]<target){
                        innerleft=innermid+1;
                    }else{
                        inneright=innermid-1;
                    }
                }
                return false;
            }else if(matrix[mid][0]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return false;
    }
}
 */