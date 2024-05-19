class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        // Step 1: Calculate the initial sum of the nums array
        long total = 0;
        for (int num : nums) {
            total += num;
        }
        
        // Initialize variables to keep track of the total positive difference
        long total_diff = 0;
        int positive_count = 0;
        long min_abs_diff = Long.MAX_VALUE;
        
        // Step 2: Iterate over the nums array to calculate differences
        for (int num : nums) {
            long diff = (long)(num ^ k) - num;
            
            if (diff > 0) {
                total_diff += diff;
                positive_count += 1;
            }
            min_abs_diff = Math.min(min_abs_diff, Math.abs(diff));
        }
        
        // Step 3: Adjust the total difference if the count of positive differences is odd
        if (positive_count % 2 == 1) {
            total_diff -= min_abs_diff;
        }
        
        // Step 4: Calculate the maximum possible sum
        return total + total_diff;
    }
}