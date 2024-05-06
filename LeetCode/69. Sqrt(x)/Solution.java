public class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;  // Handle base cases directly

        long left = 1, right = x / 2;  // Using long to avoid overflow
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long squared = mid * mid;
            if (squared == x) {
                return (int) mid;  // Found exact square root
            } else if (squared < x) {
                left = mid + 1;  // Increase lower bound
            } else {
                right = mid - 1;  // Decrease upper bound
            }
        }

        return (int) right;  // right is the floor of the square root of x
    }
}
