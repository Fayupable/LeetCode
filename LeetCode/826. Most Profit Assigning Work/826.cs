using System;

public class Solution {
    public int MaxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        if (difficulty.Length != profit.Length) {
            return 0;
        }

        int maxDifficulty = 0;
        foreach (int diff in difficulty) {
            maxDifficulty = Math.Max(maxDifficulty, diff);
        }

        int[] bestProfit = new int[maxDifficulty + 1];
        for (int i = 0; i < profit.Length; i++) {
            bestProfit[difficulty[i]] = Math.Max(bestProfit[difficulty[i]], profit[i]);
        }

        int maxProfit = 0;
        for (int i = 0; i < bestProfit.Length; i++) {
            if (bestProfit[i] > maxProfit) {
                maxProfit = bestProfit[i];
            }
            bestProfit[i] = maxProfit;
        }

        int result = 0;
        foreach (int w in worker) {
            if (w > maxDifficulty) {
                result += bestProfit[maxDifficulty];
            } else {
                result += bestProfit[w];
            }
        }
        return result;
    }

    public static void Main(string[] args) {
        Solution solution = new Solution();
        
        int[] difficulty1 = {2, 4, 6, 8, 10};
        int[] profit1 = {10, 20, 30, 40, 50};
        int[] worker1 = {4, 5, 6, 7};
        Console.WriteLine(solution.MaxProfitAssignment(difficulty1, profit1, worker1)); // Expected output: 100

        int[] difficulty2 = {85, 47, 57};
        int[] profit2 = {24, 66, 99};
        int[] worker2 = {40, 25, 25};
        Console.WriteLine(solution.MaxProfitAssignment(difficulty2, profit2, worker2)); // Expected output: 0
    }
}

/*
using System;
using System.Linq;

public class Solution {
    public int MaxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.Length;
        int[][] jobs = new int[n][];
        
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] { difficulty[i], profit[i] };
        }
        
        // Sort jobs by difficulty
        Array.Sort(jobs, (a, b) => a[0] - b[0]);
        // Sort worker array
        Array.Sort(worker);
        
        int maxProfit = 0;
        int best = 0;
        int i = 0;
        
        foreach (int ability in worker) {
            while (i < n && ability >= jobs[i][0]) {
                best = Math.Max(best, jobs[i][1]);
                i++;
            }
            maxProfit += best;
        }
        
        return maxProfit;
    }

    public static void Main(string[] args) {
        Solution solution = new Solution();
        
        int[] difficulty1 = {2, 4, 6, 8, 10};
        int[] profit1 = {10, 20, 30, 40, 50};
        int[] worker1 = {4, 5, 6, 7};
        Console.WriteLine(solution.MaxProfitAssignment(difficulty1, profit1, worker1)); // Expected output: 100

        int[] difficulty2 = {85, 47, 57};
        int[] profit2 = {24, 66, 99};
        int[] worker2 = {40, 25, 25};
        Console.WriteLine(solution.MaxProfitAssignment(difficulty2, profit2, worker2)); // Expected output: 0
    }
}
*/

/*
public class Solution {
    public int MaxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Array.Sort(worker);
        Array.Sort(difficulty, profit);

        int i = 0, j = 0, ans = 0;
        int max = 0;
        while (j < worker.Length)
        {
            if (i < difficulty.Length && worker[j] >= difficulty[i])
            {
                max = Math.Max(max, profit[i]);
                ++i;
            }
            else
            {
                ans += max;
                ++j;
            }

        }
        return ans;
    }
}
*/
/*
public class Solution {
    public int MaxProfitAssignment(int[] difficulty, int[] profit, int[] worker)
    {
        List<(int, int)> maxP = new List<(int, int)>();
        InitMaxP(difficulty, profit, maxP);
        int res = 0;
        foreach (var w in worker)
        {
            res += BinarySearch(maxP, w);
        }
        return res;
    }

    private int BinarySearch(List<(int, int)> maxP, int w)
    {
        if (maxP.First().Item1 > w)
        {
            return 0;
        }
        var min = 0;
        var max = maxP.Count - 1;
        while (min < max)
        {
            var mid = (max + min + 1) / 2;
            if (maxP[mid].Item1 < w)
            {
                min = mid;
            }
            else if (maxP[mid].Item1 > w)
            {
                max = mid - 1;
            }
            else
            {
                return maxP[mid].Item2;
            }
        }

        return maxP[min].Item1 > w ? 0 : maxP[min].Item2;
    }

    private void InitMaxP(int[] difficulty, int[] profit, List<(int, int)> maxP)
    {
        SortedList<int, int> list = new SortedList<int, int>();
        for (int i = 0; i < difficulty.Length; i++)
        {
            var key = difficulty[i];
            var value = list.ContainsKey(key)? Math.Max(profit[i], list[key]): profit[i];

            list[key] = value;
        }

        var p = 0;
        foreach (var w in list)
        {
            p = Math.Max(p, w.Value);
            maxP.Add((w.Key, p));
            
        }

    }
}
*/
