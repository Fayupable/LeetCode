class Solution {
    public int removeDuplicates(int[] nums) {
        // If the array is empty, return 0
        if(nums.length == 0){
            return 0;
        }

        // Initialize the counter i
        int i = 0;

        // Iterate over the array starting from the second element
        for(int j = 1; j < nums.length; j++){
            // If the current element is not equal to the previous one
            if(nums[j] != nums[i]){
                // Increment the counter
                i++;
                // Replace the element at the next position of the counter with the current element
                nums[i] = nums[j];
            }
        }

        // Return the counter incremented by 1 (because it's zero-indexed)
        return i + 1;
    }
}