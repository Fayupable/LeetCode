class Solution
{
public:
    bool isIsomorphic(string s, string t)
    {
        unordered_map<char, char> m1, m2;
        for (int i = 0; i < s.size(); i++)
        {
            if (m1.find(s[i]) == m1.end())
            {
                m1[s[i]] = t[i];
            }
            else if (m1[s[i]] != t[i])
            {
                return false;
            }
            if (m2.find(t[i]) == m2.end())
            {
                m2[t[i]] = s[i];
            }
            else if (m2[t[i]] != s[i])
            {
                return false;
            }
        }
        return true;
    }
};
//other people's solution

/*
class Solution {
public:
    bool isIsomorphic(string s, string t) {
        int n1 = s.size();
        int n2 = t.size();
        if(n1!=n2){
            return false;
        }else{
            unordered_map <char,char> mp1;
            unordered_map <char,char> mp2;
            for(int i=0; i<n1; i++){
                if(mp1.find(s[i])==mp1.end()){
                    mp1[s[i]] = t[i];
                }else{
                    if(mp1[s[i]]!=t[i]){
                        return false;
                    }
                }
            }
            for(int i=0; i<n2; i++){
                if(mp2.find(t[i])==mp2.end()){
                    mp2[t[i]] = s[i];
                }else{
                    if(mp2[t[i]]!=s[i]){
                        return false;
                    }
                }
            }
            return true;
        }
    }
};*/