class Solution {
    public String toLowerCase(String s) {
        char[] arr = s.toCharArray(); // Convert the string to a character array
        for (int i = 0; i < arr.length; i++) { // Iterate over the characters in the array
            if (arr[i] >= 'A' && arr[i] <= 'Z') { // If the current character is an uppercase letter
                arr[i] = (char) (arr[i] + 32); // Convert it to lowercase by adding 32 to its ASCII value
            }
        }
        return new String(arr); // Convert the character array back to a string and return it
    }
}

/*
 class Solution {
    public String toLowerCase(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                res.append((char)(s.charAt(i) + 32));
            } else {
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }
}
 */
/*
 class Solution {
    public String toLowerCase(String s) {

       char[] a = s.toCharArray();

        
        IntStream.range(0,a.length).filter(i -> a[i] >= 'A' && a[i] <= 'Z')
                .forEach(i -> a[i] = (char)(a[i] - 'A' + 'a'));

        return new String(a);
        
    }
}
 */
/*
 class Solution {
    public String toLowerCase(String s) {
       String finalString ="";
        for(int i=0;i<s.length();i++){
            int asciVal = s.charAt(i);
            if(asciVal < 91 && asciVal > 64){
                finalString += Character.toString((char) (asciVal + 32));
            }
            else{
                finalString += Character.toString(s.charAt(i));
            }
        }
        return finalString;
    }
}
 */