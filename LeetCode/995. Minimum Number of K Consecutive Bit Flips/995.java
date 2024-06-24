class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int flip_count = 0;
        int current_flips = 0;
        
        // Use an array to track where flips happen
        int[] is_flipped = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                // Reduce the effect of flips k positions before
                current_flips ^= is_flipped[i - k];
            }
            
            // Determine if the current position needs a flip
            if ((nums[i] ^ current_flips) == 0) {
                if (i + k > n) {
                    return -1; // Not enough elements to flip
                }
                
                // Perform the flip
                flip_count++;
                current_flips ^= 1;
                is_flipped[i] = 1; // Mark this position as flipped
            }
        }
        
        return flip_count;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {0, 0, 0, 1, 0, 1, 1, 0};
        int k = 3;
        System.out.println(sol.minKBitFlips(nums, k));
    }
}