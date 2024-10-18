class Solution {
    public int findLongestChain(int[][] pairs) {

        int n = pairs.length;
        int [] dp = new int [n];
        int maxi=1;
        Arrays.fill(dp,1);
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(pairs[i][0]>pairs[j][1] && 1+dp[j]>dp[i]){
                    dp[i]=1+dp[j];
                }
            }
            if(dp[i]>=maxi) maxi = dp[i];
        }      
        return maxi;
    }
}