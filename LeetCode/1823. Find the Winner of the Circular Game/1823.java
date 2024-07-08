class Solution {
    public int findTheWinner(int n, int k) {
        /*
         * Input: n = 5, k = 2
         * Output: 3
         * Explanation: Here are the steps of the game:
         * 1) Start at friend 1.
         * 2) Count 2 friends clockwise, which are friends 1 and 2.
         * 3) Friend 2 leaves the circle. Next start is friend 3.
         * 4) Count 2 friends clockwise, which are friends 3 and 4.
         * 5) Friend 4 leaves the circle. Next start is friend 5.
         * 6) Count 2 friends clockwise, which are friends 5 and 1.
         * 7) Friend 1 leaves the circle. Next start is friend 3.
         * 8) Count 2 friends clockwise, which are friends 3 and 5.
         * 9) Friend 5 leaves the circle. Only friend 3 is left, so they are the winner.
         * Example 2:
         * 
         * Input: n = 6, k = 5
         * Output: 1
         * Explanation: The friends leave in this order: 5, 4, 6, 2, 3. The winner is
         * friend 1.
         */
        //Create a list of friends
        List<Integer> friends = new ArrayList<>();
        //Add friends to the list
        for (int i = 1; i <= n; i++) {
            friends.add(i);
        }
        //Index to keep track of the friend to be removed
        int index = 0;
        //Loop through the friends list and remove the friend at the index
        while (friends.size() > 1) {
            //Calculate the index of the friend to be removed
            index = (index + k - 1) % friends.size();
            //Remove the friend at the index
            friends.remove(index);
        }
        //Return the last friend in the list
        return friends.get(0);

    }
}
/*
 * class Solution {
 * public int findTheWinner(int n, int k) {
 * if(n==1) return 1;
 * return (findTheWinner(n-1,k)+k-1)%n+1;
 * }
 * }
 */
/*
 * class Solution {
 * public int findTheWinner(int n, int k) {
 * 
 * // List<Integer> nums = new ArrayList<>();
 * // for(int i=0; i<n; i++) {
 * // nums.add(i+1);
 * // }
 * 
 * // int index = k - 1;
 * // while(nums.size() != 1) {
 * // nums.remove(index);
 * // index = (index + k - 1) % nums.size();
 * // }
 * //removeElement(nums, k - 1, k);
 * 
 * //return nums.get(0);
 * 
 * if(n == 1) {
 * return 1;
 * }
 * 
 * int result = findTheWinner(n - 1, k) + k;
 * 
 * return result % n == 0 ? n : result % n;
 * }
 * 
 * 
 * 
 * private void removeElement(List<Integer> nums, int index, int k) {
 * 
 * if(nums.size() == 1) {
 * return;
 * }
 * 
 * nums.remove(index);
 * removeElement(nums, (index + k - 1) % nums.size(), k);
 * }
 * }
 */

/*
 * class Solution {
 * public int findTheWinner(int n, int k)
 * {
 * ArrayList<Integer> al = new ArrayList<>();
 * for(int i = 1 ;i<=n;i++)
 * al.add(i);
 * return helper(al,k,0);
 * }
 * public int helper(ArrayList<Integer> al,int k , int index)
 * {
 * if(al.size()==1)
 * return al.get(0);
 * 
 * 
 * index = (index+k-1)%al.size();
 * al.remove(index);
 * return helper(al,k,index);
 * 
 * }
 * }
 */