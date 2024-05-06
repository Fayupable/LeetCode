#include <string>

class Solution {
public:
    std::string addBinary(std::string a, std::string b) {
        std::string result;
        int i = a.size() - 1;
        int j = b.size() - 1;
        int carry = 0;

        // Process each bit from the end of both strings
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a[i] - '0'; // Convert char to integer
                i--;
            }
            if (j >= 0) {
                sum += b[j] - '0';
                j--;
            }

            result.push_back((sum % 2) + '0'); // Convert the remainder to char and add to result
            carry = sum / 2; // Update carry
        }

        // The bits are added to the result in reverse order, so we need to reverse the result
        std::reverse(result.begin(), result.end());

        return result;
    }
};
