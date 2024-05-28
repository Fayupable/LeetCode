class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Sort the array to simplify finding triplets and avoiding duplicates
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int lo = i + 1, hi = nums.length - 1, sum = -nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        // Skip duplicates for lo and hi
                        while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                        lo++; hi--;
                    } else if (nums[lo] + nums[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return result;
    }
}