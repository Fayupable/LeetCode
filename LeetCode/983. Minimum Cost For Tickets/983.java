class Solution {
    public int mincostTickets(int[] D, int[] C) {
        int c1 = C[0], c7 = C[1], c30 = C[2];
        int n = D.length;
        if(D[0] != 1){
            int x = D[0] - 1;
            for(int i = 0; i < n; i++)
                D[i] -= x;
        }
        int m = D[n - 1];
        int[] dp = new int[m + 1];
        int k = 0;
        for(int i = 1; i <= m; i++){
            if(D[k] != i){
                dp[i] = dp[i - 1];
                continue;
            }
            k++;
            int val = dp[i - 1] + c1;
            int j = Math.max(0, i - 7);
            val = Math.min(val, dp[j] + c7);
            j = Math.max(0, i - 30);
            dp[i] = Math.min(val, dp[j] + c30);
        }
        return dp[m];
    }
}