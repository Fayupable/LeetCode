class Solution {
    public int findMaxK(int[] nums) {
        // Create a HashSet to store the numbers for faster lookup
        Set<Integer> numSet = new HashSet<>();
        // Add all numbers from the array to the set
        for (int num : nums) {
            numSet.add(num);
        }
        
        // Initialize maxK to -1. This variable will keep track of the maximum number that also has its negative in the array.
        int maxK = -1;
        // Iterate over all numbers in the array
        for (int num : nums) {
            // If the number is positive and its negative is in the set
            if (num > 0 && numSet.contains(-num)) {
                // Update maxK with the maximum of maxK and the current number
                maxK = Math.max(maxK, num);
            }
        }
        
        // Return maxK, which is the maximum number that also has its negative in the array, or -1 if there is no such number
        return maxK;
    }
}