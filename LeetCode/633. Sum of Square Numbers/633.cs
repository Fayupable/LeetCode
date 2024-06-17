
public class Solution {
    public bool JudgeSquareSum(int c) {
        if (c < 0) return false;
        long left = 0;
        // right starts from the square root of the input number
        long right = (long) Math.Sqrt(c);

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
public class Solution {
    public bool JudgeSquareSum(int c) {
        //HashSet<int> set = new HashSet<int>();
        for(long i = 0; i <= c; i++)
        {
            if(i*i > c) break;
            if(Math.Sqrt(c-(i*i)) % 1 == 0) return true;
        }
        //Console.WriteLine(Int32.MaxValue);
        return false;
    }
}
*/