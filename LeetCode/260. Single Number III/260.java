class Solution {
    public int[] singleNumber(int[] nums) {
        // Step 1: XOR all the elements
        int xor_all = 0;
        for (int num : nums) {
            xor_all ^= num;
        }

        // Step 2: Find the rightmost set bit in xor_all
        int rightmost_set_bit = xor_all & -xor_all;

        // Step 3: Partition the numbers into two groups and XOR each group
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & rightmost_set_bit) != 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        return new int[]{num1, num2};
    }
}
//other people's solution
/*

 class Solution {
    public int[] singleNumber(int[] nums) {
        final int xors = Arrays.stream(nums).reduce((a, b) -> a ^ b).getAsInt();
        final int lowbit = xors & -xors;
        int[] ans = new int[2];

        for (final int num : nums)
        if ((num & lowbit) > 0)
            ans[0] ^= num;
        else
            ans[1] ^= num;

        return ans;
    }
}
 */
/*
 class Solution {
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans[]=new int[2];
        int k=0;
        if(nums.length ==2)   return nums;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                i++;
            }else{
                ans[k++]=nums[i];
            }
        }
        if(nums[nums.length-1] != nums[nums.length-2]){
            ans[k]=nums[nums.length-1];
        }
        return ans;
    }
}
 */
/*
 class Solution {
    public int[] singleNumber(int[] n) {

        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();

        for (int i = 0; i < n.length; i++) {
            if (set.contains(n[i])) {
                res.remove(n[i]);
            } else {
                set.add(n[i]);
                res.add(n[i]);
            }
        }
        int[] arr = new int[res.size()];
        Iterator<Integer> it = res.iterator();
        int i = 0;
        while (it.hasNext()) {
            arr[i++] = it.next();
        }
        return arr;
    }
}
 */
/*
 class Solution {
    public int[] singleNumber(int[] nums) {
         return Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(t -> t.getValue() ==1)
                .map(Map.Entry<Integer, Long>::getKey)
                .collect(Collectors.toList())
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
 */
/*
 class Solution {
    public int[] singleNumber(int[] nums) {
        boolean single = false;
        int counter = 0;
        int[] arr = new int[2];
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(i != j && nums[i] == nums[j]) {
                    single = false;
                    break;
                } else {
                    single = true;
                }
            }
            if(single) {
                arr[counter] = nums[i];
                System.out.println(arr[counter]);
                counter++;
                if(counter == 2) {
                    break;
                }
            }
        }
        return arr;
    }
}
 */

 /*
  class Solution {
    public int[] singleNumber(int[] nums) {

        Arrays.sort(nums);
        int arr[] = new int[2];
        int num1 = 0;
        int num2 = 0;
        for(int i=0; i<nums.length; i++)
        {
            boolean res = false;
            for(int j=0; j<nums.length; j++)
            {
                if(i==j)continue;
                if(nums[i] == nums[j])
                {
                   res = true;
                   break;
                }
            }
            if(res==false)
            {
                if(num1 == 0)
                {
                    num1 = nums[i];
                }
                else
                {
                    num2 = nums[i];
                }

            }
            if(num1!=0 && num2!=0)
                break;
        }
        arr[0] = num1;
        arr[1] = num2;

        return arr;
    }
}
  */
  /*
   class Solution {
    public int[] singleNumber(int[] nums) 
    {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int l = nums.length;
        for(int i = 0;i < l;i++)
        {
            boolean flag = true;
            inner:
            for(int j = 0;j < l;j++)
            {
                if(nums[i] == nums[j] && i != j)
                {
                    flag = false;
                    break inner;
                }
            }
            if(flag)
            {
                arr.add(nums[i]);
            }
        }
        int[] a = new int[arr.size()];
        int s = arr.size();
        for(int i = 0;i < s;i++)
        {
            a[i] = arr.get(i);
        }
        return a;
    }
}
   */