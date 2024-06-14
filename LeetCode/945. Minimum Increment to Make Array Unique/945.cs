using System;

public class Solution {
    public int MinIncrementForUnique(int[] nums) {
        HeapSort(nums);
        int moves = 0;
        for (int i = 1; i < nums.Length; i++) {
            if (nums[i] <= nums[i - 1]) {
                moves += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }
        return moves;
    }

    private void HeapSort(int[] nums) {
        int n = nums.Length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            Heapify(nums, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            // Call max heapify on the reduced heap
            Heapify(nums, i, 0);
        }
    }

    private void Heapify(int[] nums, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < n && nums[left] > nums[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < n && nums[right] > nums[largest])
            largest = right;

        // If largest is not root
        if (largest != i) {
            int swap = nums[i];
            nums[i] = nums[largest];
            nums[largest] = swap;

            // Recursively heapify the affected sub-tree
            Heapify(nums, n, largest);
        }
    }
}

/*
public class Solution {
    public int MinIncrementForUnique(int[] nums) {
        Array.Sort(nums);
        int count = 0;

        for (int i = 1; i < nums.Length; i++)
        {
            if (nums[i] == nums[i - 1])
            {
                int diff = 1;
                count += 1;
                nums[i] = nums[i] + diff;
            }
            else if (nums[i] < nums[i - 1])
            {
                int diff = Math.Abs(nums[i] - nums[i - 1]) + 1;
                count += diff;
                nums[i] = nums[i] + diff;
            }
        }

        return count;
    }
}
*/


/*
public class Solution {
    public int MinIncrementForUnique(int[] nums) {
        Array.Sort(nums);
        int left = 0;
        int right = 0;
        int ans = 0;
        while (right < nums.Length)
        {
        //Console.WriteLine(string.Join("-", nums));
            while (right < nums.Length && nums[right]<=nums[left]) 
            {
                ans += nums[left] + right - left - nums[right];
                right++;
            }
            right--;
            if (left == right)
            {
                left++;
                right = left;
            }
            else
            {
                nums[right] = nums[left] + right - left;
                left = right;
            }
            //Console.WriteLine(left + " "+ right+ " "+ans);
        }
        return ans;
        
    }
}
*/
/*
public class Solution {
    public int MinIncrementForUnique(int[] nums) {
        Array.Sort(nums);

        int result = 0;
        int previous = nums[0];
        for (int i = 1; i < nums.Length; i++) {
            if (nums[i] <= previous) {
                result += previous - nums[i] + 1;
                previous++;
            }
            else
                previous = nums[i];
        }

        return result;
    }
}
*/
/*
public class Solution {
    public int MinIncrementForUnique(int[] nums) {
        int ans = 0;
List<int> khaliSlot = [];
List<int> duplicates = [];
Array.Sort(nums);
int last = nums[nums.Length - 1];
for (int i = 0; i < nums.Length - 1; i++)
{
    if (nums[i] == nums[i + 1])
    {
        duplicates.Add(nums[i]);
    }
    if (nums[i + 1] - nums[i] > 1)
    {
        for (int j = nums[i] + 1; j < nums[i + 1]; j++)
            khaliSlot.Add(j);
    }
}
int khaliSlotUsed = 0;


for (int i = 0; i < duplicates.Count; i++)
{
    while(khaliSlot.Count > khaliSlotUsed && khaliSlot[khaliSlotUsed] < duplicates[i])
    {
        khaliSlotUsed++;
    }
    if (khaliSlot.Count > khaliSlotUsed && khaliSlot[khaliSlotUsed] > duplicates[i])
    {
        ans += khaliSlot[khaliSlotUsed] - duplicates[i];
        khaliSlotUsed++;
    }
    else
    {
        ans += last + 1 - duplicates[i];
        last++;
    }
}


return ans;

    }
}
*/

/*
public class Solution {
    public int MinIncrementForUnique(int[] A) {
    Array.Sort(A);
    int moves = 0, needed = 0;

    foreach (int num in A) {
        moves += Math.Max(needed - num, 0);
        needed = Math.Max(needed, num) + 1;
    }

    return moves;
}

}
*/
/*
public class Solution {
    public int MinIncrementForUnique(int[] nums) {
        var mem = new bool[100001+nums.Length];
        int count = 0;
        for(int i=0;i<nums.Length;i++){
            if(mem[nums[i]]){
                int a = nums[i]+1;
                count++;
                while(mem[a]){
                    a++;count++;
                }
                mem[a] = true;
            }
            else{
                mem[nums[i]] = true;
            }
        }
        return count;
    }
}
*/