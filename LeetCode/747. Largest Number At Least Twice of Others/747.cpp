class Solution {
public:
    int dominantIndex(vector<int>& nums) {
        
        int maxIndex=0;
        for(int i=0;i<nums.size();i++){
            if(nums[i]>nums[maxIndex]){
                maxIndex=i;
            }
        }
        for(int i=0;i<nums.size();i++){
            if(maxIndex!=i && nums[maxIndex]<2*nums[i]){
                return -1;
            }
        }
        return maxIndex;
    }
};

/*
class Solution {
public:
    int dominantIndex(vector<int>& nums) {
        
        int index = 0, maxVal = 0, maxIndx=0, secondMax = 0;
        for(int i=0; i<nums.size(); i++)
        {
            if(secondMax < nums[i])
            {
                secondMax = nums[i];
            }
            
            if(maxVal < nums[i])
            {
                secondMax = maxVal;
                maxIndx = i;
                maxVal = nums[i];
            }
            
        }  
        if(maxVal >= secondMax*2)
        {
            return maxIndx;
        }
        else
        {
            return -1;
        }

        return -1;                   
    }
};
*/