public class Solution {
    public int MinMovesToSeat(int[] seats, int[] students) {
        // Sort the seats and students arrays using quick sort
        QuickSort(seats, 0, seats.Length - 1);
        QuickSort(students, 0, students.Length - 1);
        
        int totalMoves = 0;
        
        // Iterate over the seats array
        for (int i = 0; i < seats.Length; i++) {
            // Add the absolute difference between the seat and student positions to totalMoves
            totalMoves += Math.Abs(seats[i] - students[i]);
        }
        
        // Return the total number of moves
        return totalMoves;
    }
    
    // Quick sort method
    private void QuickSort(int[] array, int low, int high) {
        // Base case: if there are 1 or zero elements to sort
        if (low < high) {
            // pi is partitioning index, array[pi] is now at right place
            int pi = Partition(array, low, high);
            
            // Recursively sort elements before and after partition
            QuickSort(array, low, pi - 1);
            QuickSort(array, pi + 1, high);
        }
    }
    
    // This function takes last element as pivot, places the pivot element at its correct position in sorted array,
    // and places all smaller (smaller than pivot) to left of pivot and all greater elements to right of pivot
    private int Partition(int[] array, int low, int high) {
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
        int swapTemp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = swapTemp;
        
        return i + 1;
    }
}


/*
public class Solution {
    public int MinMovesToSeat(int[] seats, int[] students) {
        int count = 0;
        Array.Sort(seats);
        Array.Sort(students);

        for(int i = 0;i<seats.Length;i++) count += Math.Abs(seats[i]-students[i]);
        return count;
    }
}
*/

/*
public class Solution {
    public int MinMovesToSeat(int[] seats, int[] students) {
        int count = 0;
        int ssTemp,sstTemp;
        for(int i =0;i<seats.Length-1;i++)
        {
            for(int j=0;j<seats.Length-1-i;j++)
            {
                if(seats[j] > seats[j+1])
                {
                    ssTemp = seats[j];
                    seats[j] = seats[j+1];
                    seats[j+1] = ssTemp;
                }
                if(students[j] > students[j+1])
                {
                    sstTemp = students[j];
                    students[j] = students[j+1];
                    students[j+1] = sstTemp;
                }
            }
        }

        for(int i = 0;i<seats.Length;i++) count += Math.Abs(seats[i]-students[i]);
        return count;
    }
}
*/

/*
public class Solution {
    public int MinMovesToSeat(int[] seats, int[] students) {
        var seatsQueue = new PriorityQueue<int, int>();
        foreach (var seat in seats)
        {
            seatsQueue.Enqueue(seat, seat * -1);
        }

        var studentsQueue = new PriorityQueue<int, int>();
        foreach (var student in students)
        {
            studentsQueue.Enqueue(student, student * -1);
        }

        var total = 0;

        while (seatsQueue.Count != 0)
        {
            var student = studentsQueue.Dequeue();
            var seat = seatsQueue.Dequeue();

            if (seat <= student)
            {
                total += student - seat;
            }
            else
            {
                total += seat - student;
            }
        }

        return total;
    }
}

*/

