class Solution {
public:
    int equalSubstring(string s, string t, int maxCost) {
        // Calculate the absolute difference between ASCII values of characters in s and t
        vector<int> diff(s.size());
        for (int i = 0; i < s.size(); ++i) {
            diff[i] = abs(s[i] - t[i]);
        }
        
        // Initialize the left pointer of the sliding window
        int left = 0;
        
        // Iterate over the diff vector with the right pointer
        for (int right = 0; right < diff.size(); ++right) {
            // Subtract the current diff value from maxCost
            maxCost -= diff[right];
            
            // If maxCost is less than 0, move the left pointer to the right and add the diff value at the left pointer to maxCost
            if (maxCost < 0) {
                maxCost += diff[left];
                left += 1;
            }
        }
        
        // Return the maximum length of a substring that can be changed to be the same as the corresponding substring of t with a cost less than or equal to maxCost
        return diff.size() - left;
    }
};

/*
vector<int> diff(s.size()); - This line initializes a vector of size s.size(). The time complexity for this operation is O(n), where n is the size of the string s.

The for loop for (int i = 0; i < s.size(); ++i) - This loop runs n times, and inside the loop, we're performing a constant time operation (calculating the absolute difference and assigning it to diff[i]). So, the time complexity for this loop is O(n).

The for loop for (int right = 0; right < diff.size(); ++right) - This loop also runs n times. Inside the loop, we're performing constant time operations (subtracting diff[right] from maxCost and possibly adding diff[left] to maxCost and incrementing left). So, the time complexity for this loop is also O(n).

return diff.size() - left; - This is a constant time operation, so its time complexity is O(1).

When you add up all these operations, the overall time complexity is O(n) + O(n) + O(n) + O(1), which simplifies to O(n) because in Big O notation, we only care about the highest order term and constants are ignored.
*/

/*
time complexity: O(n)
class Solution {
public:
    int equalSubstring(string s, string t, int maxCost) {
        int n = s.size();
        vector<int> nums(n, 0);
        for(int i = 0; i < n; i++)
            nums[i] = abs(s[i] - t[i]);
        int start = 0, end = 0;
        int ans = 0;
        int sum = 0;
        while(end < n) {
            sum += nums[end];
            while(start <= end && sum > maxCost) {
                sum -= nums[start];
                start++;
            }
            ans = max(ans, end - start + 1);
            end++;
        }
        return ans;
    }
};
*/