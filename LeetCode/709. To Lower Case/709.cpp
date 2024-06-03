class Solution {
public:
    string toLowerCase(string s) {
        for(int i=0; i<s.size(); i++){ // Iterate over the characters in the string
            if(s[i] >= 'A' && s[i] <= 'Z'){ // If the current character is an uppercase letter
                s[i] = s[i] + 32; // Convert it to lowercase by adding 32 to its ASCII value
            }
        }
        return s; // Return the modified string
    }
};
/*
class Solution {
public:
    string toLowerCase(string s) {
        transform(s.begin(),s.end(),s.begin(),::tolower);
        return s;
    }
};
*/
/*
class Solution {
public:
    string toLowerCase(string s) {
        string ans;
        for(char ch : s){
            if(ch < 91 && ch > 64){
                char x = ch + 32;
                ans = ans + x;
            }
            else ans = ans + ch;
        }
        return ans;
    }
};
*/
/*
class Solution {
public:
    string toLowerCase(string s) {
        string ans="";
        for(int i=0; i<s.length(); i++) {
           ans+=tolower(s[i]);
        }
        return ans;
    }
};
*/
/*
class Solution {
public:
    string toLowerCase(string s) {
        string k="";
          for(int i=0;i<s.length();i++)
          {
          
            k+=tolower(s[i]);
            
          }
          return k;
    }
};
*/