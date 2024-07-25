//with heapsort
class Solution {
    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;

    }

    public void heapSort(int[] nums) {
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            heapify(nums, i, 0);
        }
    }

    public void heapify(int[] nums, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < n && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = nums[i];
            nums[i] = nums[largest];
            nums[largest] = temp;
            heapify(nums, n, largest);
        }
    }
}


/*
 * class Solution {
 * public int[] sortArray(int[] nums) {
 * int max = nums[0];
 * int min = nums[0];
 * 
 * for (int num : nums) {
 * max = Math.max(max, num);
 * min = Math.min(min, num);
 * }
 * 
 * int n = max - min;
 * int[] arr = new int[n + 1];
 * 
 * for (int num : nums) {
 * arr[num - min]++;
 * }
 * 
 * int index = 0;
 * 
 * for (int i = 0; i <= n; i++) {
 * while (arr[i] > 0) {
 * nums[index] = min;
 * index++;
 * arr[i]--;
 * }
 * 
 * min++;
 * }
 * 
 * return nums;
 * }
 * }
 */

 //merge sort
/*
 * class Solution {
 * public int[] sortArray(int[] nums) {
 * mergeSort(nums);
 * return nums;
 * }
 * 
 * public void mergeSort(int[] array){
 * int n = array.length;
 * if(n <= 1) return;
 * 
 * int mid = n / 2;
 * int[] leftArray = Arrays.copyOfRange(array, 0, mid);
 * int[] rightArray = Arrays.copyOfRange(array, mid, n);
 * 
 * mergeSort(leftArray);
 * mergeSort(rightArray);
 * mergeSortHelper(leftArray, rightArray, array);
 * }
 * 
 * public void mergeSortHelper(int[] leftArray, int[] rightArray, int[] array){
 * int leftSize = leftArray.length;
 * int rightSize = rightArray.length;
 * int i = 0, j = 0, k = 0;
 * 
 * // Merge the two subarrays into the original array
 * while (i < leftSize && j < rightSize) {
 * if (leftArray[i] <= rightArray[j]) {
 * array[k++] = leftArray[i++];
 * } else {
 * array[k++] = rightArray[j++];
 * }
 * }
 * 
 * // Copy the remaining elements of leftArray, if any
 * while (i < leftSize) {
 * array[k++] = leftArray[i++];
 * }
 * 
 * // Copy the remaining elements of rightArray, if any
 * while (j < rightSize) {
 * array[k++] = rightArray[j++];
 * }
 * }
 * }
 */