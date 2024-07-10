class Solution {
    public int minOperations(String[] logs) {
      // Initialize a variable to keep track of the current depth relative to the main folder.
      int depth = 0;
      // Iterate through each log entry in the logs array.
      for (String log : logs) {
          // Check if the current log entry is "../", which means moving up to the parent folder.
          if (log.equals("../")) {
              // If depth is greater than 0, decrement depth to move up one level.
              if (depth > 0) {
                  depth--;
              }
          } 
          // Check if the log entry is not "./", which means it's a move to a child folder.
          else if (!log.equals("./")) {
              // Increment depth as moving to a child folder increases the depth.
              depth++;
          }
      }
      // Return the final depth value, which represents the minimum number of operations needed to return to the main folder.
      return depth;
  }
}
//other people's solution

/*
 * class Solution {
 * public int minOperations(String[] logs) {
 * int res = 0;
 * for (String log: logs) {
 * res += add(log,res);
 * }
 * return res;
 * }
 * private int add(String log, int res) {
 * return log.charAt(1) == '.' ? res == 0 ? 0 : -1 : log.charAt(0) == '.' ? 0 :
 * 1;
 * }
 * 
 * }
 * 
 * /* Own Solution 1 :
 * int res = 0;
 * for(String log : logs){
 * if(log.equals("../")){
 * if(res == 0)
 * continue;
 * else
 * res--;
 * }
 * else if(log.equals("./"))
 * continue;
 * else
 * res++;
 * }
 * return res;
 */
*/