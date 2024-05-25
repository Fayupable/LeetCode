class Solution(object):
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        n1, n2 = len(num1), len(num2)
        res = [0] * (n1 + n2)
        for i in range(n1-1, -1, -1):
            for j in range(n2-1, -1, -1):
                mul = (ord(num1[i]) - ord('0')) * (ord(num2[j]) - ord('0'))
                p1, p2 = i + j, i + j + 1
                total = mul + res[p2]
                res[p2] = total % 10
                res[p1] += total // 10
        while len(res) > 1 and res[0] == 0:
            res.pop(0)
        return ''.join(map(str, res))
    


'''
class Solution(object):
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        s=int(num1)
        s2=int(num2)
        return str(s*s2)

        
'''
'''
class Solution(object):
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        a= int(num1) * int(num2)
        return str(a)
'''