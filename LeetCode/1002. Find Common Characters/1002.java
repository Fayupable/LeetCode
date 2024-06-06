import java.util.ArrayList;
import java.util.List;

class Solution {
    // Define a class named Solution

    public List<String> commonChars(String[] words) {
        // Define a method named commonChars that takes a string array words as input

        int[] minfreq = new int[26];
        // Initialize an array minfreq of size 26 to store the minimum frequency of each lowercase English letter in words

        for (int i = 0; i < 26; ++i) {
            minfreq[i] = Integer.MAX_VALUE;
        }
        // Set the initial minimum frequency of each letter to the maximum possible integer value

        for (String word: words) {
            // Iterate over each word in words

            int[] freq = new int[26];
            // Initialize an array freq of size 26 to store the frequency of each lowercase English letter in the current word

            int length = word.length();
            // Get the length of the current word

            for (int i = 0; i < length; ++i) {
                // Iterate over each character in the current word

                char ch = word.charAt(i);
                // Get the current character

                ++freq[ch - 'a'];
                // Increment the frequency of the current character in freq
            }

            for (int i = 0; i < 26; ++i) {
                // Iterate over each lowercase English letter

                minfreq[i] = Math.min(minfreq[i], freq[i]);
                // Update the minimum frequency of the current letter
            }
        }

        List<String> ans = new ArrayList<String>();
        // Initialize a list ans to store the answer

        for (int i = 0; i < 26; ++i) {
            // Iterate over each lowercase English letter

            for (int j = 0; j < minfreq[i]; ++j) {
                // Repeat for the minimum frequency of the current letter

                ans.add(String.valueOf((char) (i + 'a')));
                // Add the current letter to ans
            }
        }

        return ans;
        // Return the answer
    }
}


/*
 class Solution {
   public List<String> commonChars(String[] words) {
        int[] last = count(words[0]);
        for (int i = 1; i < words.length; i++) {
            last = intersection(last, count(words[i]));
        }
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (last[i] != 0) {
                char a = 'a';
                a += i;
                String s = String.valueOf(a);
                while (last[i] > 0) {
                    arr.add(s);
                    last[i]--;
                }
            }
        }
        return arr;
    }
    int[] intersection(int[] a, int[] b) {
        int[] t = new int[26];
        for (int i = 0; i < 26; i++) {
            t[i] = Math.min(a[i], b[i]);
        }
        return t;
    }
    int[] count(String str) {
        int[] t = new int[26];
        for (char c : str.toCharArray()) t[c - 'a']++;
        return t;
    }
}
    
 */