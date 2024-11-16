class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] results = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            if (isConsecutiveAndSorted(nums, i, k)) {
                results[i] = findMax(nums, i, k);
            } else {
                results[i] = -1;
            }
        }
        return results;
    }

    private boolean isConsecutiveAndSorted(int[] nums, int start, int k) {
        for (int i = start; i < start + k - 1; i++) {
            if (nums[i + 1] != nums[i] + 1) {
                return false;
            }
        }
        return true;
    }

    private int findMax(int[] nums, int start, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i < start + k; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}