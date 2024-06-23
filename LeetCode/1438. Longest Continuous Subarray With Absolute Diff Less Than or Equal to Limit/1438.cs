using System;
using System.Collections.Generic;

public class Solution {
    public int LongestSubarray(int[] nums, int limit) {
        // LinkedLists to store the indices of the minimum and maximum values in the window
        LinkedList<int> maxDeque = new LinkedList<int>();
        LinkedList<int> minDeque = new LinkedList<int>();
        int start = 0, maxLength = 0;

        for (int end = 0; end < nums.Length; end++) {
            // Maintain the maxDeque
            while (maxDeque.Count > 0 && nums[maxDeque.Last.Value] <= nums[end]) {
                maxDeque.RemoveLast();
            }
            maxDeque.AddLast(end);

            // Maintain the minDeque
            while (minDeque.Count > 0 && nums[minDeque.Last.Value] >= nums[end]) {
                minDeque.RemoveLast();
            }
            minDeque.AddLast(end);

            // Ensure the current window satisfies the condition
            while (nums[maxDeque.First.Value] - nums[minDeque.First.Value] > limit) {
                if (maxDeque.First.Value == start) {
                    maxDeque.RemoveFirst();
                }
                if (minDeque.First.Value == start) {
                    minDeque.RemoveFirst();
                }
                start++;
            }

            // Update the maximum length of the subarray
            maxLength = Math.Max(maxLength, end - start + 1);
        }

        return maxLength; // Return the size of the longest subarray
    }

    public static void Main(string[] args) {
        var solution = new Solution();
        int[] nums = {10, 1, 2, 4, 7, 2};
        int limit = 5;
        Console.WriteLine(solution.LongestSubarray(nums, limit)); // Expected output: 4
    }
}
//other people's solutions
/*
public class Solution {
    public int LongestSubarray(int[] nums, int limit) {
        Dequeue minQueue = new Dequeue();
        Dequeue maxQueue = new Dequeue();
        int ans = 0;
        int j = 0;
        for(int i = 0; i < nums.Length; i++) {
            while(minQueue.Count() > 0 && nums[minQueue.PeekBack()] >= nums[i]) minQueue.DequeueBack();
            minQueue.EnqueueBack(i);
            
            while(maxQueue.Count() > 0 && nums[maxQueue.PeekBack()] <= nums[i]) maxQueue.DequeueBack();
            maxQueue.EnqueueBack(i);
            
            if(nums[maxQueue.PeekFront()] - nums[minQueue.PeekFront()] > limit) {
                j++;
                
                if(j > minQueue.PeekFront()) minQueue.DequeueFront();
                if(j > maxQueue.PeekFront()) maxQueue.DequeueFront();
            }
            else {
                ans = Math.Max(ans, i - j + 1);
            }
        }
        
        return ans;
    }
}

public class Dequeue {
    int idx;
    List<int> nums;
    
    public Dequeue() {
        idx = 0;
        nums = new List<int>();
    }
    
    public void EnqueueBack(int num) {
        nums.Add(num);
    }
    
    public void DequeueBack() {
        nums.RemoveAt(nums.Count-1);
    }
    
    public void DequeueFront() {
        idx++;
    }
    
    public int Count() {
        return nums.Count - idx;
    }
    
    public int PeekBack() {
        return nums[^1];
    }
    
    public int PeekFront() {
        return nums[idx];
    }
}
*/

/*
public class Solution {
    public int LongestSubarray(int[] nums, int limit) {
        // TODO: 2 deque
        // use deque where it stores indexes, first item is largest
        // each iteration, compares with the largest so far
        // if nums[i] - deque[0] > limit, maxLength=0
        // else maxLength++
        var minDeque = new LinkedList<int>();
        var maxDeque = new LinkedList<int>();
        var curMaxLength = 0;
        var maxLength = 0;
        // [8,2,4,7]
        //      i
        // deque = [0,2]
        // limit = 4
        // diff = 8-2
        // curMaxLength = 1
        // maxLength = 1
        int i=0;
        for(int j=0;j<nums.Length;j++){
            while(maxDeque.Count>0 && nums[maxDeque.Last.Value] < nums[j]){
                maxDeque.RemoveLast();
            }
            maxDeque.AddLast(j);
            while(minDeque.Count>0 && nums[minDeque.Last.Value] > nums[j]){
                minDeque.RemoveLast();
            }
            minDeque.AddLast(j);

            while(nums[maxDeque.First.Value] - nums[minDeque.First.Value] > limit){
                if(maxDeque.First.Value == i) {
                    maxDeque.RemoveFirst();
                }
                if(minDeque.First.Value == i) {
                    minDeque.RemoveFirst();
                }
                i++; // shrink right
            }
            maxLength = Math.Max(maxLength, j - i + 1);
        }
        return maxLength;
    }
}
*/


/*
public class Solution {
   private class Deq
{
    private int[] store;
    private int length;
    private int head;
    private int _size;

    public Deq(int size)
    {
        store = new int[size];
        _size = size;
    }

    public void SetFront(int val)
    {
        store[0] = val;
        head = 0;
        length = 1;
    }

    public void AddBack(int val)
    {
        length++;
        store[(head + length - 1)%_size] = val;
    }

    public int PeekFront()
    {
        if (length == 0)
        {
            throw new Exception();
        }

        return store[head%_size];
    }

    public int PopFront()
    {
        if (length == 0)
        {
            throw new Exception();
        }

        head++;
        length--;
        return store[(head - 1)%_size];
    }

    public int PeekBack()
    {
        if (length == 0)
        {
            throw new Exception();
        }

        return store[(head + length - 1)%_size];
    }

    public int PopBack()
    {
        if (length == 0)
        {
            throw new Exception();
        }

        length--;
        return store[(head + length)%_size];
    }

    public int Count()
    {
        return length;
    }
}

public int LongestSubarray(int[] nums, int limit)
{
    var max = new Deq(nums.Length);
    var min = new Deq(nums.Length);
    var i = 0;
    var j = 0;
    var result = 1;
    while (i < nums.Length && j < nums.Length)
    {
        if (max.Count() == 0 || nums[j] >= nums[max.PeekFront()] )
        {
            max.SetFront(j);
        }
        else
        {
            while (nums[max.PeekBack()] < nums[j])
            {
                max.PopBack();
            }

            max.AddBack(j);
        }

        if (min.Count() == 0 || nums[j] <= nums[min.PeekFront()])
        {
            min.SetFront(j);
        }
        else
        {
            while (nums[min.PeekBack()] > nums[j])
            {
                min.PopBack();
            }

            min.AddBack(j);
        }
        if (Math.Abs(nums[max.PeekFront()] - nums[min.PeekFront()]) <= limit)
        {
            if (j - i + 1 > result)
            {
                result = j - i + 1;
            }
        }
        else
        {
            while (Math.Abs(nums[max.PeekFront()] - nums[min.PeekFront()]) > limit)
            {
                var d = max.PeekFront() < min.PeekFront() ? max : min;
                i = d.PopFront() + 1;
            }
        }

        j++;
    }

    return result;
}
}
*/