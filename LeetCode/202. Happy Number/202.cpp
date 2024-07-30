class Solution {
public:
    bool isHappy(int n) {
        unordered_set<int> s;
        while (n != 1) {
            if (s.find(n) != s.end()) {
                return false;
            }
            s.insert(n);
            int sum = 0;
            while (n) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
        }
        return true;
        
    }
};
//other people's solution
/*
  class Solution {
  public:
      bool isHappy(int n) {
          std::unordered_map <int, int> mp;
          unsigned long sum = 0;
          while (true)
          {
              while (n > 0)
              {
                  sum += (n % 10)* (n % 10);
                  n /= 10;
              }
              if (sum == 1)
                  break;
              else if (mp[sum])
                  return false;
                n = sum;
                mp[sum]++;
                sum = 0;
          }
          return true;
      }
  };
*/