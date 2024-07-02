import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Use a map to count occurrences of each element in nums1
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // Create a list to hold the intersection
        List<Integer> intersection = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                intersection.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        
        // Convert the list to an array
        int[] result = new int[intersection.size()];
        int i = 0;
        for (int num : intersection) {
            result[i++] = num;
        }
        
        return result;
    }
}

/*
 class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
          int[] arr = new int[1001];
        int[] result = new int[1001];

        for (int num : nums1) {
            arr[num]++;
        }

        int ctr = 0;
        for (int num : nums2) {
            if (arr[num] > 0) {
                result[ctr++] = num;
                arr[num]--;
            }
        }

        return Arrays.copyOfRange(result, 0, ctr);
    }
}
 */