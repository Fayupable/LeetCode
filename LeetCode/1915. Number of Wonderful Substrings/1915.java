class Solution {
    public long wonderfulSubstrings(String word) {
        int[] count = new int[1024]; // Stores count of substrings with each bitmask
        count[0] = 1; // Initialize count for empty substring
        int mask = 0;
        long result = 0;

        for (char c : word.toCharArray()) {
            mask ^= 1 << (c - 'a'); // Toggle the bit corresponding to the current character
            result += count[mask]; // Add count of substrings with the current bitmask

            // Check substrings with one bit different from the current bitmask
            for (int i = 0; i < 10; i++) {
                result += count[mask ^ (1 << i)];
            }

            count[mask]++; // Increment count for the current bitmask
        }

        return result;
    }
}
