using System;
using System.Linq;

public class Solution {
    public int MaxDistance(int[] position, int m) {
        // Sort the positions array to make it easier to evaluate placements
        Array.Sort(position);

        // Initialize the binary search bounds
        int left = 1;  // Minimum possible force
        int right = position[position.Length - 1] - position[0];  // Maximum possible force
        int result = 0;

        // Perform binary search to find the maximum minimum force
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // Check if we can place balls with at least `mid` distance apart
            if (CanPlaceBalls(position, m, mid)) {
                result = mid;  // Update result if successful
                left = mid + 1;  // Try for a larger distance
            } else {
                right = mid - 1;  // Try for a smaller distance
            }
        }

        return result;  // Return the largest minimum force found
    }

    // Helper function to check if we can place `m` balls with at least `minForce` distance apart
    private bool CanPlaceBalls(int[] position, int m, int minForce) {
        int count = 1;  // Place the first ball in the first position
        int lastPosition = position[0];  // Track the position of the last placed ball

        // Try to place the remaining balls
        for (int i = 1; i < position.Length; i++) {
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

    public static void Main(string[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] position1 = {1, 2, 3, 4, 7};
        int m1 = 3;
        Console.WriteLine(solution.MaxDistance(position1, m1));  // Expected output: 3

        // Example 2
        int[] position2 = {5, 4, 3, 2, 1, 1000000000};
        int m2 = 2;
        Console.WriteLine(solution.MaxDistance(position2, m2));  // Expected output: 999999999
    }
}

/*
public class Solution {
    private bool canPlace(int dist, int m, int[] p){
        int lastPlace = p[0], count = 1;

        for(int i=1; i<p.Length; i++){
            if(p[i]-lastPlace >= dist){
                count++;
                lastPlace = p[i];
                if( count == m) return true;
            }
        }
        return false;

    }

    public int MaxDistance(int[] position, int m) {
        Array.Sort(position);
        int n = position.Length;
        int low = 1, high = position[n-1], mid = 1;

        while (low<=high){
            mid = (low+high)/2;

            if(canPlace(mid, m, position)){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return high;
    }
}
*/