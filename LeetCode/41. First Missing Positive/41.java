class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        placeNumbers(nums, n);
        return findFirstMismatch(nums, n);
    }

    private void placeNumbers(int[] nums, int n) {
        for (int i = 0; i < n; i++) {
            while (isInRange(nums[i], n) && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
    }

    private boolean isInRange(int num, int n) {
        return num > 0 && num <= n;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int findFirstMismatch(int[] nums, int n) {
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}