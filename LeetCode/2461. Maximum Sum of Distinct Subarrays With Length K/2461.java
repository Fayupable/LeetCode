
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0, currentSum = 0;
        HashSet<Integer> distinctElements = new HashSet<>();
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (distinctElements.contains(nums[right])) {
                currentSum -= nums[left];
                distinctElements.remove(nums[left]);
                left++;
            }

            distinctElements.add(nums[right]);
            currentSum += nums[right];

            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, currentSum);
                currentSum -= nums[left];
                distinctElements.remove(nums[left]);
                left++;
            }
        }

        return maxSum;
    }
}