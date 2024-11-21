class Solution {
    public int takeCharacters(String s, int k) {
        if (k == 0) return 0;

        int[] totalCount = new int[3];
        for (char ch : s.toCharArray()) {
            totalCount[ch - 'a']++;
        }

        for (int i = 0; i < 3; i++) {
            if (totalCount[i] < k) return -1;
        }

        int n = s.length();
        int[] count = new int[3];
        int maxValidWindow = 0;

        for (int left = 0, right = 0; right < n; right++) {
            count[s.charAt(right) - 'a']++;

            while (count[0] > totalCount[0] - k || count[1] > totalCount[1] - k || count[2] > totalCount[2] - k) {
                count[s.charAt(left) - 'a']--;
                left++;
            }

            maxValidWindow = Math.max(maxValidWindow, right - left + 1);
        }

        return n - maxValidWindow;
    }
}