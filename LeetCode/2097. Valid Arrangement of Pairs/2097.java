import java.util.*;

class Solution {
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();

        for (int[] pair : pairs) {
            graph.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
            outDegree.put(pair[0], outDegree.getOrDefault(pair[0], 0) + 1);
            inDegree.put(pair[1], inDegree.getOrDefault(pair[1], 0) + 1);
        }

        int start = pairs[0][0];
        for (int key : graph.keySet()) {
            if (outDegree.getOrDefault(key, 0) > inDegree.getOrDefault(key, 0)) {
                start = key;
                break;
            }
        }

        List<int[]> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.peek();
            if (graph.containsKey(node) && !graph.get(node).isEmpty()) {
                stack.push(graph.get(node).remove(graph.get(node).size() - 1));
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    result.add(new int[]{stack.peek(), node});
                }
            }
        }

        Collections.reverse(result);
        return result.toArray(new int[result.size()][]);
    }
}