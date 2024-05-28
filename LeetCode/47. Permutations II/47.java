import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], results);
        return results;
    }

    private void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> results) {
        if (current.size() == nums.length) {
            results.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            current.add(nums[i]);
            backtrack(nums, current, used, results);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
/*
 class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int index = 0;
        List<List<Integer>> res = new ArrayList<>();

        while (index<nums.length){

            Set<List<Integer>> temp = new HashSet<>(res);
            res.add(Arrays.asList(nums[index]));

            for (List i: temp){
                for (int k = 0; k<=i.size(); k++){
                    List<Integer>changed = new ArrayList<>(i);
                    changed.add(k, nums[index]);
                    res.add(changed);
                }
            }
            index++;

        }

        return res.stream().filter(n->n.size()==nums.length).distinct().toList();
    }
}
 */
