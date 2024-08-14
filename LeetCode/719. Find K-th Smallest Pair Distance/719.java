import java.util.Arrays;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums); 
        int left = 0;  
        int right = nums[nums.length - 1] - nums[0];  

        while (left < right) {
            int mid = (left + right) / 2;
            if (countPairs(nums, mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private int countPairs(int[] nums, int maxDistance) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            while (j < nums.length && nums[j] - nums[i] <= maxDistance) {
                j++;
            }
            count += j - i - 1;
        }
        return count;
    }
}