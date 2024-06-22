#include <vector>
#include <unordered_map>
#include <iostream>

using namespace std;

class Solution {
public:
    int numberOfSubarrays(vector<int>& nums, int k) {
        // Unordered map to store the count of prefix sums
        unordered_map<int, int> count;
        count[0] = 1; // Initial condition to handle the case when prefixSum == k
        int prefixSum = 0, result = 0;

        for (int num : nums) {
            // Increment prefixSum by 1 if the current number is odd
            prefixSum += num % 2;
            
            // Check if there exists a prefix sum that would make the subarray have exactly k odd numbers
            if (count.find(prefixSum - k) != count.end()) {
                result += count[prefixSum - k];
            }
            
            // Update the count of the current prefixSum
            count[prefixSum]++;
        }

        return result; // Return the total number of nice subarrays
    }
};

int main() {
    Solution solution;
    vector<int> nums = {1, 1, 2, 1, 1};
    int k = 3;
    cout << solution.numberOfSubarrays(nums, k) << endl; // Expected output: 2
    return 0;
}


//Other people's solution
/*
class Solution {
public:
    int f(vector<int>& nums, int k) {
        if(k<0) return 0;
        int n= nums.size();
        int l= 0;
        int r= 0;
        int sum= 0;
        int cnt= 0;
        while(r<n) {
            sum= sum+(nums[r]%2);
            while(sum>k) {
                sum= sum-(nums[l]%2);
                l++;
            }
            cnt= cnt+(r-l+1);
            r++;
        }
        return cnt;
    }
    int numberOfSubarrays(vector<int>& nums, int k) {
        ios_base::sync_with_stdio(false);
        cin.tie(nullptr);
        return (f(nums, k) - f(nums, k-1));
    }
};
*/
/*
class Solution {
public:
    int find(vector<int>& nums, int k){
        int i=0, j=0, ans=0, c=0;
        while(j < nums.size()){
            if(nums[j]%2) c++;

            while(c > k && i<=j){
                if(nums[i]%2) c--;
                i++;
            }
            ans += j-i+1;
            j++;
        }
        return ans;
    }
    int numberOfSubarrays(vector<int>& nums, int k) {
        cin.tie(NULL);
        ios_base::sync_with_stdio(false);
        return find(nums,k)-find(nums,k-1);
    }
};
*/
/*
class Solution {
public:
    Solution() {
        cin.tie(NULL);
        cout.tie(NULL);
        ios_base :: sync_with_stdio(false);
    } 
    int numberOfSubarrays(vector<int>& nums, int k) {
        // Slidin Windows
        deque<int> Q = {-1};
        int n = nums.size(), ans = 0;
        for(int i = 0 ; i < n; i++){
            if ( nums[i] % 2 ){
                Q.push_back(i);
            }
            if (Q.size() > k+1){
                Q.pop_front();
            }
            if (Q.size() == k+1){
                ans += (Q[1]-Q[0]);
            }
        }
        return ans;
    }
};
*/
/*
class Solution {
public:
#define fast ios::sync_with_stdio(0), cin.tie(0), cout.tie(0)

    int func(vector<int>& nums, const int& k) {
        int ans = 0;
        int l = 0;
        int odd = 0;
        int n = nums.size();
        for (int r = 0; r < n; r++) {
            if (nums[r] % 2)
                ++odd;
            while (odd > k) {
                if (nums[l] % 2)
                    odd--;
                l++;
            }
            if (odd <= k)
                ans += (r - l + 1);
        }
        return ans;
    }

    int numberOfSubarrays(vector<int>& nums, int k) {
        fast;
        return func(nums, k) - func(nums, k - 1);
    }
};
*/