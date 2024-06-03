class Solution(object):
    def toLowerCase(self, s):
        """
        :type s: str
        :rtype: str
        """
        return s.lower()  # Convert all characters in s to lowercase and return the result
    

    '''
    class Solution(object):
    def toLowerCase(self, s):
        """
        :type s: str
        :rtype: str
        """
        res = ""
        for i in s:
            if i == i.upper():
                i = i.lower()
                res += i
            else:
                res += i

        return res
    '''
    '''
    class Solution(object):
    def toLowerCase(self, s):
        """
        :type s: str
        :rtype: str
        """

        arr = list(s)
        for i in range(len(arr)):
            if ord(arr[i]) <= ord("Z") and ord(arr[i]) >= ord("A"):
                arr[i] = chr(ord(arr[i]) + 32) # 32 = diff between lwr and uppr case of any letter
                # add 32 you'll get lower of that same upper
        return "".join(arr)

        # return s.lower() or lower(s)
    '''
    '''
    class Solution(object):
    def toLowerCase(self, s):
        """
        :type s: str
        :rtype: str
        """
        s2 = ''
        for i in range(len(s)):
            if 65 <= ord(s[i]) <= 90:
                s2 += chr(ord(s[i])+32)
            else:
                s2 += s[i]

        return s2
        
    '''