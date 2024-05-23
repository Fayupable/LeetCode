# class Solution:
#     def dfs(self, nums: List[int], idx: int, k: int, mp: defaultdict) -> int:
#         if idx == len(nums):
#             return 1

#         taken = 0
#         if mp[nums[idx] - k] == 0 and mp[nums[idx] + k] == 0:
#             mp[nums[idx]] += 1
#             taken = self.dfs(nums, idx + 1, k, mp)
#             mp[nums[idx]] -= 1
        
#         notTaken = self.dfs(nums, idx + 1, k, mp)
        
#         return taken + notTaken

#     def beautifulSubsets(self, nums: List[int], k: int) -> int:
#         mp = defaultdict(int)
#         ans = self.dfs(nums, 0, k, mp)
#         return ans - 1

from collections import defaultdict

class Solution(object):
    def dfs(self, nums, idx, k, mp):
        if idx == len(nums):
            return 1

        taken = 0
        if mp[nums[idx] - k] == 0 and mp[nums[idx] + k] == 0:
            mp[nums[idx]] += 1
            taken = self.dfs(nums, idx + 1, k, mp)
            mp[nums[idx]] -= 1
        
        notTaken = self.dfs(nums, idx + 1, k, mp)
        
        return taken + notTaken

    def beautifulSubsets(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        mp = defaultdict(int)
        ans = self.dfs(nums, 0, k, mp)
        return ans - 1

# Example usage:
sol = Solution()
nums = [1, 2, 3, 4]
k = 2
print(sol.beautifulSubsets(nums, k))  # Example output
