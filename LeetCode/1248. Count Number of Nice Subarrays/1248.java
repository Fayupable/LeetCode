import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // Map to store the count of prefix sums
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1); // Initial condition to handle the case when prefixSum == k
        int prefixSum = 0, result = 0;

        for (int num : nums) {
            // Increment prefixSum by 1 if the current number is odd
            prefixSum += num % 2;
            
            // Check if there exists a prefix sum that would make the subarray have exactly k odd numbers
            if (count.containsKey(prefixSum - k)) {
                result += count.get(prefixSum - k);
            }
            
            // Update the count of the current prefixSum
            count.put(prefixSum, count.getOrDefault(prefixSum, 0) + 1);
        }

        return result; // Return the total number of nice subarrays
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        System.out.println(solution.numberOfSubarrays(nums, k)); // Expected output: 2
    }
}
//other people's solution
/*
 class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        cnt[0] = 1;
        int ans = 0, t = 0;
        for (int v : nums) {
            t += v & 1;
            if (t - k >= 0) {
                ans += cnt[t - k];
            }
            cnt[t]++;
        }
        return ans;
    }
}
 */
/*
 class Solution {
    public static int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int oddCount = 0;
        int[] prefixCounts = new int[nums.length + 1];
        prefixCounts[0] = 1; // Initialize the prefix count for zero odd numbers.

        for (int num : nums) {
            if (num % 2 != 0) {
                oddCount++;
            }
            if (oddCount >= k) {
                count += prefixCounts[oddCount - k];
            }
            prefixCounts[oddCount]++;
        }

        return count;
    }
}
 */
/*
 class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // brute force approach
        // generate all subarrays

        return helper(nums, k) - helper(nums, k - 1);
    }

    private int helper(int[] arr, int k){
        if(k < 0){
            return 0;
        }

        int count = 0;
        int cnt = 0;
        int l = 0;
        int r = 0;

        while(r < arr.length){
            if((arr[r] & 1) == 1){
                cnt++;
            }

            while(cnt > k){
                if((arr[l] & 1) == 1){
                    cnt--;
                }
                l++;
            }

            if(cnt <= k){
                count += (r - l + 1);
            }
            r++;
        }
        return count;
    }
}
 */
/*
 class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        if (k< 0) {
            return 0;
        }

        int res = count(nums, k) - count(nums, k - 1);
        return res;
    }

    public static int count(int[] nums, int k) {
    int l = 0;
    int r = 0;
    int count = 0;
    int sum = 0;

    while (r < nums.length) {
        sum += (nums[r]%2);

        while (sum > k && l <= r) {
            sum -= (nums[l]%2);
            l++;
        }

        count += (r - l + 1);
        r++;
    }

    return count;
    }
}
 */
/*
 class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> even = new ArrayList<>();
        int temp = 0, ans = 0; 
        for(int num : nums) {
            if(num % 2 == 0)
                temp++;
            else {
                even.add(temp);
                temp = 0; 
            }
        }
        // 1 1 2 1 1  num = 1 even=[0, 0, 1, 0, 0 ] 
        even.add(temp); 
        int m = even.size();
        //i=0 to i<5-3 =2 
        for(int i = 0; i < m - k; i++) {
            //i=0 ans=ans+(0+1)*(0+1) =0+1=1
            //i=1 ans= 1+(0+1)*(0+1)=2
            
            ans += (even.get(i) + 1) * (even.get(i + k) + 1);
        }
        return ans;
    }
}
 */