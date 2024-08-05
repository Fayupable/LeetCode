class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int i : nums) {
            sum += i;
            max = (sum > max) ? sum : max;
            if (sum < 0)
                sum = 0;
        }
        return max;
    }
}

/*
 * class Solution {
 * 
 * // Main function to find the maximum subarray sum
 * public int maxSubArray(int[] nums) {
 * // Initialize the current max and global max
 * int[] initialValues = initialize(nums);
 * int maxCurrent = initialValues[0];
 * int maxGlobal = initialValues[1];
 * 
 * // Iterate through the array starting from the second element
 * for (int i = 1; i < nums.length; i++) {
 * // Update the current max
 * maxCurrent = updateCurrentMax(nums[i], maxCurrent);
 * // Update the global max
 * maxGlobal = updateGlobalMax(maxCurrent, maxGlobal);
 * }
 * 
 * // Return the global max which is the maximum subarray sum
 * return maxGlobal;
 * }
 * 
 * // Function to initialize the maxCurrent and maxGlobal values
 * private int[] initialize(int[] nums) {
 * int maxCurrent = nums[0];
 * int maxGlobal = nums[0];
 * return new int[] { maxCurrent, maxGlobal };
 * }
 * 
 * // Function to update the current max value
 * private int updateCurrentMax(int currentValue, int maxCurrent) {
 * return Math.max(currentValue, maxCurrent + currentValue);
 * }
 * 
 * // Function to update the global max value
 * private int updateGlobalMax(int maxCurrent, int maxGlobal) {
 * return Math.max(maxGlobal, maxCurrent);
 * }
 * }
 * 
 */