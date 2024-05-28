#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<vector<int>> results;
        sort(nums.begin(), nums.end());
        vector<bool> used(nums.size(), false);
        vector<int> current;
        backtrack(nums, current, used, results);
        return results;
    }

private:
    void backtrack(vector<int>& nums, vector<int>& current, vector<bool>& used, vector<vector<int>>& results) {
        if (current.size() == nums.size()) {
            results.push_back(current);
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            used[i] = true;
            current.push_back(nums[i]);
            backtrack(nums, current, used, results);
            current.pop_back();
            used[i] = false;
        }
    }
};

/*
class Solution {
public:
    void recursion(vector<int> num, int i, int j, vector<vector<int> > &res) {
        if (i == j-1) {
            res.push_back(num);
            return;
        }
        for (int k = i; k < j; k++) {
            if (i != k && num[i] == num[k]) continue;
            swap(num[i], num[k]);
            recursion(num, i+1, j, res);
        }
    }
    vector<vector<int> > permuteUnique(vector<int> &num) {
        sort(num.begin(), num.end());
        vector<vector<int> >res;
        recursion(num, 0, num.size(), res);
        return res;
    }
};
*/