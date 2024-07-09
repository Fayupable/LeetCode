class Solution {
    public double averageWaitingTime(int[][] customers) {

        int n = customers.length;
        long waitTime = 0;
        long currentTime = 0;
        // currentTime = Math.max(currentTime, customers[i][0]) is used to calculate the
        // time when the chef is free to take the next order
        for (int i = 0; i < n; i++) {
            // if the current time is greater than the time when the customer arrives, then
            // the chef is free to take the next order
            currentTime = Math.max(currentTime, customers[i][0]);
            // the time when the chef is free to take the next order
            currentTime += customers[i][1];
            // the time the customer has to wait
            waitTime += currentTime - customers[i][0];
        }
        // return the average waiting time
        return (double) waitTime / n;

    }
}
//other people's solution

/*
 * class Solution {
 * public double averageWaitingTime(int[][] customers) {
 * double wait = 0;
 * int t = -1;
 * for(int[] a : customers) {
 * t = (t<a[0])?a[0]:t;
 * t += a[1];
 * wait += t-a[0];
 * }
 * return wait/customers.length;
 * }
 * }
 */
/*
 * class Solution {
 * public double averageWaitingTime(int[][] customers) {
 * List<Integer> waitingTimes= new ArrayList<>();
 * int startTime=customers[0][0];
 * int endTime=0;
 * double total=0.0;
 * for(int i=0;i<customers.length;i++){
 * if(startTime>customers[i][0])endTime=startTime+customers[i][1];
 * else endTime=customers[i][0]+customers[i][1];
 * int waitingTime=endTime-customers[i][0];
 * waitingTimes.add(waitingTime);
 * startTime=endTime;
 * }
 * for(int i=0;i<waitingTimes.size();i++){
 * double time=waitingTimes.get(i);
 * total+=time;
 * }
 * return total/waitingTimes.size();
 * }
 * }
 */