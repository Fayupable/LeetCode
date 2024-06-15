public class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];

        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }

        // Sort projects by their capital requirements using heap sort
        heapSort(projects, Comparator.comparingInt(a -> a[0]));

        // Max-Heap for the profits
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int i = 0;

        while (k-- > 0) {
            // Add all the projects that can be afforded with the current capital
            while (i < n && projects[i][0] <= w) {
                maxHeap.add(projects[i][1]);
                i++;
            }

            // If no project can be afforded, break the loop
            if (maxHeap.isEmpty()) {
                break;
            }

            // Select the project with the maximum profit
            w += maxHeap.poll();
        }

        return w;
    }

    private void heapSort(int[][] arr, Comparator<int[]> comparator) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i, comparator);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int[] temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0, comparator);
        }
    }

    private void heapify(int[][] arr, int n, int i, Comparator<int[]> comparator) {
        int largest = i;  // Initialize largest as root
        int left = 2 * i + 1;  // left = 2*i + 1
        int right = 2 * i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (left < n && comparator.compare(arr[left], arr[largest]) > 0) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && comparator.compare(arr[right], arr[largest]) > 0) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int[] swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest, comparator);
        }
    }
}

/*
 import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Arrays;

public class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];

        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }

        // Sort projects by their capital requirements
        Arrays.sort(projects, Comparator.comparingInt(a -> a[0]));

        // Max-Heap for the profits
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int i = 0;

        while (k-- > 0) {
            // Add all the projects that can be afforded with the current capital
            while (i < n && projects[i][0] <= w) {
                maxHeap.add(projects[i][1]);
                i++;
            }

            // If no project can be afforded, break the loop
            if (maxHeap.isEmpty()) {
                break;
            }

            // Select the project with the maximum profit
            w += maxHeap.poll();
        }

        return w;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 2;
        int w = 0;
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};

        System.out.println(solution.findMaximizedCapital(k, w, profits, capital)); // Expected output: 4
    }
}
 */


 //other people's solution

 /*
  
class Solution {
    class Pair {
        int capital;
        int profit;

        Pair(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.profit - a.profit);

        int maxCapital = w;
        int curr = 0;

        while (k > 0) {
            while (curr < n && arr[curr][0] <= maxCapital) {
                pq.add(new Pair(arr[curr][0], arr[curr][1]));
                curr++;
            }

            if (pq.isEmpty()) {
                break;
            }

            Pair best = pq.remove();
            maxCapital += best.profit;
            k--;
        }

        return maxCapital;
    }
}
  */

  /*
   class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        if(w == 1000000000 && profits[0] == 10000){return 2000000000;}
        if(k == 100000 && profits[0] == 10000){return 1000100000;}
        if(k == 100000 && profits[0] == 8013){return 595057;}

        int index = -1;
        int profit = -1;

        for(int i = 0; i<k; i++){
            index = profit = -1;

            for(int j = 0; j<profits.length; j++){
                if(capital[j]<=w && (profits[j]>profit)){
                    profit = profits[j];
                    index = j;
                }
            }
            
            if(index!=-1){
                w += profits[index];
                profits[index] = -1;
                capital[index] = -1;
            }
        }

        return w;
    }
}
   */
  /*
   class Solution {
    public int findMaximizedCapital(int numProjects, int initCap, int[] profits, int[] capital) {
        int cap = initCap;
		if (numProjects > profits.length) {
			numProjects = profits.length;
		}		
		int highestCap = 0;
		for (int x = 0; x < capital.length; x++) {
			highestCap = capital[x] > highestCap ? capital[x] : highestCap;
		}
		int projectsDone = 0;
		boolean tooPoor = false;
		for (int x = 0; x < numProjects; x++) {
			if (cap >= highestCap) {
				break;
			}
			int tempIndex = -1;
			int tempMaxCap = -1;
			for (int i = 0; i < capital.length; i++) {
				 if ((cap >= capital[i]) && (profits[i] > tempMaxCap)) {
						 tempMaxCap = profits[i]; 
						 tempIndex = i;
				 }
			}	
			if (tempIndex != -1) { 
				cap += tempMaxCap;
				profits[tempIndex] = -1;
				projectsDone++;
			} else {				
				tooPoor = true;
				break;
			}
		}
        int remainingProjects = numProjects - projectsDone;
		if ( (!tooPoor) && (remainingProjects > 0) ) {
			Arrays.sort(profits); 
			int lowIndex = profits.length - remainingProjects;
			for (int idx = profits.length -1; idx >= lowIndex; idx--) {
				if (profits[idx] != -1) {
					cap += profits[idx];
				} else {
					break;
				}
			}
		}
        return cap;
    }
}
   */

   /*
    class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
         // Crear una cola de prioridad (heap) para almacenar los proyectos disponibles
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        
        // Crear una cola de prioridad (heap) para almacenar los proyectos pendientes
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        // Agregar los proyectos iniciales al heap de proyectos disponibles
        for (int i = 0; i < profits.length; i++) {
            if (capital[i] <= w) {
                maxHeap.offer(new int[]{profits[i], capital[i]});
            } else {
                minHeap.offer(new int[]{profits[i], capital[i]});
            }
        }
        
        // Realizar hasta k inversiones
        while (k > 0 && !maxHeap.isEmpty()) {
            int[] project = maxHeap.poll();
            w += project[0]; // Agregar el beneficio al capital
            k--;
            
            // Mover proyectos pendientes al heap de proyectos disponibles
            while (!minHeap.isEmpty() && minHeap.peek()[1] <= w) {
                maxHeap.offer(minHeap.poll());
            }
        }
        
        return w;
    }
}
    */