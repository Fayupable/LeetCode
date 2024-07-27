import java.util.Arrays;

class Solution {

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = source.length();
        int m = original.length;
        int ALPHABET_SIZE = 26;

        // Step 1: Initialize the distance matrix with given transformations
        long[][] dist = initializeDistanceMatrix(ALPHABET_SIZE, original, changed, cost);

        // Step 2: Apply Floyd-Warshall algorithm to compute shortest paths
        applyFloydWarshall(dist, ALPHABET_SIZE);

        // Step 3: Calculate the total minimum cost to convert source to target
        return calculateTotalCost(source, target, dist);
    }

    private long[][] initializeDistanceMatrix(int ALPHABET_SIZE, char[] original, char[] changed, int[] cost) {
        long[][] dist = new long[ALPHABET_SIZE][ALPHABET_SIZE];
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
            dist[i][i] = 0; // Distance to self is zero
        }

        // Fill the distance matrix with given transformation costs
        for (int i = 0; i < original.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            dist[from][to] = Math.min(dist[from][to], cost[i]); // Consider the minimum cost for the same transformation
        }

        return dist;
    }

    private void applyFloydWarshall(long[][] dist, int ALPHABET_SIZE) {
        // Apply Floyd-Warshall algorithm to find shortest paths between all pairs of
        // nodes
        for (int k = 0; k < ALPHABET_SIZE; k++) {
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                for (int j = 0; j < ALPHABET_SIZE; j++) {
                    if (dist[i][k] != Long.MAX_VALUE && dist[k][j] != Long.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    }

    private long calculateTotalCost(String source, String target, long[][] dist) {
        long totalCost = 0;

        for (int i = 0; i < source.length(); i++) {
            int srcChar = source.charAt(i) - 'a';
            int tgtChar = target.charAt(i) - 'a';

            // If there is no valid transformation path, return -1
            if (dist[srcChar][tgtChar] == Long.MAX_VALUE) {
                return -1;
            }

            totalCost += dist[srcChar][tgtChar];
        }

        return totalCost;
    }
}

/*
 * class Solution {
 * public long minimumCost(String source, String target, char[] original, char[]
 * changed, int[] cost) {
 * int[][] dis = new int[26][26];
 * for (int i = 0; i < 26; i++) {
 * Arrays.fill(dis[i], Integer.MAX_VALUE);
 * dis[i][i] = 0;
 * }
 * for (int i = 0; i < cost.length; i++) {
 * dis[original[i] - 'a'][changed[i] - 'a'] = Math.min(dis[original[i] -
 * 'a'][changed[i] - 'a'], cost[i]);
 * }
 * for (int k = 0; k < 26; k++) {
 * for (int i = 0; i < 26; i++)
 * if (dis[i][k] < Integer.MAX_VALUE) {
 * for (int j = 0; j < 26; j++) {
 * if (dis[k][j] < Integer.MAX_VALUE) {
 * dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
 * }
 * }
 * }
 * }
 * long ans = 0L;
 * for (int i = 0; i < source.length(); i++) {
 * int c1 = source.charAt(i) - 'a';
 * int c2 = target.charAt(i) - 'a';
 * if (dis[c1][c2] == Integer.MAX_VALUE) {
 * return -1L;
 * } else {
 * ans += (long)dis[c1][c2];
 * }
 * }
 * return ans;
 * }
 * }
 */