class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        // Sort the seats and students arrays using quick sort
        quickSort(seats, 0, seats.length - 1);
        quickSort(students, 0, students.length - 1);
        
        int totalMoves = 0;
        
        // Iterate over the seats array
        for (int i = 0; i < seats.length; i++) {
            // Add the absolute difference between the seat and student positions to totalMoves
            totalMoves += Math.abs(seats[i] - students[i]);
        }
        
        // Return the total number of moves
        return totalMoves;
    }
    
    // Quick sort method
    private void quickSort(int[] array, int low, int high) {
        // Base case: if there are 1 or zero elements to sort
        if (low < high) {
            // pi is partitioning index, array[pi] is now at right place
            int pi = partition(array, low, high);
            
            // Recursively sort elements before and after partition
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }
    
    // This function takes last element as pivot, places the pivot element at its correct position in sorted array,
    // and places all smaller (smaller than pivot) to left of pivot and all greater elements to right of pivot
    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1); // index of smaller element
        
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (array[j] < pivot) {
                i++;
                
                // swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        
        // swap array[i+1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        
        return i + 1;
    }
}

/* 
class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int totalMoves = 0;
        
        for (int i = 0; i < seats.length; i++) {
            totalMoves += Math.abs(seats[i] - students[i]);
        }
        
        return totalMoves;
    }
}

*/
/*
 class Solution {

    public int minMovesToSeat(int[] seats, int[] students) {
        // Find the maximum position in the arrays
        int maxPosition = Math.max(findMax(seats), findMax(students));

        // Stores difference between number of seats and students at each position
        int[] differences = new int[maxPosition];

        // Count the available seats at each position
        for (int position : seats) {
            differences[position - 1]++;
        }

        // Remove a seat for each student at that position
        for (int position : students) {
            differences[position - 1]--;
        }

        // Calculate the number of moves needed to seat the students
        int moves = 0;
        int unmatched = 0;
        for (int difference : differences) {
            moves += Math.abs(unmatched);
            unmatched += difference;
        }

        return moves;
    }

    private int findMax(int[] array) {
        int maximum = 0;
        for (int num : array) {
            if (num > maximum) {
                maximum = num;
            }
        }
        return maximum;
    }
}
 */