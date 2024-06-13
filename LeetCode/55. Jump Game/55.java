class Solution {
    public boolean canJump(int[] nums) {
        // Initialize canJumpLength to the last index of the array
        int canJumpLength = nums.length - 1;
        // Iterate from the end of the array to the beginning
        for(int i = nums.length - 1; i >= 0; i--){
            // If the current index plus the maximum jump length from the current index
            // is greater than or equal to canJumpLength
            if(i + nums[i] >= canJumpLength){
                // Update canJumpLength to the current index
                canJumpLength = i;
            }
        }
        // Return true if canJumpLength is 0 (i.e., we can reach the first index from the last index)
        return canJumpLength == 0;
    }
}
