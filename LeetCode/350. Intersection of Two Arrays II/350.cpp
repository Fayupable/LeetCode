#include <vector>
#include <unordered_map>

class Solution {
public:
    std::vector<int> intersect(std::vector<int>& nums1, std::vector<int>& nums2) {
        std::unordered_map<int, int> count;
        // Count occurrences of each number in nums1
        for (int num : nums1) {
            ++count[num];
        }
        
        std::vector<int> result;
        // Find intersections
        for (int num : nums2) {
            if (count[num] > 0) {
                result.push_back(num);
                --count[num];
            }
        }
        
        return result;
    }
};


/*
#include <vector>
#include <algorithm>

class Solution {
public:
    std::vector<int> intersect(std::vector<int>& nums1, std::vector<int>& nums2) {
        std::vector<int> ans;
        std::sort(nums1.begin(), nums1.end());
        std::sort(nums2.begin(), nums2.end());
        int i = 0, j = 0;
        while (i < nums1.size() && j < nums2.size()) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else { // nums1[i] == nums2[j]
                ans.push_back(nums1[i]);
                i++;
                j++;
            }
        }
        return ans;
    }
};
*/
/*
class Solution {
 public:
  vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
    if (nums1.size() > nums2.size())
      return intersect(nums2, nums1);

    vector<int> ans;
    unordered_map<int, int> count;

    for (const int num : nums1)
      ++count[num];

    for (const int num : nums2)
      if (const auto it = count.find(num);
          it != count.cend() && it->second-- > 0)
        ans.push_back(num);

    return ans;
  }
};
*/