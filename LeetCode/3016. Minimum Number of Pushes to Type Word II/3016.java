class Solution {

    // Function to count the frequency of each character in the word
    private int[] countFrequency(String word) {
        int[] frequency = new int[26];
        for (char c : word.toCharArray()) {
            frequency[c - 'a']++;
        }
        return frequency;
    }

    // Function to convert frequency array into a sorted list of frequencies in
    // descending order
    private List<Integer> getSortedFrequencies(int[] frequency) {
        List<Integer> frequencies = new ArrayList<>();
        for (int freq : frequency) {
            if (freq > 0) {
                frequencies.add(freq);
            }
        }
        frequencies.sort(Collections.reverseOrder());
        return frequencies;
    }

    // Function to calculate the minimum number of key presses needed
    private int calculateMinPushes(List<Integer> frequencies) {
        int totalPushes = 0;
        int keyPresses = 1;
        int keysUsed = 0;
        for (int freq : frequencies) {
            totalPushes += freq * keyPresses;
            keysUsed++;
            if (keysUsed == 8) { // Each key from 2-9 can be used once per set of 8 keys
                keysUsed = 0;
                keyPresses++;
            }
        }
        return totalPushes;
    }

    // Main function to compute minimum pushes required for the given word
    public int minimumPushes(String word) {
        int[] frequency = countFrequency(word);
        List<Integer> sortedFrequencies = getSortedFrequencies(frequency);
        return calculateMinPushes(sortedFrequencies);
    }
}

/*
 * class Solution {
 * public int minimumPushes(String word) {
 * int[] arr = new int[26];
 * for(int i=0;i<word.length();i++){
 * arr[word.charAt(i) - 'a']++;
 * }
 * Arrays.sort(arr);
 * int i=25;
 * int count = 0;
 * int start = 1;
 * int ans =0;
 * while( i >= 0 && arr[i] != 0){
 * ans+=(start * arr[i]);
 * count++;
 * if(count == 8){
 * start++;
 * count = 0;
 * }
 * i--;
 * }
 * return ans;
 * }
 * }
 */

/*
 * class Solution {
 * // Same as 3014. Minimum Number of Pushes to Type Word I
 * public int minimumPushes(String word) {
 * int ans = 0;
 * int[] count = new int[26];
 * 
 * for (final char c : word.toCharArray())
 * ++count[c - 'a'];
 * 
 * Arrays.sort(count);
 * for (int i = 0; i < 26; ++i)
 * ans += count[26 - i - 1] * (i / 8 + 1);
 * 
 * return ans;
 * }
 * }
 */