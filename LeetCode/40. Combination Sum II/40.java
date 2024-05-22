import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);  // Sort the candidates array
        
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int target, int start) {
        if (target == 0) {  // Base case: if target is 0, add the current combination to the result
            result.add(new ArrayList<>(tempList));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;  // Skip duplicates
            if (candidates[i] > target) break;  // Prune the search space if the current candidate exceeds the target
            
            tempList.add(candidates[i]);
            backtrack(result, tempList, candidates, target - candidates[i], i + 1);  // Recurse with the updated target and path
            tempList.remove(tempList.size() - 1);  // Backtrack by removing the last added element
        }
    }
}
