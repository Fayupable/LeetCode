using System;
using System.Linq;

public class Solution {
    public long MaximumImportance(int n, int[][] roads) {
        // degree[i] is the degree of the i-th node
        long[] degree = new long[n];

        // Calculate the degree of each node
        foreach (var road in roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }

        // Sort the nodes by their degree in descending order
        int[] indices = Enumerable.Range(0, n).ToArray();
        Array.Sort(indices, (a, b) => degree[b].CompareTo(degree[a]));
        // Assign the importance value to each node
        long[] value = new long[n];
        // The node with the highest degree gets the highest importance value
        for (int i = 0; i < n; i++) {
            // The importance value is n - i
            value[indices[i]] = n - i;
        }
        // Calculate the total importance value
        long totalImportance = 0;
        // The importance value of a road is the sum of the importance values of its two nodes
        foreach (var road in roads) {
            // The importance value of a road is the sum of the importance values of its two nodes
            totalImportance += value[road[0]] + value[road[1]];
        }

        return totalImportance;
    }
}