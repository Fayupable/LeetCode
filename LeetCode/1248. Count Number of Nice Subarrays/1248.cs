using System;
using System.Collections.Generic;

public class Solution {
    public int NumberOfSubarrays(int[] nums, int k) {
        // Dictionary to store the count of prefix sums
        var count = new Dictionary<int, int>();
        count[0] = 1; // Initial condition to handle the case when prefixSum == k
        int prefixSum = 0, result = 0;

        foreach (int num in nums) {
            // Increment prefixSum by 1 if the current number is odd
            prefixSum += num % 2;
            
            // Check if there exists a prefix sum that would make the subarray have exactly k odd numbers
            if (count.ContainsKey(prefixSum - k)) {
                result += count[prefixSum - k];
            }
            
            // Update the count of the current prefixSum
            if (!count.ContainsKey(prefixSum)) {
                count[prefixSum] = 0;
            }
            count[prefixSum]++;
        }

        return result; // Return the total number of nice subarrays
    }

    public static void Main(string[] args) {
        var solution = new Solution();
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        Console.WriteLine(solution.NumberOfSubarrays(nums, k)); // Expected output: 2
    }
}
//other people's solutions
/*
public class Solution {
    public int NumberOfSubarrays(int[] nums, int k) {
        var list = new List<int> {1};
        var total = 0;
        foreach (var num in nums) {
            if (num % 2 == 1) {
                list.Add(1);
            } else {
                list[^1]++;
            }

            if (list.Count - k  - 1 >= 0) {
                total += list[list.Count - k - 1];
            }
        }
        return total;
    }
}
*/
/*
public class Solution {
    public int NumberOfSubarrays(int[] nums, int k) {
        List<int> odd=new List<int>();
        for(int i=0;i<nums.Length;i++)
        {
            if(nums[i]%2==1)
            {
                odd.Add(i);
            }
        }
         odd.Add(nums.Length);

         int first=0;
         int total=0;
         for(int i=0;(i+k)<odd.Count;i++)
         {

                if(i==0)
                total+=((odd[i]+1)*(odd[i+k]-odd[i+k-1]));
                else
                total+=((odd[i]-odd[i-1])*(odd[i+k]-odd[i+k-1]));
         }
         return total;
    }
}
*/
/*
public class Solution {
    public int NumberOfSubarrays(int[] nums, int k) {
        return GetSubSetSum(nums, k) - GetSubSetSum(nums, k - 1);
    }
    private static int GetSubSetSum(int[] nums, int goal){
        if(goal < 0){
            return 0;
        }

        int l = 0, sum = 0, count = 0;
        for(int r = 0; r < nums.Length; r++){
            sum += nums[r] % 2 == 1 ? 1 : 0;
            while(sum > goal){
                sum -= nums[l++] % 2 == 1 ? 1 : 0;
            }

            count += (r - l + 1);
        }
        return count;
    }
}
*/

