class Solution {
    // Define a class named Solution

    public int longestPalindrome(String s) {
        // Define a method named longestPalindrome that takes a string s as input

        int[] freq = new int[128];
        // Initialize an array freq of size 128 to store the frequency of each ASCII character in s

        for (char c : s.toCharArray()) {
            freq[c]++;
        }
        // Iterate over each character c in s, incrementing its count in the freq array

        int ans = 0;
        // Initialize a variable ans to 0. This variable will store the length of the longest palindrome that can be built with the characters of s

        for (int f : freq) {
            ans += f / 2 * 2;
        }
        // For each value f in the freq array, add the largest even number less than or equal to f to ans

        return ans < s.length() ? ans + 1 : ans;
        // If ans is less than the length of s, return ans + 1. This accounts for the fact that a palindrome can have one character that appears an odd number of times in the middle. Otherwise, return ans.
    }
}

/*
 class Solution {
    public int longestPalindrome(String s) {
        int[] arr= new int[100];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'A']++;
        }
        int ans=0;
        for(int i=0;i<100;i++){
            if(arr[i]%2==1){
                ans+=(arr[i]-1);
            }else{
                ans+=arr[i];
            }
        }
        if(ans<s.length()){
            return ans+1;
        }
        return ans;
    }
}
 */

 /*
  class Solution {
    public int longestPalindrome(String s) {
        int [] count = new int[128];
        for(char c:s.toCharArray()){
            count[c]++;
        }
        int ans=0;
        for(int f:count){
            ans+= f%2==0 ? f : f-1;
        }

        boolean odd = Arrays.stream(count).anyMatch(f -> f%2 ==1);
        return ans+(odd ? 1 : 0);
    }
}
  */
  /*
   class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> lower = new HashMap<>();
        int sum = 0;
        boolean flag = false;

        for (char c : s.toCharArray()) {
            lower.put(c, lower.getOrDefault(c, 0) + 1);
        }

        for (Character c : lower.keySet()){
            if (lower.get(c) % 2 == 0){
                sum += lower.get(c);
            } else {
                sum += lower.get(c) - 1;
                flag = true;
            }
        }

    


        return sum + (flag ? 1 : 0);







    }
}
   */
  /*
   class Solution {
    public int longestPalindrome(String s) {
        int oddCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.get(ch) % 2 == 1)
                oddCount++;
            else
                oddCount--;
        }
        if (oddCount > 1)
            return s.length() - oddCount + 1;
        return s.length();
    }
}
   */