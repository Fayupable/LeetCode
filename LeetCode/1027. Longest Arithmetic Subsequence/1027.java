class Solution {
    static final int LIMIT = 500;
    
    public int longestArithSeqLength(int[] nums) {
        int maxSeqLen = 2;
        int maxNum = nums[0];
        int minNum = nums[0];
        for (int num : nums) {
            if (num > maxNum)  maxNum = num;
            if (num < minNum)  minNum = num;
        }
        int maxDiff = maxNum - minNum;
        int[] dpUp = new int[maxNum + 1];
        int[] dpDown = new int[maxNum + 1];
        for (int k = 0; k * maxSeqLen <= maxDiff; k++) {
            Arrays.fill(dpUp, 0);
            Arrays.fill(dpDown, 0);
            for (int num : nums) {
                if (maxSeqLen < (dpUp[num] = (num + k <= maxNum) ? 
                                 (dpUp[num + k] + 1) : 1))
                    maxSeqLen = dpUp[num];
                if (maxSeqLen < (dpDown[num] = (num - k >= 0) ? 
                                 (dpDown[num - k] + 1) : 1))
                    maxSeqLen = dpDown[num];
            }
        }
        return maxSeqLen;
    }
}