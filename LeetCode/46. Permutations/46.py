class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        def backtrack(start, end):
            if start == end:
                results.append(nums[:])
            for i in range(start, end):
                nums[start], nums[i] = nums[i], nums[start]
                backtrack(start + 1, end)
                nums[start], nums[i] = nums[i], nums[start]

        results = []
        backtrack(0, len(nums))
        return results
    

    '''
    class Solution(object):
    def permute(self, nums):
        def permutations(p, nums):
            if not nums: 
                return [p[:]] 
            result = []
            for i in range(len(p) + 1):
                f = p[:i]
                s = p[i:]
                perms = permutations(f + [nums[0]] + s, nums[1:]) 
                result.extend(perms) 
            return result
        
        return permutations([], nums)
                
    
    '''

    '''
    class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        def backtrack(start, end):
            if start == end:
                results.append(nums[:])
            for i in range(start, end):
                nums[start], nums[i] = nums[i], nums[start]
                backtrack(start + 1, end)
                nums[start], nums[i] = nums[i], nums[start]

        results = []
        backtrack(0, len(nums))
        return results
    '''
'''
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:

        res = list()
        # base case: if only one element is left in array
        if len(nums)==1:
            return [nums[:]]

        for i in range(len(nums)):
            # take the first element of the array and try combinations on the remaining
            n = nums.pop(0)
            perms = self.permute(nums)

            for perm in perms:
                perm.append(n)
            res.extend(perms)
            # put back the first element at last, so now 2nd element will be first 
            # and will be considered in the next iteration
            nums.append(n)

        return res

        # def permSwap(idx, arr):
        #     if idx == len(nums):
        #         res.append(arr[:])
        #         return
            
        #     for i in range(idx, len(nums)):
        #         arr[i], arr[idx] = arr[idx],arr[i]
        #         permSwap(idx+1, arr)
        #         arr[i], arr[idx] = arr[idx],arr[i]

        # res = list()
        # permSwap(0, nums)
        # return res

        # def recursivePermute(ds, map):
        #     # if all nums have been selected append it to result
        #     if len(ds) == len(nums):
        #         res.append(ds[:])
        #         return
            
        #     for i in range(len(nums)):
        #         # if the current element has not been picked in the ds
        #         if not map[i]:
        #             # pick the element and add it to ds
        #             map[i] = True
        #             ds.append(nums[i])
        #             # then pass the updated ds 
        #             recursivePermute(ds,map)
        #             # once it returns remove the added element to check for other cases
        #             ds.pop()
        #             map[i] = False

        # res = list()
        # ds = list()
        # map = [False for _ in range(len(nums))]
        # recursivePermute(ds, map)
        # return res
'''