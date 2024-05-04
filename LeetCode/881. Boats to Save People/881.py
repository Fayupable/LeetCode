class Solution:
    def numRescueBoats(self, people, limit):
        # Initialize buckets for each possible weight up to 'limit'
        buckets = [0] * (limit + 1)
        for weight in people:
            buckets[weight] += 1
        
        start, end = 0, limit
        boats = 0
        
        while start <= end:
            # Move start to the next weight with remaining people
            while start <= end and buckets[start] <= 0:
                start += 1
            
            # Move end to the previous weight with remaining people
            while start <= end and buckets[end] <= 0:
                end -= 1
            
            # Check if there are no more people to process
            if buckets[start] <= 0 and buckets[end] <= 0:
                break
            
            # Use one boat
            boats += 1
            
            # If the lightest and the heaviest person can share a boat
            if start + end <= limit:
                buckets[start] -= 1
            
            # Always decrease the count for the heaviest person
            buckets[end] -= 1

        return boats
