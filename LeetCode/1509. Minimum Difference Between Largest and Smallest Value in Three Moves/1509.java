class Solution {
    public int minDifference(int[] nums) {
         // 74 82 29 1 38 23 19 22 48 59 62 
        //  1 19 22 23 29 38 48 59 62 74 82

        if(nums.length<=4){
            return 0;
        }

        // Arrays.sort(nums);

        for(int i=0; i<4 ;i++){
            if(i>nums.length/2){
                break;
            }
            find_min_move_to_start(nums,i);
            find_max_move_to_end(nums,i);
        }

        int i=0;
        int j= nums.length-1;

        int last_3 = nums[j-3] - nums[i];
        int diff1 = nums[j-2] - nums[i+1];
        int diff2 = nums[j-1] - nums[i+2];
        int first_3 = nums[j] - nums[i+3];   // 0 1 5 10 14
         
        int ans = Math.min(Math.min(last_3, diff1), Math.min(diff2, first_3));

        return ans;
    }

    public void find_min_move_to_start(int[] nums, int idx){

        int min_idx= idx;

        for(int i=idx; i<nums.length-idx; i++){
            if(nums[min_idx]> nums[i]){
                min_idx = i;
            }
        }

        int temp1 = nums[idx];
        nums[idx] = nums[min_idx];
        nums[min_idx] = temp1;
    }
    
    public void find_max_move_to_end(int[] nums, int idx){

        int max_idx= idx;
        for(int i=idx; i<nums.length-idx; i++){
            if(nums[max_idx] < nums[i]){
                max_idx = i;
            }
        }

        int temp2 = nums[nums.length-1-idx];
        nums[nums.length-1-idx] = nums[max_idx];
        nums[max_idx] = temp2;
    }

}