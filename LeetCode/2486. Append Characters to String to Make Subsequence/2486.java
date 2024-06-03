class Solution {
    public int appendCharacters(String s, String t) {
        int indexT = 0; // Initialize a pointer for t
        for (char c : s.toCharArray()) { // Iterate over the characters in s
            if (indexT < t.length() && c == t.charAt(indexT)) { // If the current character in s is the same as the current character in t
                indexT++; // Increment the pointer for t
            }
        }
        return t.length() - indexT; // Return the number of characters that need to be appended to s
    }
}
//other people's solution

/*
 class Solution {
    public int appendCharacters(String s, String t) {
        if(s.equals(t))
            return 0;
        char chS[] = s.toCharArray();
        char chT[] = t.toCharArray();

        int i = 0, j = 0;
        int m = chS.length, n = chT.length;
        for(; i < m; i++)
        {
            if(chS[i] == chT[j])
                j++;
            
            if(j == n)
                return 0;
        }
        return n - j;
        
    }
}
 */
/*
 class Solution {
    public int appendCharacters(String s, String t) {
        char chS[] = s.toCharArray();
        char chT[] = t.toCharArray();

        int i = 0, j = 0;
        int m = chS.length, n = chT.length;
        for(; i < m; i++)
        {
            if(chS[i] == chT[j])
                j++;
            
            if(j == n)
                break;
        }
        return n - j;
        
    }
}
 */
/*
 class Solution {
    public int appendCharacters(String s, String t) {
        int result = 0, cur1 = 0, cur2 = 0, end1 = s.length() - 1, end2 = t.length() - 1;
        while (cur1 <= end1 && cur2 <= end2) {
            if (s.charAt(cur1) == t.charAt(cur2)) {
                cur1++;
                cur2++;
            } else {
                cur1++;
            }
        }
        if (cur1 > end1) {
            result = end2 - cur2 + 1;
        }
        return result;
    }
}
 */