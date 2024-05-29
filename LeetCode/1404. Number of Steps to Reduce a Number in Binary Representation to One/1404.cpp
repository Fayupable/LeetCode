//time complexity: O(n)
class Solution {
public:
    int numSteps(string s) {
        int steps = 0;
        int carry = 0;  // To handle the carry when adding 1

        // Start from the least significant bit and move towards the most significant bit
        //time complexity: O(n-1) -> O(n)
        for (int i = s.size() - 1; i > 0; --i) {
            if ((s[i] - '0' + carry) % 2 == 0) {
                // If the current digit + carry is even, divide by 2 (equivalent to moving to the next bit)
                steps++;
            } else {
                // If the current digit + carry is odd, add 1 (which might create a carry)
                steps += 2;  // One step for making it even and one step for division
                carry = 1;
            }
        }

        // Finally, handle the most significant bit
        return steps + carry;
    }
};

/*
time complexity: O(n)
class Solution {
public:
    int numSteps(string s) {
        // 1 -> 2 -> 4 -> 
        int cur = s.size()-1;
        int res = 0;
        while (cur>0) {
            if (s[cur] == '0') {
                res++;
                cur--;
            }
            else {
                int startOne = cur;
                while (cur >= 0 && s[cur] == '1') {
                    cur--;
                }
                res += (startOne - cur) + 1;
                if (cur>=0) s[cur] = '1';
            }
        }

        return res;
    }
};
*/

/*
class Solution {
public:
    int numSteps(string s) {
        int sol = 0, carry = 0;
        for (int i = s.size()-1; i > 0; i--) {
            sol++;
            if (s[i] + carry == '1') {
                sol++;
                carry = 1;
            }
        }
        return sol + carry;
    }
};
*/