from typing import List

class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        def backtrack(start, end):
            if start == end:
                results.append(nums[:])
                return
            seen = set()
            for i in range(start, end):
                if nums[i] in seen:
                    continue
                seen.add(nums[i])
                nums[start], nums[i] = nums[i], nums[start]
                backtrack(start + 1, end)
                nums[start], nums[i] = nums[i], nums[start]

        nums.sort()
        results = []
        backtrack(0, len(nums))
        return results
    


'''

class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        def backtrack(start, end):
            if start == end:
                results.append(nums[:])
                return
            seen = set()
            for i in range(start, end):
                if nums[i] in seen:
                    continue
                seen.add(nums[i])
                nums[start], nums[i] = nums[i], nums[start]
                backtrack(start + 1, end)
                nums[start], nums[i] = nums[i], nums[start]

        nums.sort()
        results = []
        backtrack(0, len(nums))
        return results
'''

'''
def permute(nums):
    result = []
    if len(nums) == 1:
        return [nums[:]]

    for iteration in range(len(nums)):
        pivot = nums.pop(0)
        permutations = permute(nums)
        
        for permutation in permutations:
            permutation.append(pivot)
            
        result.extend(permutations)
        
        nums.append(pivot)

    return result

class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        results = permute(nums)
        results_unique = []
        unique = {}

        for result in results:
            result_tuple = tuple(result)

            if result_tuple not in unique:
                unique[result_tuple] = result
                

        #print(unique)
        for key, value in unique.items():
            results_unique.append(value)

        return results_unique
'''