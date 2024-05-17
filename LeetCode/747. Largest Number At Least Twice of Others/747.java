class Solution {
    public int dominantIndex(int[] nums) {
        int max_index=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>nums[max_index]){
                max_index=i;
            }
            
        }
        for(int i=0; i<nums.length; i++){
            if(max_index!=i && nums[max_index]<2*nums[i]){
                return -1;
            }
        }
        return max_index;
        
    }
}