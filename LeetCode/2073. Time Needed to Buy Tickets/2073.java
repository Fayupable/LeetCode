class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        // Initialize time to 0. This variable will keep track of the total time required.
        int time = 0;

        // While the k-th person still has tickets to buy
        while (tickets[k] > 0) {
            // Iterate over all people in the line
            for (int i = 0; i < tickets.length; i++) {
                // If the current person still has tickets to buy
                if (tickets[i] > 0) {
                    // Decrease the number of tickets for the current person by 1
                    tickets[i]--;
                    // Increase the total time by 1
                    time++;
                }
                // If the k-th person has bought all their tickets, break the loop
                if (tickets[k] == 0) {
                    break;
                }
            }
        }
        // Return the total time required for the k-th person to buy all their tickets
        return time;
    }
}