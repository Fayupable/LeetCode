class Solution {
    public int maxProfit(int k, int[] prices) {
       int profit[] = new int[k];
       int cost[] = new int[k];
       
       Arrays.fill(cost, Integer.MAX_VALUE);
       
       for(int currPrice : prices){
            
            cost[0] = Math.min(cost[0], currPrice);
            
            profit[0] = Math.max(profit[0], currPrice-cost[0]);
			
            for(int j = 1;  j < k; j++){
                cost[j] = Math.min(cost[j], currPrice - profit[j-1]);
                profit[j] = Math.max(profit[j], currPrice - cost[j]);
            }
       
       }
       
       return profit[k-1];
    }
}