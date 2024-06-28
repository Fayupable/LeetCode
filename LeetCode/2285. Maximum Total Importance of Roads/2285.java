import java.util.*;

class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long[] degree = new long[n];

        // Count the degree for each city
        for (int[] road : roads) {
            // Increment the degree of the cities
            degree[road[0]]++;
            degree[road[1]]++;
        }

        // Sorting the degrees and keep track of city indices
        Integer[] indices = new Integer[n];
        // Initialize the indices
        for (int i = 0; i < n; i++) {
            // i is the index
            indices[i] = i;
        }
        // Sort the indices based on the degree
        Arrays.sort(indices, (a, b) -> Long.compare(degree[b], degree[a]));

        // Assign the highest values to the most connected cities
        long[] value = new long[n];
        // Assign the values to the cities
        for (int i = 0; i < n; i++) {
            // n - i is the value
            value[indices[i]] = n - i;
        }

        // Compute the total importance of all roads
        long totalImportance = 0;
        for (int[] road : roads) {
            // Add the values of the cities
            totalImportance += value[road[0]] + value[road[1]];
        }

        return totalImportance;
    }
}