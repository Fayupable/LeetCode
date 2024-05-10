class Solution(object):
    def maximumHappinessSum(self, happiness, k):
        """
        :type happiness: List[int]
        :type k: int
        :rtype: int
        """
        happiness = sorted(happiness, reverse = True)
        happySum = 0
        for i in range(0,k):
            if happiness[i] > i:
                happySum = happySum + happiness[i] - i
            else:
                return happySum
        return happySum