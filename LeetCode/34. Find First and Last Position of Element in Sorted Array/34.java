
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] {-1, -1};  
        result[0] = findFirst(nums, target);  
        result[1] = findLast(nums, target);   
        return result;
    }

    private int findFirst(int[] nums, int target) {
        int idx = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            if (nums[mid] == target) idx = mid;
        }
        return idx;
    }

    private int findLast(int[] nums, int target) {
        int idx = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            if (nums[mid] == target) idx = mid;
        }
        return idx;
    }
    int nums[] = {5,7,7,8,8,10};
    int target = 8;
    System.out.println(searchRange(nums, target));
    
}
