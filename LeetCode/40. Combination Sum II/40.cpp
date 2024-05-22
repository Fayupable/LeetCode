#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<vector<int>> result;
        vector<int> combination;
        sort(candidates.begin(), candidates.end());  // Sort the candidates array
        
        backtrack(result, combination, candidates, target, 0);
        return result;
    }
    
private:
    void backtrack(vector<vector<int>>& result, vector<int>& combination, vector<int>& candidates, int target, int start) {
        if (target == 0) {  // Base case: if target is 0, add the current combination to the result
            result.push_back(combination);
            return;
        }
        
        for (int i = start; i < candidates.size(); i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;  // Skip duplicates
            if (candidates[i] > target) break;  // Prune the search space if the current candidate exceeds the target
            
            combination.push_back(candidates[i]);
            backtrack(result, combination, candidates, target - candidates[i], i + 1);  // Recurse with the updated target and path
            combination.pop_back();  // Backtrack by removing the last added element
        }
    }
};


/*
class Solution {
public:
    void f(int i, int sum, vector<int>& c, set<vector<int>> &s, int t, int n, vector<int> &curr){
        if(sum==t){
            s.insert(curr);
            return;
        }

        for(int j=i; j<n; j++){
            if(j!=i&&(c[j]==c[j-1]))continue;
            if(sum+c[j]>t)continue;
            curr.push_back(c[j]);
            f(j+1, sum+c[j], c, s, t, n, curr);
            curr.pop_back(); 
        } 
    }

    vector<vector<int>> combinationSum2(vector<int>& c, int t) {
        sort(c.begin(), c.end());
        set<vector<int>> s;
        int n = c.size();
        vector<int> curr;
        f(0, 0, c, s, t, n, curr);
        vector<vector<int>> ans(s.begin(), s.end());
        return ans;
    }
};
*/