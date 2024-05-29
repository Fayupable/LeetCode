class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;

        // Start from the least significant bit and move towards the most significant bit
        for (int i = s.length() - 1; i > 0; --i) {
            if ((s.charAt(i) - '0' + carry) % 2 == 0) {
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
}

/*
 * Time complexity: O(n)
 * class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;

        // Start from the least significant bit and move towards the most significant bit
        for (int i = s.length() - 1; i > 0; --i) {
            if ((s.charAt(i) - '0' + carry) % 2 == 0) {
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
}
 */

 /*
    * Time complexity: O(n)
  * class Solution {

    private void divideByTwo(StringBuilder s) {
        s.deleteCharAt(s.length() - 1);
    }

    private void addOne(StringBuilder s) {
        int i = s.length() - 1;

        // Iterating while the character is 0
        while (i >= 0 && s.charAt(i) != '0') {
            s.setCharAt(i, '0');
            i--;
        }

        if (i < 0) {
            s.insert(0, '1');
        } else {
            s.setCharAt(i, '1');
        }
    }

    public int numSteps(String s) {
        StringBuilder str = new StringBuilder(s);

        int operations = 0;
        while (str.length() > 1) {
            int N = str.length();

            if (str.charAt(N - 1) == '0') {
                divideByTwo(str);
            } else {
                addOne(str);
            }

            operations++;
        }

        return operations;
    }
}
  */

  /*
   * import java.math.BigInteger;
   * Time complexity: O(n)

class Solution {
    public int numSteps(String s) {
        int steps = 0;
        BigInteger num = new BigInteger(s, 2);  // convert binary string to BigInteger
        while (!num.equals(BigInteger.ONE)) {
            if (num.testBit(0)) {  // if the number is odd
                // count the number of consecutive 1's at the end
                int count = 0;
                while (num.testBit(0)) {
                    num = num.shiftRight(1);
                    count++;
                }
                num = num.add(BigInteger.ONE);  // add 1 to the number
                steps += count + 1;  // add the count of consecutive 1's to the steps
            } else {  // if the number is even
                num = num.shiftRight(1);
                steps++;
            }
        }
        return steps;
    }
}
   */

   /*
   class Solution {
public int numSteps(String s) {

	HashMap<String, Integer> cache = new HashMap<>();
	
	return dfs(s, cache);
	
}

private int dfs(String s, HashMap<String, Integer> cache) {
	if ("1".equals(s)) {
		return 0;
	}
	
	if (cache.containsKey(s)) {
		return cache.get(s); 
	}
	
	StringBuilder sb = new StringBuilder();
	if (s.charAt(s.length() - 1) == '1') {
		int carry = 1;
		for (int i = s.length() - 1; i >= 0; i --) {
			int sum = (s.charAt(i) - '0') + carry;
			carry = sum / 2;
			sum = sum % 2;
			sb.append(sum);
		}
		if (carry != 0) {
			sb.append(carry);
		}
		sb.reverse();
	} else {
		sb.append(s);
		sb.deleteCharAt(sb.length() - 1);
	}
	
	int result = dfs(sb.toString(), cache);
	
	return result + 1;
	
	
}
}
    
    */