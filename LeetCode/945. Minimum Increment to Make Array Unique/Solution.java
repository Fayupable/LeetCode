import java.util.Arrays;
class Solution {
    public int MinIncrementForUnique(int[] nums) {
        // Sort the input array in ascending order
        Arrays.sort(nums);
        // Initialize a variable to keep track of the total increments needed to make all elements in the array unique
        int moves = 0;
        // Iterate over the array starting from the second element (index 1)
        for (int i = 1; i < nums.length; i++) {
            // If the current element is less than or equal to the previous element
            if (nums[i] <= nums[i - 1]) {
                // Increment the moves by the difference between the previous element (plus one) and the current element
                moves += nums[i - 1] + 1 - nums[i];
                // Make the current element one more than the previous element
                nums[i] = nums[i - 1] + 1;
            }
        }
        // Return the total number of moves (increments) made
        return moves;
    }
}

/*
 class Solution {

    public int minIncrementForUnique(int[] nums) {
        int n = nums.length;
        int max = 0;
        int minIncrements = 0;

        // Find maximum value in array to determine range of frequencyCount array
        for (int val : nums) {
            max = Math.max(max, val);
        }

        // Create a frequencyCount array to store the frequency of each value in nums
        int[] frequencyCount = new int[n + max];

        // Populate frequencyCount array with the frequency of each value in nums
        for (int val : nums) {
            frequencyCount[val]++;
        }

        // Iterate over the frequencyCount array to make all values unique
        for (int i = 0; i < frequencyCount.length; i++) {
            if (frequencyCount[i] <= 1) continue;

            // Determine excess occurrences, carry them over to the next value,
            // ensure single occurrence for current value, and update minIncrements.
            int duplicates = frequencyCount[i] - 1;
            frequencyCount[i + 1] += duplicates;
            frequencyCount[i] = 1;
            minIncrements += duplicates;
        }

        return minIncrements;
    }
}
 */
/*
 import java.util.PriorityQueue;

public class Solution {
    public int minIncrementForUnique(int[] nums) {
        heapSort(nums);
        int moves = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                moves += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }
        return moves;
    }

    private void heapSort(int[] nums) {
        int n = nums.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(nums, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            // Call max heapify on the reduced heap
            heapify(nums, i, 0);
        }
    }

    private void heapify(int[] nums, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < n && nums[left] > nums[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < n && nums[right] > nums[largest])
            largest = right;

        // If largest is not root
        if (largest != i) {
            int swap = nums[i];
            nums[i] = nums[largest];
            nums[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(nums, n, largest);
        }
    }
}
 */