class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0) return false;
        long left = 0;
        // right starts from the square root of the input number
        long right = (long) Math.sqrt(c);

        // While left pointer is less than or equal to right pointer
        while (left <= right) {
            // Calculate the sum of the squares of left and right
            long sum = left * left + right * right;
            // If the sum is equal to the input number, return true because we found two numbers whose squares sum up to the input number
            if (sum == c) {
                return true;
            } 
            // If the sum is less than the input number, increment the left pointer because we need a larger sum
            else if (sum < c) {
                left++;
            } 
            // If the sum is greater than the input number, decrement the right pointer because we need a smaller sum
            else {
                right--;
            }
        }

        // If we exit the loop without finding two numbers whose squares sum up to the input number, return false
        return false;
    }
}

/*
 class Solution {
    public boolean judgeSquareSum(int c) {
        for (int i = 2; i * i <= c; i++) {
            if (c % i == 0) {
                int count = 0;
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0)
                    return false;
            }
        }
        return c % 4 != 3;
    }
}

// class Solution {
//     public boolean judgeSquareSum(int c) {
//         if (c < 0) {
//             return false;
//         }
        
//         int left = 0;
//         int right = (int) Math.sqrt(c);
//         while (left <= right) {
//             long sum = (long) left * left + (long) right * right;
            
//             if (sum == c) {
//                 return true;
//             } else if (sum < c) {
//                 left++; 
//             } else {
//                 right--; 
//             }
//         }
//         return false;
//     }
// }
 */