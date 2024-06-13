using System;

public class Solution {
    public bool SearchMatrix(int[][] matrix, int target) {
        int m = matrix.Length;
        int n = matrix[0].Length;
        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midElement = matrix[mid / n][mid % n];
            if (midElement == target) {
                return true;
            } else if (midElement < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}

public class Program {
    public static void Main() {
        int[][] matrix = new int[][] {
            new int[] {1, 3, 5, 7},
            new int[] {10, 11, 16, 20},
            new int[] {23, 30, 34, 60}
        };
        int target = 3;

        Solution solution = new Solution();
        bool result = solution.SearchMatrix(matrix, target);
        Console.WriteLine("Output: " + result); 
    }
}



/*
public class Solution {
    public bool SearchMatrix(int[][] matrix, int target) {
        //Each row is in ascending order 
        //First element of each row is larger than last element of previous row
        //Iterate m loop 
        bool m_bfound = false;
        for(int i = 0; i < matrix.GetLength(0); i++){
            int left = 0;
            int right = matrix[i].Length - 1;
            while(left <= right){
                int mid = (int)Math.Floor((double)(left + right) / 2);
                if(target < matrix[i][mid]){
                    right = mid - 1;
                }
                else if(target > matrix[i][mid]){
                    left = mid + 1;
                }
                else if(target == matrix[i][mid]){
                    m_bfound = true;
                    return m_bfound;
                }
            }
        }
        return m_bfound;
        
    }
}
*/

/*
public class Solution {
    public bool SearchMatrix(int[][] matrix, int target) {
        var row = -1;
        foreach (var arr in matrix){
            if (arr[0] > target){
                break;
            }
            row++;
        }
        if (row < 0) {
            row = 0;
        }

        var arrToSearch = matrix[row];
        var min = 0;
        var max = arrToSearch.Length - 1;
        while(min <= max){
            var mid = (min + max) / 2;
            if (arrToSearch[mid] == target){
                return true;
            }
            else if (arrToSearch[mid] > target){
                max = mid - 1;
            } else{
                min = mid + 1;
            }
        }
        return false;
    }
}
*/

/*
public class Solution {
    public bool SearchMatrix(int[][] matrix, int target) {
        var left = 0;
        var right = matrix.Length * matrix[0].Length - 1;

        while(left <= right) {
            var mid = (left + right) >> 1;

            var row = mid / matrix[0].Length;
            var col = mid % matrix[0].Length;

            if(matrix[row][col] == target)
                return true;

            if(matrix[row][col] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return false;
    }
}
*/