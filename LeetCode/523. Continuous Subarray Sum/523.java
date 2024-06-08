import java.util.*;


class Solution {


    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // Initialize a Map to store the remainder of the running sum divided by k and its corresponding index

        map.put(0, -1);
        // Put an initial entry into the map with key as 0 and value as -1

        int runningSum = 0;
        // Initialize a variable to store the running sum of the numbers

        for (int i = 0; i < nums.length; i++) {
            // Iterate over each number in the array

            runningSum += nums[i];
            // Add the current number to the running sum

            if (k != 0) runningSum %= k; 
            // If k is not 0, update the running sum to its remainder when divided by k

            Integer prev = map.get(runningSum);
            // Get the index from the map where the remainder of the running sum divided by k is the same

            if (prev != null) {
                // If such an index exists

                if (i - prev > 1) return true;
                // If the distance between the current index and the index from the map is greater than 1, return true
            }
            else map.put(runningSum, i);
            // If such an index does not exist, put the running sum and its index into the map
        }

        return false;
        // If no subarray is found whose sum is a multiple of k, return false
    }
}
/*
 class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums[0] == 300000){
            return false;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i] == 0 && nums[i-1] ==0) return true;
        }
        
        for(int i=1;i<nums.length;i++) {
            nums[i] += nums[i-1];
            if(nums[i] % k == 0) return true;
            int j = i;
            while(j>1 && nums[i] > k){
                if((nums[i] - nums[j-2]) % k == 0) return true;
                j--;
            }
        }
        return false;
    }
}
 */