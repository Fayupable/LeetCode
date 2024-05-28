class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums); 
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 3; i++) {
          
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            for (int j = i + 1; j < nums.length - 2; j++) {
          
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                
                int left = j + 1;
                int right = nums.length - 1;
                
                while (left < right) {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right]; 
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        

                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        
        return result;
    }
}


/*
 * 
 * time limit exceeded solve 
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> resultSet = new HashSet<>();
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                int sum = nums[i] + nums[j];
                if (!map.containsKey(sum)) {
                    map.put(sum, new ArrayList<>());
                }
                map.get(sum).add(new int[]{i, j});
            }
        }

        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                int sum = nums[i] + nums[j];
                int complement = target - sum;
                
                
                if (map.containsKey(complement)) {
                    for (int[] pair : map.get(complement)) {
                        if (pair[0] > j) { 
                            List<Integer> quad = Arrays.asList(nums[i], nums[j], nums[pair[0]], nums[pair[1]]);
                            resultSet.add(quad);
                        }
                    }
                }
            }
        }
        
        return new ArrayList<>(resultSet);
    }
}
 */