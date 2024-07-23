import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        // Step 1: Count the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Sort the elements by frequency, then by value descending
        List<Integer> numList = new ArrayList<>(frequencyMap.keySet());
        Collections.sort(numList, (a, b) -> {
            if (frequencyMap.get(a) == frequencyMap.get(b)) {
                return b - a; // Descending order if frequencies are equal
            }
            return frequencyMap.get(a) - frequencyMap.get(b); // Ascending order by frequency
        });

        // Step 3: Build the result based on sorted order
        int[] sortedArray = new int[nums.length];
        int index = 0;
        for (int num : numList) {
            int count = frequencyMap.get(num);
            Arrays.fill(sortedArray, index, index + count, num);
            index += count;
        }

        return sortedArray;
    }
}

/*
 * class Solution {
 * public int[] frequencySort(int[] nums) {
 * int[] count=new int[202];
 * for(int i=0;i<nums.length;i++){
 * count[nums[i]+100]++;
 * }
 * quickSort(nums,count,0,nums.length-1);
 * return nums;
 * }
 * void quickSort(int[] nums,int freq[],int low,int high){
 * if(low<high){
 * int pivot=partition(nums,freq,low,high);
 * quickSort(nums,freq,low,pivot-1);
 * quickSort(nums,freq,pivot+1,high);
 * }
 * }
 * int partition(int[] nums,int freq[],int low,int high){
 * int pivot=freq[nums[high]+100];
 * int i=low-1;
 * for(int j=low;j<high;j++){
 * if(pivot > freq[nums[j]+100]){
 * i++;
 * int temp=nums[j];
 * nums[j]=nums[i];
 * nums[i]=temp;
 * }else if(freq[nums[j]+100]==pivot){
 * if(nums[high]<=nums[j]){
 * i++;
 * int temp=nums[j];
 * nums[j]=nums[i];
 * nums[i]=temp;
 * }
 * }
 * }
 * int temp=nums[i+1];
 * nums[i+1]=nums[high];
 * nums[high]=temp;
 * return i+1;
 * }
 * }
 */

/*
 * class Solution {
 * public int[] frequencySort(int[] nums) {
 * int count[] = new int[201];
 * for (int n : nums) count[n + 100]++;
 * int k = 0;
 * for (int i = nums.length - 1; i >= 0;) {
 * int m = 0, ind = -1;
 * for (int j = 0; j < 201; j++) {
 * if (count[j] > m) {
 * m = count[j];
 * ind = j;
 * }
 * }
 * for (int j = 0; j < m; j++) nums[i--] = ind - 100;
 * count[ind] = 0;
 * }
 * return nums;
 * }
 * }
 */

/*
 * class Solution {
 * public int[] frequencySort(int[] nums) {
 * int min = -100, max = 100;
 * int[] freq = new int[max-min+1];
 * 
 * for(int ele : nums){
 * freq[ele-min]++;
 * }
 * 
 * ArrayList<Integer> [] buckets = new ArrayList[nums.length + 1];
 * 
 * for(int bucket=0; bucket<buckets.length;bucket++){
 * buckets[bucket] = new ArrayList<>();
 * }
 * 
 * for(int ele = min;ele<=max; ele++){
 * int count = freq[ele - min];
 * if(count == 0) continue;
 * buckets[count].add(ele);
 * }
 * 
 * int idx =0;
 * for(int bucket = 1; bucket<buckets.length;bucket++){
 * Collections.reverse(buckets[bucket]);
 * for(int ele: buckets[bucket]){
 * for(int f =0; f< bucket; f++){
 * nums[idx++] = ele;
 * }
 * }
 * }
 * 
 * return nums;
 * }
 * }
 */

/*
 * class Solution {
 * public int[] frequencySort(int[] nums) {
 * int n = nums.length;
 * int ans[] = new int[n];
 * Map<Integer ,Integer> map = new HashMap<>();
 * 
 * for(int a : nums){
 * map.put(a , map.getOrDefault(a , 0) + 1);
 * }
 * 
 * List<Map.Entry<Integer , Integer>> list = new ArrayList<>(map.entrySet());
 * 
 * Collections.sort( list , new Comparator<Map.Entry<Integer,Integer>>(){
 * public int compare(Map.Entry<Integer , Integer> m1 ,
 * Map.Entry<Integer,Integer> m2){
 * if(m1.getValue() == m2.getValue()){
 * return m2.getKey() - m1.getKey();
 * }else{
 * return m1.getValue() - m2.getValue();
 * }
 * }
 * });
 * 
 * int k = 0;
 * 
 * for(Map.Entry<Integer , Integer> m : list){
 * int val = m.getValue();
 * 
 * while(val > 0){
 * ans[k++] = m.getKey();
 * val--;
 * }
 * }
 * 
 * return ans;
 * }
 * }
 */