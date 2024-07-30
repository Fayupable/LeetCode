class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int sum = 0;
            while (n != 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
            n = sum;
        }
        return true;

    }

}

//other peoples solution
/*
 * import java.util.LinkedList;
 * class Solution {
 * public boolean isHappy(int n) {
 * int slow = n;
 * int fast = n;
 * do {
 * slow = square(slow);
 * fast = square(square(fast));
 * }
 * while (slow != fast);
 * return slow == 1;
 * }
 * public int square(int num) {
 * int ans = 0;
 * while(num > 0) {
 * int remainder = num % 10;
 * ans += remainder * remainder;
 * num /= 10;
 * }
 * return ans;
 * }
 * }
 */
