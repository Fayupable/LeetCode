class Solution {
public:
    int subsetXORSum(vector<int>& nums) {
        int n = nums.size();
        int subsetNum =1<<n;
        int total=0;
        
        //generate each subset one by one
        for(int i=0;i<subsetNum;i++){
            int xorSum=0;
            for(int j=0;j<n;j++){
                if(i&(1<<j)){
                    xorSum^=nums[j];
                }
            }
            total+=xorSum;
        }
        return total;
        
    }
};