class Solution {
    public int removeElement(int[] nums, int val) {
        // Initialize the counter k
        int k = 0;

        // Iterate over the array
        for(int num : nums){
            // If the current element is not equal to the value to be removed
            if(num != val){
                // Replace the element at the position of the counter with the current element
                nums[k] = num;
                // Increment the counter
                k++;
            }
        }

        // Return the counter
        return k;
    }
}