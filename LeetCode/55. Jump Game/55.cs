public class Solution {
    public bool CanJump(int[] nums) {
        int n = nums.Length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (i > max) return false;
            max = Math.Max(max, i + nums[i]);
        }
        return true;
        
    }
}

//Other people's solution

/*
public class Solution {
    public bool CanJump(int[] nums) {
       int length =nums.Length;
       int MaxNumber=nums[0];
        if(length==1)
        return true;
        for(int i=1;i<length;i++)
        {
          if(MaxNumber+i>=length)
          return true;
          if(MaxNumber==0)
          return false;
          MaxNumber--;
          if(nums[i]>MaxNumber)
          MaxNumber=nums[i];
        }
        return false;
    }
}
*/

/*
public class Solution {
    public bool CanJump(int[] nums) {
        var max = 0;

        for (int i = 0; i <= max && i < nums.Length; i++) {
            max = Math.Max(max, i + nums[i]);
            if (max >= nums.Length - 1) return true;
        }

        return false;
    }
}
*/
/*
public class Solution {
    public bool CanJump(int[] nums) {
       int length =nums.Length;
       int MaxNumber=nums[0];
        if(length==1)
        return true;
        for(int i=1;i<length;i++)
        {
          if(MaxNumber+i>=length)
          return true;
          if(MaxNumber==0)
          return false;
          MaxNumber--;
          if(nums[i]>MaxNumber)
          MaxNumber=nums[i];
        }
        return false;
    }
}
*/
/*
public class Solution {
    public bool CanJump(int[] nums) {
        int index = nums.Length - 1;
        while (index > 0) {
            int i = 1;
            while (nums[index - i] < i) {
                i++;
                if (index - i < 0) return false;
            }
            index -= i;
        }
        return true;
    }
}
*/
/*
public class Solution {
    public bool CanJump(int[] nums) {
        return CanJump(nums, new HashSet<int>(), 0);
    }
    public bool CanJump(int[] nums, HashSet<int> xs, int x) {
        if (xs.Contains(x)) return false;
        xs.Add(x);
        int n = nums[x];
        if (nums.Length - x < n + 2) return true;
        for (int i = n; i > 0; i--) {
            int j = x + i;
            if (CanJump(nums, xs, j)) return true;
        }
        return false;
    }
}
*/
/*
public class Solution {
  public bool CanJump(int[] nums)
{
    int index = 0;
    while (index < nums.Length - 1 && nums[index] < nums.Length - 1)
    {

        if (nums[index] == 0)
            return false;
        index = GetOptimalChoice(nums, nums.Skip(index + 1).Take(nums[index]).ToArray(), index + 1, nums.Length);
    }
    return true;
}

public int GetOptimalChoice(int[] nums, int[] subArray, int startIndex, int length)
{
    double weight = 0;
    double maxWeight = 0;
    int index = 0;
    for (int i = 0; i < subArray.Length; i++)
    {
        weight = (subArray[i] + startIndex + i) / (length * 1.0);

        if(i + startIndex >= length - 1)
        {
            return length + 1;
        }

        if (weight > maxWeight)
        {
            maxWeight = weight;
            index = i + startIndex;
        }
    }
    return index;
}
}


*/
/*
public class Solution {
    int[] possible;
    public bool CanJump(int[] nums) {
        if(nums.Length==1) return true;
        possible = new int[nums.Length];
        return Jump(nums,0);
    }

    private bool Jump(int[] nums, int position)
    {
        if(position==nums.Length-1)
            return true;
        if(nums[position]==0)
            return false;
        
        int maxJumps=nums[position];
        int currPos=-1;
        bool canJump;
        while(maxJumps!=0)
        {
            currPos=maxJumps+position;
            if(currPos<nums.Length){
                if(possible[currPos]==0)
                    canJump=Jump(nums,currPos);
                else 
                    canJump=possible[currPos]==1;
                if(canJump)
                {
                    possible[currPos]=1;
                    return true;
                }
            }
            maxJumps--;            
        }
        possible[currPos]=-1;
        return false;
    }
}
*/