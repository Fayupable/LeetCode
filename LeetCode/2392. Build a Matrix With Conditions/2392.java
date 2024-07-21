class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] rowOrder = topologicalSort(k, rowConditions);
        int[] colOrder = topologicalSort(k, colConditions);

        // If it's impossible to find a valid topological order
        if (rowOrder.length == 0 || colOrder.length == 0) return new int[0][];

        // Create a mapping from number to its index in the topological order
        int[] rowIndex = new int[k + 1];
        int[] colIndex = new int[k + 1];
        for (int i = 0; i < k; i++) {
            rowIndex[rowOrder[i]] = i;
            colIndex[colOrder[i]] = i;
        }

        // Build the matrix
        int[][] matrix = new int[k][k];
        for (int i = 1; i <= k; i++) {
            matrix[rowIndex[i]][colIndex[i]] = i;
        }
        
        return matrix;
    }

    private int[] topologicalSort(int k, int[][] conditions) {
        // Graph adjacency list and in-degree array
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Build the graph
        for (int[] condition : conditions) {
            int u = condition[0];
            int v = condition[1];
            graph.get(u).add(v);
            inDegree[v]++;
        }
        
        // Topological sort using Kahn's algorithm
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int[] sorted = new int[k];
        int index = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            sorted[index++] = node;
            for (int neighbor : graph.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // If we couldn't sort all elements, it means there was a cycle
        if (index != k) return new int[0];
        
        return sorted;
    }
}