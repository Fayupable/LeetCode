import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // Create a bucket array where the index is the weight, and the value is the count of people with that weight
        int[] buckets = new int[limit + 1];
        for (int weight : people) {
            buckets[weight]++;
        }
        
        int start = 0; // Pointer for the lightest person
        int end = limit; // Pointer for the heaviest person
        int boats = 0;
        
        while (start <= end) {
            // Move start to the next available weight with people left
            while (start <= end && buckets[start] <= 0) {
                start++;
            }
            // Move end to the previous available weight with people left
            while (start <= end && buckets[end] <= 0) {
                end--;
            }
            
            // Check if we are out of people to process
            if (buckets[start] <= 0 && buckets[end] <= 0) {
                break;
            }
            
            // We use one boat for the heaviest person at `end`
            boats++;
            
            // If the lightest person at `start` can join the heaviest person at `end` on the boat
            if (start + end <= limit && buckets[start] > 0) {
                buckets[start]--;
            }
            
            // Decrease the count for the heaviest person regardless
            if (buckets[end] > 0) {
                buckets[end]--;
            }
        }
        
        return boats;
    }
}
