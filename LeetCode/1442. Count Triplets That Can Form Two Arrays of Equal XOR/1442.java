class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length; // Get the length of the array
        int[] prefix = new int[n+1]; // Initialize the prefix array

        // Compute the prefix XOR of the array
        for(int i = 0; i < n; i++){
            prefix[i+1] = prefix[i] ^ arr[i];
        }

        int count = 0; // Initialize the count of triplets

        // Iterate over the array to find triplets
        for(int i = 0; i < n; i++){
            for (int k = i + 1; k < n; k++) {
                // If the XOR of the prefix array at indices i and k+1 is equal
                if (prefix[i] == prefix[k + 1]) {
                    // Increment the count by the difference of k and i
                    count += (k - i);
                }
            }
        }

        return count; // Return the count of triplets
    }
}


/*
 class Solution {
    public int countTriplets(int[] nums) {
       
        int count = 0;
  
        for(int i = 0; i < nums.length; i++){
            int xor = 0;
            for(int j = i; j < nums.length; j++){
                xor ^= nums[j];
                if(xor == 0) count += (j - i);
            }
        }
        
        return count;
    }
}
 */


 /*
  class Solution {
    public int countTriplets(int[] arr) {
        // Inserting 0 at the beginning of the array to handle the case when XOR operation is performed on the first element
        int[] modifiedArr = new int[arr.length + 1];
        modifiedArr[0] = 0;
        System.arraycopy(arr, 0, modifiedArr, 1, arr.length);

        int size = modifiedArr.length;
        int res = 0;

        // Performing XOR operation on the array elements
        for (int i = 1; i < size; ++i)
            modifiedArr[i] ^= modifiedArr[i - 1];

        // Maps to store counts and totals of XOR values encountered
        HashMap<Integer, Integer> countMap = new HashMap<>();
        HashMap<Integer, Integer> totalMap = new HashMap<>();

        // Iterating through the array
        for (int i = 0; i < size; ++i) {
            // Calculating contribution of current element to the result
            res += countMap.getOrDefault(modifiedArr[i], 0) * (i - 1) - totalMap.getOrDefault(modifiedArr[i], 0);

            // Updating total count of current XOR value
            totalMap.put(modifiedArr[i], totalMap.getOrDefault(modifiedArr[i], 0) + i);
            countMap.put(modifiedArr[i], countMap.getOrDefault(modifiedArr[i], 0) + 1);
        }

        // Returning the final result
        return res;
    }
}
  */
  /*
   class Solution {
    public int countTriplets(int[] arr) {
        int count = 0;
        
        // Iterate over each possible starting index i
        for (int start = 0; start < arr.length - 1; ++start) {
            // Initialize XOR value for the subarray from start to mid-1
            int xorA = 0;
            
            // Iterate over each possible middle index j
            for (int mid = start + 1; mid < arr.length; ++mid) {
                // Update xorA to include arr[mid - 1]
                xorA ^= arr[mid - 1];
                
                // Initialize XOR value for the subarray from mid to end
                int xorB = 0;
                
                // Iterate over each possible ending index k (starting from mid)
                for (int end = mid; end < arr.length; ++end) {
                    // Update xorB to include arr[end]
                    xorB ^= arr[end];
                    
                    // found a valid triplet (start, mid, end)
                    if (xorA == xorB) {
                        ++count;
                    }
                }
            }
        }
        
        return count;
    }
}
   */

   /*
    import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int prefix = 0;
        int count = 0;
        Map<Integer, Integer> prefixCount = new HashMap<>();
        Map<Integer, Integer> prefixSum = new HashMap<>();

        prefixCount.put(0, 1);  // Initialize with prefix 0 having one count
        prefixSum.put(0, 0);    // Initialize with sum of indices for prefix 0 as 0

        for (int i = 0; i < n; i++) {
            prefix ^= arr[i];

            if (prefixCount.containsKey(prefix)) {
                count += prefixCount.get(prefix) * i - prefixSum.get(prefix);
            }

            prefixCount.put(prefix, prefixCount.getOrDefault(prefix, 0) + 1);
            prefixSum.put(prefix, prefixSum.getOrDefault(prefix, 0) + (i + 1));
        }

        return count;
    }

}
    */