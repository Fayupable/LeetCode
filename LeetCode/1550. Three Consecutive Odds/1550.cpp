#include <vector>

class Solution {
public:
    bool threeConsecutiveOdds(std::vector<int>& arr) {
        // Ensure there are at least three elements in the array
        if (arr.size() < 3) return false;

        for (int i = 0; i < arr.size() - 2; i++) {
            if (arr[i] % 2 != 0 && arr[i + 1] % 2 != 0 && arr[i + 2] % 2 != 0) {
                return true;
            }
        }
        return false;
    }
};