public class Solution {
    public int FindMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.Length;
        int[][] projects = new int[n][];

        for (int i = 0; i < n; i++) {
            projects[i] = new int[] { capital[i], profits[i] };
        }

        // Sort projects by their capital requirements
        Array.Sort(projects, (a, b) => a[0] - b[0]);

        // Max-Heap for the profits
        PriorityQueue<int, int> maxHeap = new PriorityQueue<int, int>(Comparer<int>.Create((a, b) => b.CompareTo(a)));
        int j = 0;

        while (k-- > 0) {
            // Add all the projects that can be afforded with the current capital
            while (j < n && projects[j][0] <= w) {
                maxHeap.Enqueue(projects[j][1], projects[j][1]);
                j++;
            }

            // If no project can be afforded, break the loop
            if (maxHeap.Count == 0) {
                break;
            }

            // Select the project with the maximum profit
            w += maxHeap.Dequeue();
        }

        return w;
    }
}


/*
public class Solution {
    public int FindMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Array.Sort(capital, profits);
        var idx = 0;
        var avProj = new PriorityQueue<int, int>();
        
        for(;idx < capital.Length && capital[idx] <= w ; idx++) avProj.Enqueue(profits[idx], -profits[idx]);
        while(k-- > 0 && avProj.Count > 0) {
            w += avProj.Dequeue();
            for(;idx < capital.Length && capital[idx] <= w ; idx++) avProj.Enqueue(profits[idx], -profits[idx]);
        }

        return w;
    }
}
*/  

/*

public class Solution
{
    public int FindMaximizedCapital(int k, int w, int[] profits, int[] capital)
    {
        Array.Sort(capital, profits);

        var heap = new PriorityQueue<int, int>();

        int nextProject = 0;

        for (int i = 0; i < k; i++)
        {
            while ((nextProject < profits.Length) && (capital[nextProject] <= w))
            {
                heap.Enqueue(profits[nextProject], -profits[nextProject]);
                nextProject++;
            }
            if (heap.Count == 0)
            {
                return w;
            }

            w += heap.Dequeue();
        }

        return w;
    }
}

*/

/*
public class Solution
{
    class Project :  IComparable<Project>
    {
        public int profit;
        public int capital;

        public Project(int profit, int capital)
        {
            this.profit = profit;
            this.capital = capital;
        }
        public int CompareTo(Project? other)
        {
            return this.capital.CompareTo(other?.capital);
        }
    }

    public int FindMaximizedCapital(int k, int w, int[] profits, int[] capital)
    {
        var length = capital.Length;
        Array.Sort(capital, profits);

        var queue = new PriorityQueue<int, int>();
        var lastIndex = 0;

        for (int i = 0; i < k; i++)
        {
            while (lastIndex < length && capital[lastIndex] <= w)
            {
                queue.Enqueue(profits[lastIndex], -profits[lastIndex]);
                lastIndex++;
            }

            if (queue.Count > 0)
            {
                w += queue.Dequeue();
            }
        }

        return w;
    }
}
*/

/*
public class Solution {
    public int FindMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // keep track of which projects are affordable
        // priority based on capital cost
        // keep track of profit-capital in a second queue
        // first add items to queue by capital
        // dequeue cheap projects into available projects until w hit
        // dequeue available according to highest priority

        var money = w;

        var available = new PriorityQueue<int, int>();
        for(var i = 0; i < capital.Length; i++)
        {
            available.Enqueue(i, capital[i]);
           // Console.WriteLine($"Enquing {i} with priority {capital[i]}");
        }

        var affordable = new PriorityQueue<int, int>();
        AddAffordableProjectsToQueue(money, profits, capital, available, affordable);

        for(int i = 0; i < k; i++)
        {
            if(affordable.Count == 0)
            {
                continue;
            }

            var project = affordable.Dequeue();
            //Console.WriteLine($"Removing project {project} with profit {profits[project]}");
            money += profits[project];

            AddAffordableProjectsToQueue(money, profits, capital, available, affordable);
        }

        return money;
    }

    private void AddAffordableProjectsToQueue(int money, int[] profits, int[] capital, PriorityQueue<int, int> available, PriorityQueue<int, int> affordable)
    {
        //Console.WriteLine($"Adding affordable projects from available {available.Count}, with cash {money}");

        //if(available.Count > 0)
        //{
        //    Console.WriteLine($"Cheapest item {available.Peek()} with capital {capital[available.Peek()]}");
        //}
        while(available.Count > 0 && capital[available.Peek()] <= money)
        {
            var project = available.Dequeue();
            //Console.WriteLine($"Dequeuing {project}");
            affordable.Enqueue(project, -profits[project]);
        }
    }
}
*/