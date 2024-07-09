public class Solution
{
    public double AverageWaitingTime(int[][] customers)
    {
        double totalWaitTime = 0;
        double currentTime = 0;
        foreach (var customer in customers)
        {
            if (currentTime < customer[0])
            {
                currentTime = customer[0];
            }
            currentTime += customer[1];
            totalWaitTime += currentTime - customer[0];
        }
        return totalWaitTime / customers.Length;

    }
}
//other people's solution

/*
public class Solution {
    public double AverageWaitingTime(int[][] customers) {
       int curtime = customers[0][0]; 
       double wSum = 0;
       int waittime = 0;
       for(int i = 0; i < customers.Length; i++){
            if (curtime < customers[i][0]) {
                curtime = customers[i][0];
            }
            waittime = (curtime - customers[i][0]) + customers[i][1];
            curtime = curtime + customers[i][1];
            wSum = wSum + waittime;
           
       }
       return (double)wSum/customers.Length;
    }
}
*/
/*
public class Solution {
    public double AverageWaitingTime(int[][] customers) {
       var d = customers.Length;
        var sum = 0d;
        var chefTime = customers[0][0];
        foreach (var arr in customers)
        {
            var arrTime = arr[0];
            sum += arr[1];
            if (chefTime - arrTime >= 0)
                sum += chefTime - arrTime;
            else
            {
                chefTime = arrTime;
            }
            chefTime += arr[1];
        }
        return sum / d;
    }
}
*/
