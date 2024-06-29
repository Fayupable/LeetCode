import java.util.*;

class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Set<Integer>> ancestors = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            // Initialize the ancestors and graph
            ancestors.add(new HashSet<>());
            // Initialize the graph
            graph.add(new ArrayList<>());
        }
        
        // Build the reversed graph
        for (int[] edge : edges) {
            // Add the edge to the reversed graph
            graph.get(edge[1]).add(edge[0]);
        }
        
        // Use BFS to find all ancestors for each node
        for (int i = 0; i < n; i++) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            // Add the node itself as its ancestor
            while (!queue.isEmpty()) {
                // Get the current node
                int current = queue.poll();
                // Add the current node as its ancestor
                for (int parent : graph.get(current)) {
                    // If this ancestor is newly discovered for node i
                    if (ancestors.get(i).add(parent)) {
                        // Add this ancestor to the queue
                        queue.add(parent);
                    }
                }
            }
        }
        
        // Convert sets to sorted lists
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // Convert set to sorted list
            List<Integer> sortedList = new ArrayList<>(ancestors.get(i));
            // Sort the list
            Collections.sort(sortedList);
            // Add the sorted list to the result
            result.add(sortedList);
        }
        
        return result;
    }
}
/*
 class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0; i<n; i++){
            res.add(new ArrayList<>());
        } 

        ArrayList<Integer>[] graph=new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i]=new ArrayList<>();
        }   
        for(int[] edge: edges){
            graph[edge[0]].add(edge[1]);
        }
        for(int i=0; i<n; i++){
            dfs(graph,i,i,res,new boolean[n]);
        }
        return res;
    }
    public void dfs( ArrayList<Integer>[] graph, int parent, int curr, List<List<Integer>> res,boolean[] visit){
        visit[curr]=true;
        for(int i=0; i< graph[curr].size(); i++){
            int dest=graph[curr].get(i);
            if(!visit[dest]){
                res.get(dest).add(parent);
                dfs(graph,parent,dest,res,visit);
            }
        }
    }
}
 */
/*
 class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ancestors = new ArrayList<>();
        List<Integer>[] graph = new List[n];

        for(int node = 0; node < n; node++){
            ancestors.add(new ArrayList<>());
            graph[node] = new ArrayList<>();
        }

        for(int[] edge : edges){
            int parent = edge[0];
            int child = edge[1];
            graph[parent].add(child);
        }

        for(int node = 0; node < n; node++)
            getAllAncestors(node, node, new boolean[n], graph, ancestors);

        return ancestors;
    }

    private void getAllAncestors(int node, int ancestor, boolean[] passed, List<Integer>[] graph, List<List<Integer>> ancestors){
        passed[node] = true;        

        for(int child : graph[node]){
            if(passed[child]) continue;
            ancestors.get(child).add(ancestor);
            getAllAncestors(child, ancestor, passed, graph, ancestors);
        }
            
    }
}
 */