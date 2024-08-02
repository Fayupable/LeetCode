class Solution {
    public int minSwaps(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            k += nums[i];
        }
        int sum = 0;
        int min = nums.length;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            if (j >= k) {
                sum -= nums[j - k];
            }
            if (j >= k - 1)
                min = Math.min(min, k - sum);
        }
        for (int i = 0; i <= k - 2; i++) {
            // length-k,...,length-1
            // length-k+1 - 0; length-k+2 - 1; length-k+3 - 2;
            sum = sum + nums[i] - nums[nums.length - k + i];
            min = Math.min(min, k - sum);
        }
        return min;
    }
}

/*
 * class Solution {
 * public int minSwaps(int[] nums) {
 * int totalOnes = 0;
 * for (int num : nums) {
 * if (num == 1) totalOnes++;
 * }
 * 
 * // Concatenate the array with itself to handle circular nature
 * int n = nums.length;
 * int[] extendedNums = new int[2 * n];
 * for (int i = 0; i < n; i++) {
 * extendedNums[i] = nums[i];
 * extendedNums[i + n] = nums[i];
 * }
 * 
 * // Sliding window to find the maximum number of 1s in any window of size
 * totalOnes
 * int maxOnesInWindow = 0, currentOnesInWindow = 0;
 * for (int i = 0; i < totalOnes; i++) {
 * if (extendedNums[i] == 1) currentOnesInWindow++;
 * }
 * 
 * maxOnesInWindow = currentOnesInWindow;
 * 
 * for (int i = totalOnes; i < 2 * n; i++) {
 * if (extendedNums[i - totalOnes] == 1) currentOnesInWindow--;
 * if (extendedNums[i] == 1) currentOnesInWindow++;
 * maxOnesInWindow = Math.max(maxOnesInWindow, currentOnesInWindow);
 * }
 * 
 * return totalOnes - maxOnesInWindow;
 * }
 * }
 */