import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Worker[] workers = new Worker[n];
        
        for (int i = 0; i < n; i++) {
            workers[i] = new Worker((double) wage[i] / quality[i], quality[i]);
        }
        
        Arrays.sort(workers, (a, b) -> Double.compare(a.ratio, b.ratio));
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        double minWage = Double.POSITIVE_INFINITY;
        int totalQuality = 0;
        
        for (Worker worker : workers) {
            totalQuality += worker.quality;
            maxHeap.offer(worker.quality);
            
            if (maxHeap.size() > k) {
                totalQuality -= maxHeap.poll();
            }
            
            if (maxHeap.size() == k) {
                minWage = Math.min(minWage, totalQuality * worker.ratio);
            }
        }
        
        return minWage;
    }
    
    class Worker {
        double ratio;
        int quality;
        
        Worker(double ratio, int quality) {
            this.ratio = ratio;
            this.quality = quality;
        }
    }
}
