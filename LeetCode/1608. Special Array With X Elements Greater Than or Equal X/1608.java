import java.util.Arrays;

class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] >= n - i) {
                if (i == 0 || nums[i - 1] < n - i) {
                    return n - i;
                }
            }
        }
        return -1;
    }
}

/*
  class Solution {
    public int specialArray(int[] nums) {
        int[] numCounts = new int[nums.length+1];
        for(int num: nums)
            if(num>nums.length)
                numCounts[nums.length]++;
            else
                numCounts[num]++;
        int bigNumsCount = 0;
        for(int specialGuess = nums.length; specialGuess>0; specialGuess--){
            bigNumsCount += numCounts[specialGuess];
            if(bigNumsCount > specialGuess)
                return -1;
            if(bigNumsCount == specialGuess)
                return specialGuess;
        }
        return -1;
    }
}
 */