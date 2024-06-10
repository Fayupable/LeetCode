//with quick sort
class Solution {
    public int heightChecker(int[] heights) {
        // Create a copy of the heights array
        int[] expected = heights.clone();
        
        // Sort the expected array using Quick Sort
        quickSort(expected, 0, expected.length - 1);
        
        // Initialize the counter for differences
        int count = 0;
        
        // Compare the elements of heights and expected arrays
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        
        // Return the count of indices where heights and expected differ
        return count;
    }
    
    // Quick Sort function
    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            
            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    // Partition function used in Quick Sort
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // Index of smaller element
        
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // Swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1;
    }
}

/*
//with bubble sort
class Solution {
    public int heightChecker(int[] heights) {
        // Create a copy of the heights array
        int[] expected = heights.clone();
        
        // Sort the expected array using Bubble Sort
        bubbleSort(expected);
        
        // Initialize the counter for differences
        int count = 0;
        
        // Compare the elements of heights and expected arrays
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        
        // Return the count of indices where heights and expected differ
        return count;
    }
    
    // Bubble Sort function
    private void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

 
 */
/*
//with merge sort
 class Solution {
    public int heightChecker(int[] heights) {
        // Create a copy of the heights array
        int[] expected = heights.clone();
        
        // Sort the expected array using Merge Sort
        mergeSort(expected, 0, expected.length - 1);
        
        // Initialize the counter for differences
        int count = 0;
        
        // Compare the elements of heights and expected arrays
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        
        // Return the count of indices where heights and expected differ
        return count;
    }
    
    // Merge Sort function
    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            
            // Recursively sort the left and right halves
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            
            // Merge the sorted halves
            merge(arr, left, middle, right);
        }
    }
    
    // Merge function used in Merge Sort
    private void merge(int[] arr, int left, int middle, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = middle - left + 1;
        int n2 = right - middle;
        
        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        
        // Copy data to temporary arrays
        for (int i = 0; i < n1; ++i) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = arr[middle + 1 + j];
        }
        
        // Merge the temporary arrays
        
        // Initial indices of first and second subarrays
        int i = 0, j = 0;
        
        // Initial index of merged subarray
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        
        // Copy remaining elements of leftArray[] if any
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        
        // Copy remaining elements of rightArray[] if any
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}

 */

 /*
 //with heap sort
  class Solution {
    public int heightChecker(int[] heights) {
        // Create a copy of the heights array
        int[] expected = heights.clone();
        
        // Sort the expected array using Heap Sort
        heapSort(expected);
        
        // Initialize the counter for differences
        int count = 0;
        
        // Compare the elements of heights and expected arrays
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        
        // Return the count of indices where heights and expected differ
        return count;
    }
    
    // Heap Sort function
    private void heapSort(int[] arr) {
        int n = arr.length;
        
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        
        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
    
    // To heapify a subtree rooted with node i which is an index in arr[]
    private void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2
        
        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        
        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        
        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
}

  */

  /*
   //with insertion sort
   class Solution {
    public int heightChecker(int[] heights) {
        // Create a copy of the heights array
        int[] expected = heights.clone();
        
        // Sort the expected array using Insertion Sort
        insertionSort(expected);
        
        // Initialize the counter for differences
        int count = 0;
        
        // Compare the elements of heights and expected arrays
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        
        // Return the count of indices where heights and expected differ
        return count;
    }
    
    // Insertion Sort function
    private void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            
            // Move elements of arr[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}

   */
  /*
    //with selection sort
    class Solution {
    public int heightChecker(int[] heights) {
        // Create a copy of the heights array
        int[] expected = heights.clone();
        
        // Sort the expected array using Selection Sort
        selectionSort(expected);
        
        // Initialize the counter for differences
        int count = 0;
        
        // Compare the elements of heights and expected arrays
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        
        // Return the count of indices where heights and expected differ
        return count;
    }

    // Selection Sort function
    private void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

}



   */