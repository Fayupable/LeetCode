public class Solution {
    public int minPatches(int[] nums, int n) {

        long miss = 1;
        int patches = 0;
        int i = 0;

        // While the smallest sum that we want to reach is less than or equal to n
        while (miss <= n) {
            // If we haven't reached the end of the array and the current number is less than or equal to the smallest sum
            if (i < nums.length && nums[i] <= miss) {
                // Add the current number to the smallest sum
                miss += nums[i];
                // Move to the next number in the array
                i++;
            } else {
                // If the current number is greater than the smallest sum, double the smallest sum and increment the number of patches
                miss += miss;
                patches++;
            }
        }

        // Return the number of patches
        return patches;
    }
}