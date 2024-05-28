class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        // Calculate the absolute difference between ASCII values of characters in s and t
        int[] diff = new int[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        
        // Initialize the left pointer of the sliding window
        int left = 0;
        
        // Iterate over the diff array with the right pointer
        for (int right = 0; right < diff.length; ++right) {
            // Subtract the current diff value from maxCost
            maxCost -= diff[right];
            
            // If maxCost is less than 0, move the left pointer to the right and add the diff value at the left pointer to maxCost
            if (maxCost < 0) {
                maxCost += diff[left];
                left += 1;
            }
        }
        
        // Return the maximum length of a substring that can be changed to be the same as the corresponding substring of t with a cost less than or equal to maxCost
        return diff.length - left;
    }
}
/*
 
 Calculating the diff array or arr array takes O(n) time because we're iterating over each character in the strings s and t.

The sliding window loop also takes O(n) time because in the worst-case scenario, we're iterating over each element in the diff array or arr array once.

Since these two operations are sequential and not nested, we add their time complexities, resulting in 2*O(n). However, in Big O notation, we drop constants, so the final time complexity is O(n).


/*
 class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] arr = new int[s.length()];
        char[] ch = s.toCharArray(), target = t.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Math.abs(ch[i] - target[i]);
        }
        int cost = 0, start = 0, end = 0, ans = 0;

        while(start < arr.length && end < arr.length) {
            cost += arr[end++];
            if(cost <= maxCost) ans = Math.max(ans, end - start);
            else while(cost > maxCost) cost -= arr[start++];
        }
        return ans;
    }
}
 */