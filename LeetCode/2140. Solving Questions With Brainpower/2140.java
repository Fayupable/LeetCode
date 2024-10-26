class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0];
            int brainpower = questions[i][1];
            int nextIndex = i + brainpower + 1;

            long solve = points + (nextIndex < n ? dp[nextIndex] : 0);
            long skip = dp[i + 1];

            dp[i] = Math.max(solve, skip);
        }
        return dp[0];
    }
}

/*
 * class Solution {
 * public long mostPoints(int[][] arr) {
 * int n = arr.length;
 * long ans = 0;
 * long[] dp = new long[n];
 * for (int i = 0; i < n; i++) dp[i] = arr[i][0];
 * for (int i = n - 1; i > -1; i--) {
 * int x = i + arr[i][1] + 1;
 * if ( x < n) {
 * dp[i] += dp[x];
 * }
 * if (ans < dp[i]) ans = dp[i];
 * else dp[i] = ans;
 * }
 * return ans;
 * }
 * }
 * 
 */