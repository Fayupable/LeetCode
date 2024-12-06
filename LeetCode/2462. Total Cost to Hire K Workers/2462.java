class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
           long result = 0;
           int n = costs.length;
           if (k == costs.length) {
               for (int i = 0; i < costs.length; i++) {
                   result += costs[i];
               }
               
               return result;
           }
   
           if ((2 * candidates) + k > costs.length) {
               Arrays.sort(costs);
               for (int i = 0; i < k; i++) {
                   result += costs[i];
               }
   
               return result;
           }
   
           PriorityQueue<Integer> left = new PriorityQueue<>();
           PriorityQueue<Integer> right = new PriorityQueue<>();
   
           for (int i = 0; i < candidates; i++) {
               left.offer(costs[i]);
               right.offer(costs[n-1-i]);
           }
   
           int l = candidates, r = n - 1 - candidates;
   
           while (k-- > 0) {
               if (left.peek() <= right.peek()) {
                   result += left.poll();
                   left.offer(costs[l++]);
               } else {
                   result += right.poll();
                   right.offer(costs[r--]);
               }
           }
   
           return result;
       }
   }