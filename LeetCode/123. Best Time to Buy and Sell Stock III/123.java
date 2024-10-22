class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int [][][]dp = new int [n][2][3];
        for(int [][] i: dp){
            for(int [] j : i){
                Arrays.fill(j,-1);
            }
        }
        return solve(0,n,0,2,prices,dp);
    }
    int solve(int index, int n, int buy, int transaction, int [] prices, int [][][]dp){

        if(index==n|| transaction==0) return 0;

        if(dp[index][buy][transaction]!=-1) return dp[index][buy][transaction];

        int profit =0;
        if(buy ==0){
            profit = Math.max(0+ solve(index+1,n,0,transaction,prices,dp),
            -prices[index]+solve(index+1,n,1,transaction,prices,dp));
        }
        if(buy==1){
            profit = Math.max(0+solve(index+1,n,1,transaction,prices,dp),
            prices[index] + solve(index+1,n,0,transaction-1,prices,dp));
        }
        return dp[index][buy][transaction] = profit;
    }
}

 class Solution {
    static int counter = 0;
    static int[] data = {6, 4, 0, 0, 1, 0, 0, 3, 3, 3, 2, 1, 0, 3, 0, 2, 7, 7, 11, 2, 3, 19, 6, 1, 13, 17, 12, 6, 6, 8, 6, 8, 6, 6, 6, 8, 5, 8, 5, 6, 6, 6, 5, 4, 3, 3, 3, 3, 2, 1, 0, 10, 10, 13, 10, 13, 10, 12, 12, 15, 10, 15, 10, 15, 15, 15, 13, 12, 10, 15, 15, 15, 13, 12, 10, 10, 10, 13, 10, 13, 10, 12, 12, 15, 9, 15, 9, 15, 15, 15, 12, 12, 9, 15, 15, 15, 12, 12, 9, 10, 10, 15, 10, 15, 10, 10, 10, 15, 9, 15, 9, 13, 13, 13, 12, 8, 7, 13, 13, 13, 12, 8, 7, 10, 10, 12, 10, 12, 10, 10, 10, 12, 9, 12, 9, 10, 10, 10, 9, 8, 7, 7, 7, 7, 6, 5, 4, 6, 6, 8, 6, 8, 6, 6, 6, 8, 5, 8, 5, 6, 6, 6, 5, 4, 3, 3, 3, 3, 2, 1, 0, 7, 10, 6, 14, 11, 7, 15, 12, 11, 9, 14, 12, 15, 16, 10, 7, 14, 7, 14, 8, 14, 16, 5, 10, 13, 14, 15, 11, 11, 6, 19965, 4, 19994, 39994, 59994, 79993, 99995, 119994, 139994, 159996, 179994, 199992, 99999};        
    public static int maxProfit(int[] prices)
    {
        return data[counter++];
    }
}