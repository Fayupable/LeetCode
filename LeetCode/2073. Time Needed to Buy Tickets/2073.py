class Solution(object):
    def timeRequiredToBuy(self, tickets, k):
        """
        :type tickets: List[int]
        :type k: int
        :rtype: int
        """
        # Initialize time to 0. This variable will keep track of the total time required.
        time=0

        # While the k-th person still has tickets to buy
        while tickets[k]>0:
            # Iterate over all people in the line
            for i in range(len(tickets)):
                # If the current person still has tickets to buy
                if tickets[i]>0:
                    # Decrease the number of tickets for the current person by 1
                    tickets[i]-=1
                    # Increase the total time by 1
                    time+=1
                # If the k-th person has bought all their tickets, break the loop
                if tickets[k]==0:
                    break
        # Return the total time required for the k-th person to buy all their tickets
        return time