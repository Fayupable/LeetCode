class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> prefix = new HashMap<>();
        
        for (int val : arr1) {
            int num = val;
            while (num > 0) {
                prefix.put(num, prefix.getOrDefault(num, 0) + 1);
                num /= 10;
            }
        }

        int mx = Integer.MIN_VALUE;


        for (int val : arr2) {
            int num = val;

            int len = (int) Math.log10(num) + 1;


            while (num > 0) {

                if (prefix.containsKey(num)) {
                    break;
                }
                num /= 10;
                len--;
            }

            mx = Math.max(mx, len);
        }

        return mx;
    }
}