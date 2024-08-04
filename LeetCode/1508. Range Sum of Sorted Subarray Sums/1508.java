import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> subarraySums = new ArrayList<>();
        final int MOD = 1000000007;

        // Generate all subarray sums
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += nums[j];
                subarraySums.add(currentSum);
            }
        }

        // Sort the list of subarray sums
        Collections.sort(subarraySums);

        // Calculate the sum from index left to right (1-based index)
        long result = 0;
        for (int i = left - 1; i < right; i++) {
            result = (result + subarraySums.get(i)) % MOD;
        }

        return (int) result;
    }
}

/*
 * import java.util.AbstractMap;
 * import java.util.Map;
 * 
 * class Solution {
 * long largestSubArraySumPossible = 0, smallestSubArraySumPossible = 0;
 * 
 * public Map.Entry<Integer, Long> subArraysWithSumLessThanOrEqualTo(int[] nums,
 * long target){
 * 
 * int countOfSuchSubArrays = 0;
 * long totalSum = 0;
 * long windowSum = 0;
 * long currSum = 0;
 * int n = nums.length;
 * 
 * for (int left = 0, right = 0; right < n; ++right) {
 * currSum += (long) nums[right] * (right - left + 1);
 * windowSum += nums[right];
 * while (windowSum > target) {
 * currSum -= windowSum;
 * windowSum -= nums[left++];
 * }
 * countOfSuchSubArrays += right - left + 1;
 * totalSum += currSum;
 * }
 * return new AbstractMap.SimpleEntry<>(Integer.valueOf(countOfSuchSubArrays),
 * Long.valueOf(totalSum));
 * }
 * 
 * public long firstKSubarraysSum(int[] nums, int k){
 * long start = smallestSubArraySumPossible, end = largestSubArraySumPossible;
 * while (start < end) {
 * long mid = start + (end - start) / 2;
 * if (subArraysWithSumLessThanOrEqualTo(nums, mid).getKey() < k) {
 * start = mid + 1;
 * } else {
 * end = mid;
 * }
 * }
 * Map.Entry<Integer, Long> map = subArraysWithSumLessThanOrEqualTo(nums,
 * start);
 * long totalOfFirstKSubarraysSum = map.getValue();
 * int countOfSuchSubArrs = map.getKey();
 * return totalOfFirstKSubarraysSum - start * (countOfSuchSubArrs - k);
 * }
 * 
 * public int rangeSum(int[] nums, int n, int left, int right) {
 * int mod = (int) 1e9 + 7;
 * long ans = 0;
 * smallestSubArraySumPossible = nums[0];
 * 
 * for (int i = 0; i < n; i++) {
 * largestSubArraySumPossible += nums[i];
 * smallestSubArraySumPossible = Math.min(smallestSubArraySumPossible, nums[i]);
 * }
 * 
 * ans = firstKSubarraysSum(nums, right) % mod;
 * ans -= firstKSubarraysSum(nums, left - 1) % mod;
 * 
 * return (int) (ans % mod);
 * }
 * }
 */