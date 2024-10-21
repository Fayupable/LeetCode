class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dpb = new int[n];  
        int[] dps = new int[n];  
        Arrays.fill(dpb, -1);    
        Arrays.fill(dps, -1);    

        return dfs(prices, dpb, dps, 0, null);
    }

    private int dfs(int[] prices, int[] dpb, int[] dps, int i, Integer stockPrice) {
        if (i >= prices.length) {
            return 0;
        }

        if (stockPrice == null && dpb[i] != -1) {  
            return dpb[i];
        }
        if (stockPrice != null && dps[i] != -1) {  
            return dps[i];
        }

        int price = prices[i];
        int skip = dfs(prices, dpb, dps, i + 1, stockPrice);  

        if (stockPrice != null) {  
            int sell = price + dfs(prices, dpb, dps, i + 2, null);  
            dps[i] = Math.max(skip, sell);
            return dps[i];
        } else {  
            int buy = dfs(prices, dpb, dps, i + 1, price) - price;  
            dpb[i] = Math.max(buy, skip);
            return dpb[i];
        }
    }
}