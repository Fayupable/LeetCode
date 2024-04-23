import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(0);
            return result;
        }
        
        // Graph construction
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        // Initialize leaves
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        
        // Main loop until we have 1 or 2 nodes left
        while (n > 2) {
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                int neighbor = graph.get(leaf).iterator().next();
                graph.get(neighbor).remove(leaf);
                if (graph.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            n -= leaves.size();
            leaves = newLeaves;
        }
        
        return leaves;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 4;
        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
        System.out.println(s.findMinHeightTrees(n, edges));
    }
}

