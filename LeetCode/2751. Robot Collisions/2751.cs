using System;
using System.Collections.Generic;
using System.Linq;

public class Solution
{
    public IList<int> SurvivedRobotsHealths(int[] positions, int[] healths, string directions)
    {
        int n = positions.Length;
        List<int[]> robots = new List<int[]>();

        // Populate the robots list with robot details
        for (int i = 0; i < n; ++i)
        {
            robots.Add(new int[] { positions[i], healths[i], directions[i], i });
        }

        // Sort robots based on their positions
        robots.Sort((a, b) => a[0].CompareTo(b[0]));

        Stack<int[]> stack = new Stack<int[]>();

        // Process each robot in the sorted list
        foreach (int[] robot in robots)
        {
            if (robot[2] == 'R' || stack.Count == 0 || stack.Peek()[2] == 'L')
            {
                stack.Push(robot);
                continue;
            }

            // Handle collisions between robots
            if (robot[2] == 'L')
            {
                bool add = true;
                while (stack.Count > 0 && stack.Peek()[2] == 'R' && add)
                {
                    int lastHealth = stack.Peek()[1];
                    if (robot[1] > lastHealth)
                    {
                        stack.Pop();
                        robot[1] -= 1;
                    }
                    else if (robot[1] < lastHealth)
                    {
                        stack.Peek()[1] -= 1;
                        add = false;
                    }
                    else
                    { // Equal health, both robots are destroyed
                        stack.Pop();
                        add = false;
                    }
                }

                if (add)
                {
                    stack.Push(robot);
                }
            }
        }

        // Prepare the final list of surviving robots, sorted by their original indices
        List<int[]> resultList = new List<int[]>(stack);
        resultList.Sort((a, b) => a[3].CompareTo(b[3]));

        // Extract the healths of the surviving robots
        List<int> result = new List<int>();
        foreach (int[] robot in resultList)
        {
            result.Add(robot[1]);
        }

        return result;
    }
}

/*
public class Solution {
    public IList<int> SurvivedRobotsHealths(int[] positions, int[] healths, string directions) {
        var dictionary = new Dictionary<int, int>();
        for (var i = 0; i < positions.Length; i++)
        {
            dictionary.Add(positions[i], i);
        }

        Array.Sort(positions);
        var stack = new Stack<int>();
        for (var i = 0; i < positions.Length; i++)
        {
            var position = positions[i];
            var index = dictionary[position];
            while (stack.Count > 0 && directions[stack.Peek()] == 'R' && directions[index] == 'L' && healths[index] > 0)
            {
                var last = stack.Peek();
                if (healths[last] < healths[index])
                {
                    stack.Pop();
                    healths[index]--;
                    healths[last] = 0;
                }
                else if (healths[last] > healths[index])
                {
                    healths[last]--;
                    healths[index] = 0;
                }
                else
                {
                    stack.Pop();
                    healths[last] = 0;
                    healths[index] = 0;
                }
            }
            if (healths[index] > 0)
            {
                stack.Push(index);

            }
        }
        var list = new List<int>();

        foreach (var health in healths)
        {
            if (health > 0)
                list.Add(health);
        }
        return list;
    }
}
*/