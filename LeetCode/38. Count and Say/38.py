class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        s='1'
        for _ in range(n-1):
            let,temp,count=s[0],'',0
            for l in s:
                if l==let:
                    count+=1
                else:
                    temp+=str(count)+let
                    let=l
                    count=1
            temp+=str(count)+let
            s=temp
        return s
