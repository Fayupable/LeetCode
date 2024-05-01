class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index == -1)
            return word;
        
        // Reverse substring from index 0 to the index of first occurrence of ch
        return reverseString(word.substring(0, index + 1)) + word.substring(index + 1);
    }
    
    private String reverseString(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
}
