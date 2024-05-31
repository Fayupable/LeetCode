class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        // Initialize xor_all to 0. This variable will keep track of the XOR of all numbers in the array.
        int xor_all = 0;
        // Iterate over all numbers in the array
        for (int num : nums) {
            // Update xor_all with the XOR of xor_all and the current number
            xor_all ^= num;
        }

        // Find the rightmost set bit of xor_all. This bit is set in one of the two numbers that appear only once in the array.
        // Use unsigned int to avoid overflow issues
        unsigned int rightmost_set_bit = xor_all & static_cast<unsigned int>(-(long long)xor_all);

        // Initialize num1 and num2 to 0. These variables will keep track of the two numbers that appear only once in the array.
        int num1 = 0, num2 = 0;
        // Iterate over all numbers in the array
        for (int num : nums) {
            // If the rightmost set bit of the current number is set
            if (num & rightmost_set_bit) {
                // Update num1 with the XOR of num1 and the current number
                num1 ^= num;
            } else {
                // Update num2 with the XOR of num2 and the current number
                num2 ^= num;
            }
        }

        // Return num1 and num2, which are the two numbers that appear only once in the array
        return {num1, num2};
    }
};

//Other people's solution
/*
class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        long temp=0;
        for(int i=0;i<nums.size();i++){
            temp^=nums[i];
        } 
        int res=(temp & temp-1)^temp;
        int first=0;
        int second=0;
        for(int i=0;i<nums.size();i++){
            if(res&nums[i]){
                first^=nums[i];
            }else{
                second^=nums[i];
            }
        }
        return {first,second};
    }
};
*/
/*
class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
       vector<int> ans;
       long long xorr = 0;
       int n = nums.size();
       for(int i=0;i<n;i++){
        xorr = xorr^nums[i];
       } 
       long rightmost = (xorr & (xorr-1))^xorr;
       int b1 =0;
       int b2 =0;
       for(int i=0;i<n;i++){
        if(nums[i] & rightmost){
            b1 = b1^nums[i];
        }
        else{
            b2 = b2^nums[i];
        }
       }
       return {b1 , b2};
    }
};
*/
/*
class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        // vector<int>ans;
        // map<int,int>mp;
        // for(auto i :nums){
        //     mp[i]++;
        // }
        // for(auto it : mp){
        //     if(it.second==1){
        //         ans.push_back( it.first);
        //     }
        // }
        // return ans;
        long long xorResult=0;
        for(int i=0;i<nums.size();i++){
            xorResult=nums[i]^xorResult;
        }
        //check the right most set bit
        long long rightmost=(xorResult^(xorResult-1))&xorResult;

        int b1=0;
        int b2=0;

        for(int i=0;i<nums.size();i++){
             if(nums[i]&rightmost){
                b1^=nums[i];
             }
             else{
                b2^=nums[i];
             }
        }
        return {b1,b2};
    }
};
*/
/*
class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        int ans=0;
        int rsbm;
        for(auto x:nums){
            ans=ans^x;
        }
          if (ans != INT_MIN) { // Check if ans is not INT_MIN to avoid overflow
             rsbm = ans & -ans; // Find the rightmost set bit
        }
        int x1=0;
        int y=0;

        for(auto x:nums){
            if((rsbm & x)==0){
             x1=x1^x;
            }
            else{
            y=y^x;
            }
        }
        return{x1,y};
        
    }
};
*/