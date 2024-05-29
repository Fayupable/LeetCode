class Solution(object):
    def numSteps(self, s):
        """
        :type s: str
        :rtype: int
        """
        steps = 0
        carry = 0

        # Start from the least significant bit and move towards the most significant bit
        for i in range(len(s) - 1, 0, -1):
            if (int(s[i]) + carry) % 2 == 0:
                # If the current digit + carry is even, divide by 2 (equivalent to moving to the next bit)
                steps += 1
            else:
                # If the current digit + carry is odd, add 1 (which might create a carry)
                steps += 2  # One step for making it even and one step for division
                carry = 1

        # Finally, handle the most significant bit
        return steps + carry
    
'''
class Solution(object):
    def numSteps(self, s):
        """
        :type s: str
        :rtype: int
        """
        res=0
        number = 0
        pow = 1
        for i in range(len(s)-1, -1, -1):
            if s[i] == '1':
                number +=pow  
            pow *= 2
        print(number)
        while not number == 1:
            res += 1
            if number %2 ==0 :
                number = number //2
            else:
                number = number +1
            
        return res
'''
'''
class Solution(object):
    def numSteps(self, s):
        """
        :type s: str
        :rtype: int
        """
        res = 0
        stack = list(s)
        carry = 0


        while len(stack) != 1:
            curr = stack.pop()

            if curr == '0' and not carry:
                res += 1
            elif curr == '1' and not carry:
                carry =1
                res += 2
            elif curr=='0' and carry:
                res += 2
            else:
                res +=1
        if stack[0] == '1' and carry:
            res += 1

        return res
'''
'''
class Solution(object):
    def numSteps(self, s):
        return len(s) + s.rstrip('0').count('0') + 2 * (s.count('1') != 1) - 1 
        
'''
'''
class Solution(object):
    def numSteps(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = int(s, 2)
        ans = 0

        while n != 1:
            ans += 1

            if n&1:
                n += 1
            else:
                n //= 2
        return ans
             
'''
'''
python3
class Solution:
    def numSteps(self, s: str) -> int:
        steps = 0
        carry = 0

        # Start from the least significant bit and move towards the most significant bit
        for i in range(len(s) - 1, 0, -1):
            if (int(s[i]) + carry) % 2 == 0:
                # If the current digit + carry is even, divide by 2 (equivalent to moving to the next bit)
                steps += 1
            else:
                # If the current digit + carry is odd, add 1 (which might create a carry)
                steps += 2  # One step for making it even and one step for division
                carry = 1

        # Finally, handle the most significant bit
        return steps + carry
'''

'''
class Solution:
    def numSteps(self, s: str) -> int:
        c = 0
        target = int(s, 2)

        while target != 1:
            c+=1
            if target%2 == 0:
                target = target//2
            else:
                target += 1
        return c
'''