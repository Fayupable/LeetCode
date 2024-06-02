class Solution {
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1; // Initialize two pointers, i at the start of the array and j at the end of the array
        char temp; // Declare a temporary variable to hold a character during the swap
        while (i < j) { // While i is less than j
            temp = s[i]; // Store the character at index i in temp
            s[i] = s[j]; // Replace the character at index i with the character at index j
            s[j] = temp; // Replace the character at index j with the character stored in temp
            i++; // Increment i
            j--; // Decrement j
        }
        
    }
}

/*
 class Solution {
    public void reverseString(char[] s) {
        StringBuilder st=new StringBuilder();
        for(int i=s.length-1;i>=0;i--){
            st.append(s[i]);
        }
        for(int i=0;i<s.length;i++){
            s[i]=st.charAt(i);
        }
        
        
    }
}
 */