class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        Map<Character, Integer> targetCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowCount = new HashMap<>();
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int required = targetCount.size();
        int formed = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);

            if (targetCount.containsKey(c) && windowCount.get(c).equals(targetCount.get(c))) {
                formed++;
            }

            while (left <= right && formed == required) {
                char l = s.charAt(left);
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                windowCount.put(l, windowCount.get(l) - 1);
                if (targetCount.containsKey(l) && windowCount.get(l) < targetCount.get(l)) {
                    formed--;
                }
                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}