class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        
        Map<Integer, Integer> m = new HashMap<>();

        for (int num : nums) m.put(num, m.getOrDefault(num, 0) + 1);

        int res = 1, prev = 0, prevPrev = 0;

        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            int cur = e.getKey();

            if (m.containsKey(cur - k)) continue;
            
            prev = 0;

            while (m.containsKey(cur)) {
                prevPrev = prev;
                prev = ((1 << m.get(cur)) - 1) * res;
                res += prevPrev;
                cur += k;
            }
            res += prev;
        }
        return res - 1;
    }
}


/*
import java.util.ArrayList;
import java.util.List;

class Solution {
    private int count;

    public int beautifulSubsets(int[] nums, int k) {
        count = 0;
        backtrack(nums, k, 0, new ArrayList<>());
        return count;
    }

    private void backtrack(int[] nums, int k, int start, List<Integer> currentSubset) {
        if (!currentSubset.isEmpty() && isBeautiful(currentSubset, k)) {
            count++;
        }

        for (int i = start; i < nums.length; i++) {
            currentSubset.add(nums[i]);
            backtrack(nums, k, i + 1, currentSubset);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    private boolean isBeautiful(List<Integer> subset, int k) {
        int size = subset.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (Math.abs(subset.get(i) - subset.get(j)) == k) {
                    return false;
                }
            }
        }
        return true;
    }
}

 
 */