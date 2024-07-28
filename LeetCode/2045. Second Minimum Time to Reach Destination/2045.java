class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++)
            graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        Deque<int[]> deque = new LinkedList<>();
        int[] visitedNum = new int[n + 1];
        int[] timeArr = new int[n + 1];
        Arrays.fill(timeArr, -1);
        deque.offerLast(new int[] { 1, 0 });
        timeArr[0] = 0;

        while (deque.size() > 0) {
            int curSize = deque.size();
            for (int i = 0; i < curSize; i++) {
                int[] cur = deque.pollFirst();
                // if(cur[0]==n && visitedNum[cur[0]]==2) return cur[1];

                int nextTime = 0;
                int curLight = cur[1] / change;
                if (curLight % 2 == 0) {
                    nextTime = cur[1] + time;
                }
                // nextTime=(curLight+1)*change+time;
                else
                    nextTime = (curLight + 1) * change + time;

                for (int nextNode : graph[cur[0]]) {
                    if (visitedNum[nextNode] < 2 && timeArr[nextNode] < nextTime) {
                        deque.offerLast(new int[] { nextNode, nextTime });
                        visitedNum[nextNode]++;
                        timeArr[nextNode] = nextTime;
                        if (nextNode == n && visitedNum[nextNode] == 2)
                            return nextTime;
                    }
                }

            }
        }
        return -1;
    }

}

/*
 * import java.util.*;
 * 
 * class Solution {
 * public int secondMinimum(int n, int[][] edges, int time, int change) {
 * List<Integer>[] graph = buildGraph(n, edges);
 * return bfsSecondMinimum(n, graph, time, change);
 * }
 * 
 * private List<Integer>[] buildGraph(int n, int[][] edges) {
 * List<Integer>[] graph = new List[n + 1];
 * for (int i = 1; i <= n; ++i) {
 * graph[i] = new ArrayList<>();
 * }
 * for (int[] edge : edges) {
 * final int u = edge[0];
 * final int v = edge[1];
 * graph[u].add(v);
 * graph[v].add(u);
 * }
 * return graph;
 * }
 * 
 * private int calculateWaitTime(int prevTime, int change) {
 * final int numChangeSignal = prevTime / change;
 * return numChangeSignal % 2 == 0 ? 0 : change - prevTime % change;
 * }
 * 
 * private int bfsSecondMinimum(int n, List<Integer>[] graph, int time, int
 * change) {
 * Queue<int[]> q = new ArrayDeque<>(Arrays.asList(new int[]{1, 0})); // (index,
 * time)
 * int[][] minTime = new int[n + 1][2];
 * Arrays.stream(minTime).forEach(A -> Arrays.fill(A, Integer.MAX_VALUE));
 * minTime[1][0] = 0;
 * 
 * while (!q.isEmpty()) {
 * final int i = q.peek()[0];
 * final int prevTime = q.poll()[1];
 * final int waitTime = calculateWaitTime(prevTime, change);
 * final int newTime = prevTime + waitTime + time;
 * 
 * for (final int j : graph[i]) {
 * if (newTime < minTime[j][0]) {
 * minTime[j][0] = newTime;
 * q.offer(new int[]{j, newTime});
 * } else if (minTime[j][0] < newTime && newTime < minTime[j][1]) {
 * if (j == n) return newTime;
 * minTime[j][1] = newTime;
 * q.offer(new int[]{j, newTime});
 * }
 * }
 * }
 * 
 * throw new IllegalArgumentException();
 * }
 * }
 */

/*
 * class Solution {
 * public int secondMinimum(int n, int[][] edges, int time, int change) {
 * List<List<Integer>> adj = new ArrayList<>();
 * 
 * for (int i = 0; i <= n; i++) {
 * adj.add(new ArrayList<>());
 * }
 * 
 * for (int[] edge : edges) {
 * int u = edge[0];
 * int v = edge[1];
 * 
 * adj.get(u).add(v);
 * adj.get(v).add(u);
 * }
 * 
 * int[] dist1 = new int[n + 1];
 * int[] dist2 = new int[n + 1];
 * 
 * Arrays.fill(dist1, Integer.MAX_VALUE);
 * Arrays.fill(dist2, Integer.MAX_VALUE);
 * 
 * int[] freq = new int[n + 1];
 * 
 * Queue<int[]> queue = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
 * 
 * queue.add(new int[] { 1, 0 });
 * 
 * while (!queue.isEmpty()) {
 * int[] curr = queue.poll();
 * 
 * int currStop = curr[0];
 * int currTime = curr[1];
 * 
 * freq[currStop]++;
 * 
 * if (currStop == n && freq[currStop] == 2) {
 * return currTime;
 * }
 * 
 * // catch
 * if ((currTime / change) % 2 != 0) {
 * currTime = change * ((currTime / change) + 1);
 * }
 * 
 * for (int nextStop : adj.get(currStop)) {
 * if (dist1[nextStop] > currTime + time) {
 * dist2[nextStop] = dist1[nextStop];
 * dist1[nextStop] = currTime + time;
 * 
 * queue.add(new int[] { nextStop, dist1[nextStop] });
 * }
 * else if (dist2[nextStop] > currTime + time && dist1[nextStop] != currTime +
 * time) {
 * dist2[nextStop] = currTime + time;
 * 
 * queue.add(new int[] { nextStop, dist2[nextStop] });
 * }
 * }
 * }
 * 
 * return -1;
 * }
 * }
 */