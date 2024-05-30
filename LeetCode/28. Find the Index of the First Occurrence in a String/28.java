class Solution {
    public int strStr(String haystack, String needle) {
        // Use the indexOf method of the String class to find the first occurrence of needle in haystack
        // If needle is found, this method returns the index of the first character of the first occurrence of needle
        // If needle is not found, it returns -1
        return haystack.indexOf(needle);
    }
}