#include <vector>
#include <algorithm>
#include <climits>

class Solution {
public:
    long long maximumValueSum(std::vector<int>& nums, int k, std::vector<std::vector<int>>& edges) {
        // Step 1: Calculate the initial sum of the nums array
        long long total = 0;
        for (int num : nums) {
            total += num;
        }
        
        // Initialize variables to keep track of the total positive difference
        long long total_diff = 0;
        int positive_count = 0;
        long long min_abs_diff = LLONG_MAX;
        
        // Step 2: Iterate over the nums array to calculate differences
        for (int num : nums) {
            long long diff = (long long)(num ^ k) - num;
            
            if (diff > 0) {
                total_diff += diff;
                positive_count += 1;
            }
            min_abs_diff = std::min(min_abs_diff, std::abs(diff));
        }
        
        // Step 3: Adjust the total difference if the count of positive differences is odd
        if (positive_count % 2 == 1) {
            total_diff -= min_abs_diff;
        }
        
        // Step 4: Calculate the maximum possible sum
        return total + total_diff;
    }
};