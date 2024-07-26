class Solution {
    public int findTheCity(int n, int[][] edges, int t) {
        int m = edges.length;
        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    d[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (edges[i][2] <= t) {
                d[edges[i][0]][edges[i][1]] = edges[i][2];
                d[edges[i][1]][edges[i][0]] = edges[i][2];
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (d[i][k] == Integer.MAX_VALUE)
                    continue;
                for (int j = i; j < n; j++) {
                    if (d[k][j] < Integer.MAX_VALUE && d[i][j] > (d[i][k] + d[k][j])) {
                        d[i][j] = d[j][i] = d[i][k] + d[k][j];
                    }
                }
            }
        }
        int count = n;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (d[i][j] <= t) {
                    c++;
                }
            }
            if (c <= count) {
                count = c;
                ans = i;
            }
        }
        return ans;
    }
}
// other people's solution
/*
 * class Solution {
 * public int findTheCity(int n, int[][] edges, int distanceThreshold) {
 * // first convert graph to adjacency list representation
 * List<List<int[]>> graph = new ArrayList<>();
 * for (int i = 0; i < n; i++) {
 * graph.add(new ArrayList<>());
 * }
 * for (int[] edge : edges) {
 * int node1 = edge[0], node2 = edge[1], distance = edge[2];
 * graph.get(node1).add(new int[]{node2, distance});
 * graph.get(node2).add(new int[]{node1, distance});
 * }
 * 
 * int minimum_number = n;
 * int res = -1;
 * 
 * for (int source = 0; source < n; source++) {
 * int neighbors = get_number_of_neighbors_in_distance(graph, source, n,
 * distanceThreshold);
 * // we iterate source from smaller to bigger this ensures that we choose node
 * with greater value if they have equal number of neighbors
 * if (neighbors <= minimum_number) {
 * minimum_number = neighbors;
 * res = source;
 * }
 * }
 * 
 * return res;
 * }
 * 
 * private int get_number_of_neighbors_in_distance(List<List<int[]>> graph, int
 * source, int n, int distanceThreshold) {
 * PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a
 * -> a[0]));
 * minHeap.add(new int[]{0, source}); // distance to node itself is 0
 * Set<Integer> visited = new HashSet<>();
 * 
 * while (!minHeap.isEmpty()) {
 * int[] top = minHeap.poll();
 * int distance_to_this_node = top[0], cur_node = top[1];
 * if (!visited.contains(cur_node)) {
 * visited.add(cur_node);
 * for (int[] neighbor : graph.get(cur_node)) {
 * int distance_from_source = distance_to_this_node + neighbor[1];
 * if (distance_from_source <= distanceThreshold) { // ensure that we're allowed
 * to go to this node
 * minHeap.add(new int[]{distance_from_source, neighbor[0]});
 * }
 * }
 * }
 * }
 * // actually you can return visited.size() and with math there will be nothing
 * wrong but actually we have visited.size() - 1 neighbors since we're not
 * neighbor of ourselves
 * return visited.size() - 1;
 * }
 * }
 */
/*
 * class Solution {
 * public int findTheCity(int n, int[][] edges, int distanceThreshold) {
 * int[][] dist = new int[n][n];
 * 
 * // Initialize the distance matrix
 * for (int i = 0; i < n; i++) {
 * for (int j = 0; j < n; j++) {
 * if (i == j) {
 * dist[i][j] = 0;
 * } else {
 * dist[i][j] = Integer.MAX_VALUE / 2; // Use /2 to prevent overflow
 * }
 * }
 * }
 * 
 * // Update the distance matrix with the edges
 * for (int[] edge : edges) {
 * int u = edge[0];
 * int v = edge[1];
 * int wt = edge[2];
 * dist[u][v] = wt;
 * dist[v][u] = wt;
 * }
 * 
 * // Apply Floyd-Warshall algorithm
 * for (int k = 0; k < n; k++) {
 * for (int i = 0; i < n; i++) {
 * for (int j = 0; j < n; j++) {
 * if (dist[i][k] + dist[k][j] < dist[i][j]) {
 * dist[i][j] = dist[i][k] + dist[k][j];
 * }
 * }
 * }
 * }
 * 
 * int city = -1;
 * int minCount = n;
 * 
 * // Find the city with the smallest number of reachable cities within
 * distanceThreshold
 * for (int i = 0; i < n; i++) {
 * int count = 0;
 * for (int j = 0; j < n; j++) {
 * if (i != j && dist[i][j] <= distanceThreshold) {
 * count++;
 * }
 * }
 * if (count < minCount) {
 * minCount = count;
 * city = i;
 * } else if (count == minCount && i > city) {
 * city = i;
 * }
 * }
 * 
 * return city;
 * }
 * }
 */