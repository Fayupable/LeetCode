class Solution(object):
    def compareVersion(self, version1, version2):
        """
        :type version1: str
        :type version2: str
        :rtype: int
        """

        v=version1.split('.')
        v2=version2.split('.')

        for i in range(max(len(v),len(v2))):
            num1= int(v[i]) if i<len(v) else 0
            num2= int(v2[i]) if i<len(v2) else 0

            if num1>num2:
                return 1
            elif num1<num2:
                return -1
        return 0
    
solution = Solution()
print(solution.compareVersion("1.01","1.001")) 
print(solution.compareVersion("1.0","1.0.0")) 
print(solution.compareVersion("0.1","1.1"))
print(solution.compareVersion("1.0.1","1"))
