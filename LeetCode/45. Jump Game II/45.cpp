class Solution {
public:
    int jump(vector<int>& nums) {
        int n = nums.size();
        if (n < 2) return 0;
        int maxPos = nums[0], maxSteps = nums[0];
        int jumps = 1;
        for (int i = 1; i < n; ++i) {
            if (maxSteps < i) {
                ++jumps;
                maxSteps = maxPos;
            }
            maxPos = max(maxPos, nums[i] + i);
        }
        return jumps;
    }
};

/*
class Solution {
public:
    int jump(vector<int>& nums) {
        int n = nums.size();
        if(n==1){
            return 0;
        }
        // vector<int> dp(n, 10001);
        // for(int i=n-2;i>=0;i--){
        //     for(int j=nums[i];j>0;j--){
        //         if(i+j>=n-1){
        //             dp[i] =1;
        //         }
        //         else{
        //             dp[i] = min(dp[i], 1+dp[i+j]);
        //         }
        //     }
        // }
        // return dp[0];

        int maxStep = nums[0];
        int currMax = nums[0];
        int res=1;
        for(int i=1;i<n-1;i++){
            currMax = max(currMax, i+nums[i]);
            if(i==maxStep){
                maxStep = currMax;
                res += 1;
            }
        }
        return res;
    }
};
*/