class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        if (n2 > n1) return false;

        int j = 0; 

        for (int i = 0; i < n1 && j < n2; i++) {
            if (str1.charAt(i) == str2.charAt(j) || 
                (str1.charAt(i) - 'a' + 1) % 26 + 'a' == str2.charAt(j)) {
                j++;
            }
        }

        return j == n2;
    }
}