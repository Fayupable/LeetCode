class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums); // Sort the array to use two pointers
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize closest sum
        
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                // If the current sum is closer to the target than the previous closest, update closestSum
                if (Math.abs(target - currentSum) < Math.abs(target - closestSum)) {
                    closestSum = currentSum;
                }
                // Move the pointers
                if (currentSum < target) {
                    left++;
                } else if (currentSum > target) {
                    right--;
                } else {
                    // If the current sum is exactly equal to the target, it's the closest possible
                    return currentSum;
                }
            }
        }
        
        return closestSum;
    }
}