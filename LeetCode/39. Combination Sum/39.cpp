class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> result;
        vector<int> combination;
        sort(candidates.begin(), candidates.end());
        combinationSum(candidates, target, result, combination, 0);
        return result;
    }
    
private:
    void combinationSum(vector<int>& candidates, int target, vector<vector<int>>& result, vector<int>& combination, int begin) {
        if(!target) {
            result.push_back(combination);
            return;
        }
        for(int i = begin; i != candidates.size() && target >= candidates[i]; ++i) {
            combination.push_back(candidates[i]);
            combinationSum(candidates, target - candidates[i], result, combination, i);
            combination.pop_back();
        }
    }
};

/*
class Solution {

private:
    void SubsetRec(int i, int target, int n, vector<int>& temp,
                   vector<int>& can, vector<vector<int>>& res) {
        if (i == n) {
            if (target == 0)
                res.push_back(temp);
            return;
        }

        // picking element
        if (can[i] <= target) {
            temp.push_back(can[i]);
            SubsetRec(i, target - can[i], n, temp, can, res);
            temp.pop_back();
        }

        // not picking element

        SubsetRec(i + 1, target, n, temp, can, res);
    }

public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        int n = candidates.size();
        vector<vector<int>> res;
        vector<int> temp;
        SubsetRec(0, target, n, temp, candidates, res);
        return res;
    }
};
*/