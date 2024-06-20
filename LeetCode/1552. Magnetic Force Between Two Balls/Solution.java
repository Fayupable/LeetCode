import java.util.Arrays;

public class Solution {
    public int maxDistance(int[] position, int m) {
        // Sort the positions array to make it easier to evaluate placements
        Arrays.sort(position);

        // Initialize the binary search bounds
        int left = 1;  // Minimum possible force
        int right = position[position.length - 1] - position[0];  // Maximum possible force
        int result = 0;

        // Perform binary search to find the maximum minimum force
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // Check if we can place balls with at least `mid` distance apart
            if (canPlaceBalls(position, m, mid)) {
                result = mid;  // Update result if successful
                left = mid + 1;  // Try for a larger distance
            } else {
                right = mid - 1;  // Try for a smaller distance
            }
        }

        return result;  // Return the largest minimum force found
    }

    // Helper function to check if we can place `m` balls with at least `minForce` distance apart
    private boolean canPlaceBalls(int[] position, int m, int minForce) {
        int count = 1;  // Place the first ball in the first position
        int lastPosition = position[0];  // Track the position of the last placed ball

        // Try to place the remaining balls
        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPosition >= minForce) {
                count++;  // Place a ball at position[i]
                lastPosition = position[i];  // Update the last position
                if (count >= m) {
                    return true;  // Successfully placed all `m` balls
                }
            }
        }

        return false;  // Unable to place all `m` balls with the given minimum force
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] position1 = {1, 2, 3, 4, 7};
        int m1 = 3;
        System.out.println(solution.maxDistance(position1, m1));  // Expected output: 3

        // Example 2
        int[] position2 = {5, 4, 3, 2, 1, 1000000000};
        int m2 = 2;
        System.out.println(solution.maxDistance(position2, m2));  // Expected output: 999999999
    }
}
//with heap sort
/*
 import java.util.Arrays;

public class Solution {

    public int maxDistance(int[] position, int m) {
        // Sort the positions array using heap sort
        heapSort(position);

        // Initialize the binary search bounds
        int left = 1;  // Minimum possible force
        int right = position[position.length - 1] - position[0];  // Maximum possible force
        int result = 0;

        // Perform binary search to find the maximum minimum force
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // Check if we can place balls with at least `mid` distance apart
            if (canPlaceBalls(position, m, mid)) {
                result = mid;  // Update result if successful
                left = mid + 1;  // Try for a larger distance
            } else {
                right = mid - 1;  // Try for a smaller distance
            }
        }

        return result;  // Return the largest minimum force found
    }

    // Helper function to check if we can place `m` balls with at least `minForce` distance apart
    private boolean canPlaceBalls(int[] position, int m, int minForce) {
        int count = 1;  // Place the first ball in the first position
        int lastPosition = position[0];  // Track the position of the last placed ball

        // Try to place the remaining balls
        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPosition >= minForce) {
                count++;  // Place a ball at position[i]
                lastPosition = position[i];  // Update the last position
                if (count >= m) {
                    return true;  // Successfully placed all `m` balls
                }
            }
        }

        return false;  // Unable to place all `m` balls with the given minimum force
    }

    // Heap sort implementation
    private void heapSort(int[] arr) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is an index in arr[].
    // n is size of heap
    private void heapify(int[] arr, int n, int i) {
        int largest = i;  // Initialize largest as root
        int left = 2 * i + 1;  // left = 2*i + 1
        int right = 2 * i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] position1 = {1, 2, 3, 4, 7};
        int m1 = 3;
        System.out.println(solution.maxDistance(position1, m1));  // Expected output: 3

        // Example 2
        int[] position2 = {5, 4, 3, 2, 1, 1000000000};
        int m2 = 2;
        System.out.println(solution.maxDistance(position2, m2));  // Expected output: 999999999
    }
}
 */

//other people's solution
/*
 class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        
        
             int start=1;
             int end=(position[position.length-1]-position[0])/(m-1);
             while(start<=end){
                 int mid=(end+start)/2;
                   int req=dist(position,mid);
                   if(req>=m){
                    start=mid+1;
                   }
                   else{
                    end=mid-1;
                   }

             
             }
             return end;

    }
    public int dist(int[] nums,int mid){
        int count=1;
       int last=nums[0];
        for(int i=1;i<nums.length;i++){
             if(nums[i]-last>=mid){
                count++;
                last=nums[i];
             }
        }
        return count;
    }
}
 */