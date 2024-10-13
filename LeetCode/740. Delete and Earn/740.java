
public class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> sums = new HashMap<>();
        int maxNum = 0;

        for (int num : nums) {
            sums.put(num, sums.getOrDefault(num, 0) + num);
            maxNum = Math.max(maxNum, num);
        }

        Map<Integer, Integer> memo = new HashMap<>();
        return dfs(maxNum, sums, memo);
    }

    private int dfs(int num, Map<Integer, Integer> sums, Map<Integer, Integer> memo) {
        if (num <= 0) return 0;

        if (memo.containsKey(num)) {
            return memo.get(num);
        }

        int skip = dfs(num - 1, sums, memo);

        int take = sums.getOrDefault(num, 0) + (num - 1 >= 0 ? dfs(num - 2, sums, memo) : 0);

        int result = Math.max(skip, take);

        memo.put(num, result);

        return result;
    }
}