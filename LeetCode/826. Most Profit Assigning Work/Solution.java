public class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        Arrays.sort(worker);
        
        int maxProfit = 0;
        int best = 0;
        int i = 0;
        
        for (int ability : worker) {
            while (i < n && ability >= jobs[i][0]) {
                best = Math.max(best, jobs[i][1]);
                i++;
            }
            maxProfit += best;
        }
        
        return maxProfit;
    }
}

/*
 class Solution {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        if (difficulty.length != profit.length) {return 0;}

        int maxDifficulty = 0;
        for (int diff: difficulty) {
            maxDifficulty = Math.max(maxDifficulty, diff);
        }

        int[] bestProfit = new int[maxDifficulty + 1];
        for (int i = 0; i < profit.length; i++) {
            bestProfit[difficulty[i]] = Math.max(bestProfit[difficulty[i]], profit[i]);
        }

        int maxProfit = 0;
        for (int i = 0; i < bestProfit.length; i++) {
            if (bestProfit[i] > maxProfit) {
                maxProfit = bestProfit[i];
            }
            bestProfit[i] = maxProfit;
        }

        int result = 0;
        for (int w: worker) {
            if (w > maxDifficulty) {
                result += bestProfit[maxDifficulty];
            } else {
                result += bestProfit[w];
            }
        }
        return result;
    }
}
 */

 /*
  class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = profit.length;
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            arr[i][0] = difficulty[i];
            arr[i][1] = profit[i];
        }
        Arrays.sort(arr, (a, b) ->{
            return a[0] - b[0];
        });
        Arrays.sort(worker);
        int pro = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        int idx = 0;
        for(int i = 0; i < worker.length; i++){
            while(idx < n && arr[idx][0] <= worker[i]){
                pq.offer(arr[idx][1]);
                idx++;
            }
            if(pq.isEmpty()) continue;
            pro += pq.peek();
        }
        return pro;
    }
}
  */