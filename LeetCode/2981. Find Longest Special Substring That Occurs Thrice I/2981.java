class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        int result = -1;

        for (int len = 1; len <= n; len++) {
            Map<String, Integer> countMap = new HashMap<>();
            for (int i = 0; i <= n - len; i++) {
                String sub = s.substring(i, i + len);
                if (isSpecial(sub)) {
                    countMap.put(sub, countMap.getOrDefault(sub, 0) + 1);
                    if (countMap.get(sub) >= 3) {
                        result = Math.max(result, len);
                    }
                }
            }
        }

        return result;
    }

    private boolean isSpecial(String str) {
        char firstChar = str.charAt(0);
        for (char c : str.toCharArray()) {
            if (c != firstChar) return false;
        }
        return true;
    }
}