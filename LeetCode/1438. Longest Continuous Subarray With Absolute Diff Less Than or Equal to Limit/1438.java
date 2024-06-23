import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        // Deques to store the indices of the minimum and maximum values in the window
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        int start = 0, maxLength = 0;

        for (int end = 0; end < nums.length; end++) {
            // Maintain the maxDeque and minDeque
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[end]) {
                maxDeque.pollLast();
            }
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[end]) {
                minDeque.pollLast();
            }
            maxDeque.offerLast(end);
            minDeque.offerLast(end);

            // Ensure the current window satisfies the condition
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                if (maxDeque.peekFirst() == start) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() == start) {
                    minDeque.pollFirst();
                }
                start++;
            }

            // Update the maximum length of the subarray
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength; // Return the size of the longest subarray
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {10, 1, 2, 4, 7, 2};
        int limit = 5;
        System.out.println(solution.longestSubarray(nums, limit)); // Expected output: 4
    }
}

//other people's solution

/*
 class Solution {

    // maitain max val of cur slide window in head of deque
    static int[] maxDeque ;
    static int[] minDeque;
    static int maxHead;
    static int maxTail;
    static int minHead;
    static int minTail;

    // maintain min val of cur silde window in head of deque
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        maxDeque = new int[n];
        minDeque = new int[n];

        // queue range [h,t)
        maxHead=0;
        maxTail=0;
        minHead=0;
        minTail=0;

        // take each num in nums as start of slide window
        // get max len of window with any two elements in window is less than or equal to limit.

        int res =0;
        int r=0;
        for(int l =0;l<n;l++){

            // window is [l,r), check if add r to window still meet condition
            while(r<n&&withinLimit(nums,nums[r],limit)){
                addToLast(nums,r);
                r++;
            }
            // [l,r) is max len of a valid window using l as start 
            res= Math.max(res, r-l);

           removeExpired(l);
        }

        return res;
        
    }

    public boolean withinLimit(int[] nums,int num,int limit){
        int max = maxHead<maxTail?Math.max(nums[maxDeque[maxHead]], num):num;
        int min = minHead<minTail?Math.min(nums[minDeque[minHead]],num):num;

        return max-min<=limit;
    }

    public void addToLast(int[] nums,int r){
        // add to max deque 
        while(maxHead<maxTail&&nums[maxDeque[maxTail-1]]<=nums[r]){
             maxTail--;
        }
        maxDeque[maxTail++]=r;

        // add to min deque
        while(minHead<minTail&&nums[minDeque[minTail-1]]>=nums[r]){
            minTail--;
        }
        minDeque[minTail++]=r;

    }

    public void removeExpired(int l){
        if(maxDeque[maxHead]==l){
            maxHead++;
        }

        if(minDeque[minHead]==l){
            minHead++;
        }
    }

}
 */

 /*
  class Solution {
    class MonotonicQueue{
        LinkedList<Integer> maxq = new LinkedList<>();
        LinkedList<Integer> minq = new LinkedList<>();

        public void push(int val) {
            while (!maxq.isEmpty() && maxq.getLast() < val) {
                maxq.removeLast();
            }
            maxq.addLast(val);

            while (!minq.isEmpty() && minq.getLast() > val) {
                minq.removeLast();
            }
            minq.addLast(val);
        }

        public int max(){
            return maxq.getFirst();
        }
        public int min() {
            return minq.getFirst();
        }

        public void pop(int val) {
            if (maxq.getFirst() == val) {
                maxq.removeFirst();
            }
            if (minq.getFirst() == val) {
                minq.removeFirst();
            }
        }
    }
    public int longestSubarray(int[] nums, int limit) {
        int i=0,j= 0;
        int len = 0, maxLen = 0;
        MonotonicQueue window = new MonotonicQueue();
        while (j<nums.length) {
            window.push(nums[j]);
            j++;
            len++;
            while (window.max()-window.min() > limit) {
                window.pop(nums[i]);
                i++;
                len--;
            }
            // len = j-i
            maxLen = Math.max(maxLen,len);
        }
        return maxLen;
    }
}

  */

  /*
   class Solution {
    public int longestSubarray(int[] nums, int limit) {
        LinkedList<Integer> minq = new LinkedList<>();
        LinkedList<Integer> maxq = new LinkedList<>();
        int res = 0, i = 0;
        for(int j = 0; j < nums.length; j++) {
            while(!minq.isEmpty() && minq.peekLast() > nums[j]) {
                minq.removeLast();
            }
            minq.addLast(nums[j]);
            while(!maxq.isEmpty() && maxq.peekLast() < nums[j]) {
                maxq.removeLast();
            }
            maxq.addLast(nums[j]);
            while(maxq.peekFirst() - minq.peekFirst() > limit) {
                if(maxq.peekFirst() == nums[i]) {
                    maxq.removeFirst();
                }
                if(minq.peekFirst() == nums[i]) {
                    minq.removeFirst();
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
   */
  /*
   class Solution {
    private static class Pair implements Comparable<Pair> {
        int index;
        int value;
        private Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.value == o.value) {
                return this.index - o.index;
            }
            return this.value - o.value;
        }
    }

    public int longestSubarray(int[] nums, int limit) {
        int low = 0, high = 0, answer = 0;
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        while (high < nums.length) {
            min.add(nums[high]);
            max.add(nums[high]);
            if (max.peek() - min.peek() > limit) {
                answer = Math.max(answer, high - low);
                while (max.peek() - min.peek() > limit) {
                    min.remove(nums[low]);
                    max.remove(nums[low]);
                    low++;
                }
            }
            high++;
        }
        return Math.max(answer, high - low);
    }
}
   */