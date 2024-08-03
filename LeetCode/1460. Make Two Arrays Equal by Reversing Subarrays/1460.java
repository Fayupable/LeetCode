class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] targetCount = new int[1001];
        int[] arrCount = new int[1001];

        for (int i = 0; i < target.length; i++) {
            targetCount[target[i]]++;
            arrCount[arr[i]]++;
        }

        for (int i = 1; i <= 1000; i++) {
            if (targetCount[i] != arrCount[i]) {
                return false;
            }
        }

        return true;
    }
}
/* with helper functions
 * class Solution {
 * public boolean canBeEqual(int[] target, int[] arr) {
 * int[] targetCount = countFrequencies(target);
 * int[] arrCount = countFrequencies(arr);
 * return compareFrequencies(targetCount, arrCount);
 * }
 * 
 * private int[] countFrequencies(int[] array) {
 * int[] count = new int[1001];
 * for (int num : array) {
 * count[num]++;
 * }
 * return count;
 * }
 * 
 * private boolean compareFrequencies(int[] count1, int[] count2) {
 * for (int i = 1; i <= 1000; i++) {
 * if (count1[i] != count2[i]) {
 * return false;
 * }
 * }
 * return true;
 * }
 * }
 */
/* other peoples solution
 * class Solution {
 * public boolean canBeEqual(int[] target, int[] arr) {
 * int n = target.length, m = arr.length;
 * 
 * if (n != m) return false;
 * 
 * int[] map = new int[1001];
 * 
 * for (int i = 0; i < n; i++) {
 * map[target[i]]++;
 * map[arr[i]]--;
 * }
 * 
 * for (int i = 0; i < n; i++) {
 * if (map[target[i]] != 0 || map[arr[i]] != 0) {
 * return false;
 * }
 * }
 * 
 * return true;
 * }
 * }
 */