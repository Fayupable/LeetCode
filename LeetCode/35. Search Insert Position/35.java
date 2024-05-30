class Solution {
    public int searchInsert(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                return mid; //target not found at index mid
            }else if(nums[mid]<target){
                //target must be in the right half
                low=mid+1;
            }else{
                //target must be in the left half
                high=mid-1;
            }
        }
        return low;
        
    }
}