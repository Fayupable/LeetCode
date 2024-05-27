//Time Complexity: O(nlogn)
class Solution {
public:
    int specialArray(vector<int>& nums) {
        std::sort(nums.begin(), nums.end());
        int n = nums.size();

        for (int i = 0; i < n; i++)
        {
            if(nums[i] >= n - i)
            {
                if(i == 0|| nums[i-1] < n - i)
                {
                    return n - i;
                }
        }
        

        
    }
            return -1;

};
};


/*
*Time complexity: O(nlogn)
class Solution {
public:
    int specialArray(vector<int>& nums) {
        
        sort(nums.begin(),nums.end());
        for(int i=0;i<=1000;i++){
            int s=0,e=nums.size()-1,ans=-1;
            while(s<=e){
                int mid=s+(e-s)/2;
                if(nums[mid]>=i){
                    ans=mid;
                    e=mid-1;
                }
                else s=mid+1;
            }
            if(nums.size()-ans==i && ans!=-1 ) return i;
        }
        return -1;
    }
};
*/