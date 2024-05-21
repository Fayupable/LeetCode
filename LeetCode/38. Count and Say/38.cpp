class Solution {
public:
    string countAndSay(int n) {
        string s = "1";
        for(int i = 1; i < n; i++){
            s = countIdx(s);
        }
        return s;
    }
    
private:
    string countIdx(string s){
        string result = "";
        char repeat = s[0];
        int count = 1;
        for(int i = 1; i < s.length(); i++){
            if(s[i] == repeat){
                count++;
            } else {
                result += to_string(count) + repeat;
                count = 1;
                repeat = s[i];
            }
        }
        result += to_string(count) + repeat;
        return result;
    }
};
/*
class Solution {
 public:
  string countAndSay(int n) {
    string ans = "1";

    while (--n) {
      string next;
      for (int i = 0; i < ans.length(); ++i) {
        int count = 1;
        while (i + 1 < ans.length() && ans[i] == ans[i + 1]) {
          ++count;
          ++i;
        }
        next += to_string(count) + ans[i];
      }
      ans = move(next);
    }

    return ans;
  }
};
        
    
*/