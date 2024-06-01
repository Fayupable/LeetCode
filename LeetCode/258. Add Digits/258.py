class Solution(object):
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        
        if num == 0:
            return 0
        else:
            return 1 + (num - 1) % 9
        
'''
class Solution(object):
    def addDigits(self, num):
        while num>=10:
            sum=0
            while num>0:
                r=num%10
                sum=sum+r
                num=num//10
            num=sum
        return num

            
'''

'''
class Solution:
  def addDigits(self, num: int) -> int:
    return 0 if num == 0 else 1 + (num - 1) % 9
'''