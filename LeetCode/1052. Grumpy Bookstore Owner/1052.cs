public class Solution {
    public int MaxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.Length;
        int satisfiedCustomers = 0;

        // Calculate the number of customers satisfied without using the technique
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                satisfiedCustomers += customers[i];
            }
        }

        int maxAdditionalSatisfied = 0; // Maximum additional satisfied customers
        int additionalSatisfied = 0;    // Current additional satisfied customers in the window

        // Use a sliding window to find the maximum additional satisfied customers
        for (int i = 0; i < n; i++) {
            // If the owner is grumpy, add the current customers to additionalSatisfied
            if (grumpy[i] == 1) {
                additionalSatisfied += customers[i];
            }

            // If the window size exceeds 'minutes', remove the customers who were part of the window
            if (i >= minutes && grumpy[i - minutes] == 1) {
                additionalSatisfied -= customers[i - minutes];
            }

            // Update the maxAdditionalSatisfied to be the maximum value found
            maxAdditionalSatisfied = Math.Max(maxAdditionalSatisfied, additionalSatisfied);
        }

        // The total maximum satisfied customers
        return satisfiedCustomers + maxAdditionalSatisfied;
    }

    public static void Main(string[] args) {
        Solution solution = new Solution();
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes = 3;
        Console.WriteLine(solution.MaxSatisfied(customers, grumpy, minutes)); // Expected output: 16
    }
}
//Other people's solutions
/*
public class Solution {
    public int MaxSatisfied(int[] customers, int[] grumpy, int minutes) {
        // Sliding window to find the max grumpy customers over minutes
        int unsatisfied = 0;
        int satisfied = 0;
        for (int i = 0; i < minutes && i < customers.Length; i++)
        {
            if (grumpy[i] == 1) unsatisfied += customers[i];
            if (grumpy[i] == 0) satisfied += customers[i];
        }
        int max = unsatisfied;
        for (int i = minutes; i < customers.Length; i++)
        {
            if (grumpy[i] == 1) unsatisfied += customers[i];
            if (grumpy[i] == 0) satisfied += customers[i];
            if (grumpy[i-minutes] == 1) unsatisfied -= customers[i-minutes];
            max = Math.Max(max, unsatisfied);
        }
        return satisfied + max;
    }
}
*/

/*
public class Solution {
    public int MaxSatisfied(int[] customers, int[] grumpy, int minutes)
    {
        if (minutes >= customers.Length) return customers.Sum();

        int[] cnt = new int[2];
        for (int i = 0; i < minutes; i++) cnt[grumpy[i]] += customers[i];
        int turn_cnt = cnt[1];
        for (int i = minutes; i < customers.Length; i++)
        {
            if (grumpy[i - minutes] != 0) cnt[1] -= customers[i - minutes];
            cnt[grumpy[i]] += customers[i];
            turn_cnt = Math.Max(turn_cnt, cnt[1]);
        }

        return cnt[0] + turn_cnt;
    }
}
*/
/*
public class Solution {
    public int MaxSatisfied(int[] customers, int[] grumpy, int minutes) {
        
        int answer = 0;

        int left = 0;
        int right = 0;
        int biggetRight = 0;
        int biggestLeft = 0;
        int maxGrump = 0;
        int foundIt = 0;
        while (right < customers.Length)
        {
            if (right-left > minutes-1)
            {
                if (grumpy[left]==1)
                {
                    maxGrump-=customers[left];
                }

                left++;
            }

            if (grumpy[right]==1)
            {
                maxGrump+=customers[right];
            }

            if (right >= minutes-1)
            {
                if (maxGrump > foundIt)
                {
                    foundIt = maxGrump;
                    biggetRight = right;
                    biggestLeft = left;
                }
            }

            right++;
        }

        
       // Console.WriteLine(biggestLeft +  "  right " +biggetRight);

        for (int i =0; i < customers.Length; i++)
        {
            if (grumpy[i]==0)
            {
                answer+=customers[i];
            }
            else if (i >=biggestLeft && i <= biggetRight)
            {
                answer+=customers[i];
            }
        }

        return answer;
    }
}
*/
/*
public class Solution {
    public int MaxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int satisfiedCustomers = 0;
        int unsatisfiedCustomers = 0;
        int windowStart = 0;
        int maxUnsatisfiedCustomers = 0;
        int currentMinute = 0;
        while (currentMinute < customers.Length) {
            if (grumpy[currentMinute] == 0)
                satisfiedCustomers += customers[currentMinute];
            else
                unsatisfiedCustomers += customers[currentMinute];
            
            if (currentMinute - windowStart + 1 == minutes) {
                maxUnsatisfiedCustomers = Math.Max(maxUnsatisfiedCustomers, unsatisfiedCustomers);
            
            if (grumpy[windowStart] == 1)
                unsatisfiedCustomers -= customers[windowStart];
            
            windowStart ++;
            }
            currentMinute ++;
        }

        return satisfiedCustomers + maxUnsatisfiedCustomers;
    }
}
*/