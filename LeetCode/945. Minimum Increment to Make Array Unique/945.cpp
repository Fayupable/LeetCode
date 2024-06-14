#include <vector>
#include <algorithm>
#include <iostream>
#include <climits>

class Solution {
public:
    int minIncrementForUnique(std::vector<int>& nums) {
        if (nums.empty()) return 0;
        
        blockSort(nums);
        int moves = 0;
        for (size_t i = 1; i < nums.size(); ++i) {
            if (nums[i] <= nums[i - 1]) {
                moves += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }
        return moves;
    }

private:
    void blockSort(std::vector<int>& nums) {
        // Find the maximum value in the array
        int max_val = *std::max_element(nums.begin(), nums.end());
        
        // Create a counting array and count occurrences of each number
        std::vector<int> count(max_val + 1, 0);
        for (int num : nums) {
            count[num]++;
        }
        
        // Reconstruct the sorted array based on the counting array
        int index = 0;
        for (int num = 0; num <= max_val; ++num) {
            while (count[num] > 0) {
                nums[index++] = num;
                count[num]--;
            }
        }
    }
};

int main() {
    Solution solution;
    std::vector<int> nums1 = {1, 2, 2};
    std::vector<int> nums2 = {3, 2, 1, 2, 1, 7};

    std::cout << solution.minIncrementForUnique(nums1) << std::endl; // Output: 1
    std::cout << solution.minIncrementForUnique(nums2) << std::endl; // Output: 6

    return 0;
}