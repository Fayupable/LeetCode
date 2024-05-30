class Solution(object):
    def countTriplets(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        n=len(arr)
        prefix=[0]*(n+1)
        for i in range(n):
            prefix[i+1]=prefix[i]^arr[i]
        count=0
        for i in range(n):
            for k in range(i+1,n):
                if prefix[i]==prefix[k+1]:
                    count+=(k-i)
        return count
    


'''
class Solution:
    def countTriplets(self, arr: List[int]) -> int:
        
        pre = []
        p = 0
        res = 0
        n = len(arr)

        for i in arr:
            p ^= i
            pre.append(p)

        for i in range(n):
            for k in range(i + 1, n):
                # print(i, k, pre[k] - (pre[i - 1] if i > 0 else 0))
                if pre[k] - (pre[i - 1] if i > 0 else 0) == 0:
                    res += k - i

        
        return res
'''
'''
class Solution(object):
    def countTriplets(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        n = len(arr)  # Get the length of the array
        prefix = [0] * (n + 1)  # Initialize the prefix array

        # Compute the prefix XOR of the array
        for i in range(n):
            prefix[i + 1] = prefix[i] ^ arr[i]

        count = 0  # Initialize the count of triplets

        # Iterate over the array to find triplets
        for i in range(n):
            for k in range(i + 1, n):
                # If the XOR of the prefix array at indices i and k+1 is equal
                if prefix[i] == prefix[k + 1]:
                    # Increment the count by the difference of k and i
                    count += (k - i)

        return count  # Return the count of triplets
'''

'''
fastest solution
class Solution:
    def countTriplets(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        n = len(arr)
        prefix = 0
        count = 0
        prefix_count = {0: 1}  # Initialize with 0 having one count
        prefix_sum = {0: 0}    # Initialize with sum of indices for prefix 0 as 0

        for i in range(n):
            prefix ^= arr[i]

            if prefix in prefix_count:
                count += prefix_count[prefix] * i - prefix_sum[prefix]

            if prefix in prefix_count:
                prefix_count[prefix] += 1
                prefix_sum[prefix] += (i + 1)
            else:
                prefix_count[prefix] = 1
                prefix_sum[prefix] = (i + 1)

        return count
'''