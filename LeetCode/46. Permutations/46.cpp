#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> result; // to store all permutations
        backtrack(nums, result, 0); // start backtracking
        return result; // return all permutations
    }
    
private:
    void backtrack(vector<int>& nums, vector<vector<int>>& result, int start) {
        if (start == nums.size()) { // if the start index has reached the end of the array
            result.push_back(nums); // add the permutation to the result
            return;
        }
        for (int i = start; i < nums.size(); i++) { // for each number
            swap(nums[start], nums[i]); // swap it with the first number
            backtrack(nums, result, start + 1); // generate all permutations of the remaining numbers
            swap(nums[start], nums[i]); // swap back to restore the original array before the next swap
        }
    }
};

// Time Complexity: O(N!)


//Time Complexity: O(N! * N)
/*
class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
       vector<vector<int>>result;
       int n=nums.size();
       if(n==1){
        result.push_back(nums);
        return result;
       }
       sort(nums.begin(),nums.end());
      do{
        result.push_back(nums);
      }
      while(next_permutation(nums.begin(),nums.end()));
      return result;
    }

};
*/