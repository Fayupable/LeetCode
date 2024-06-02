class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) { // If s is empty, it is a subsequence of any string, so return true
            return true;
        }
        int indexS = 0, indexT = 0; // Initialize two pointers, one for s and one for t
        while (indexT < t.length()) { // Iterate over the characters in t
            if (t.charAt(indexT) == s.charAt(indexS)) { // If the current character in t is the same as the current character in s
                indexS++; // Increment the pointer for s
                if (indexS == s.length()) { // If the pointer for s has reached the end of s, return true
                    return true;
                }
            }
            indexT++; // Increment the pointer for t
        }
        return false; // If the loop finishes and the pointer for s has not reached the end of s, return false
    }
}
/*
 class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();

        if (n>m) return false;

        char ch;
        int j = 0;
        for (int i=0; i<n; i++) {
            ch = s.charAt(i);
            while(j<m && ch != t.charAt(j)) j++;
            if (j>=m) return false;
            j++;
        }
        return true;


    }
}
 */


// class Solution {
//     public boolean isSubsequence(String s, String t) {
//         /* Two pointers:
//             1. index of first string
//             2. index of second string

//             Linear scan over the second string
//             Increment index of first string
//             etc.
//         */

//         // Empty string
//         if (s.length() == 0) {
//             return true;
//         }

//         int i = 0;
//         for (int j = 0; j < t.length(); j++) {
//             if (t.charAt(j) == s.charAt(i)) {
//                 i++;
//             }
//             if (i >= s.length()) {
//                 return true;
//             }
//         }

//         return false;
//     }
// }