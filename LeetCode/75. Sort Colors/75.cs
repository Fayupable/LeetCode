public class Solution {
    public void SortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.Length - 1;
        
        while (mid <= high) {
            switch (nums[mid]) {
                case 0:
                    // Swap nums[low] and nums[mid]
                    int temp = nums[low];
                    nums[low] = nums[mid];
                    nums[mid] = temp;
                    
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    // Swap nums[mid] and nums[high]
                    temp = nums[mid];
                    nums[mid] = nums[high];
                    nums[high] = temp;
                    
                    high--;
                    break;
            }
        }
    }
}

/*
public class Solution {
    public void SortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.Length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                Swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                Swap(nums, mid, high);
                high--;
            }
        }
    }

    private void Swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
*/

/*
public class Solution
{
    public void SortColors(int[] nums)
    {
        bool orderChanged;

        do
        {
            orderChanged = false;
            for (int i = 1; i < nums.Length; i++)
            {
                if (nums[i] < nums[i - 1])
                {
                    var temp = nums[i - 1];
                    nums[i - 1] = nums[i];
                    nums[i] = temp;
                    orderChanged = true;
                }
            }
        } while (orderChanged);
    }
}
*/


/*
public class Solution {
    public void SortColors(int[] nums) {
        var sorted = new Dictionary<int,IList<int>>();
        sorted[0]= new List<int>();
        sorted[1]= new List<int>();
        sorted[2]= new List<int>();
        for(var i=0; i<nums.Length;i++){
            sorted[nums[i]].Add(nums[i]);
        }
        var index=0;
        for(var i=0; i<3;i++){
            foreach(var color in sorted[i]){
                nums[index]=color;
                index+=1;
            }
        }
    }
}
*/

/*
public class Solution
{
    public void SortColors(int[] nums)
    {
        bool orderChanged;

        do
        {
            orderChanged = false;
            for (int i = 1; i < nums.Length; i++)
            {
                if (nums[i] < nums[i - 1])
                {
                    var temp = nums[i - 1];
                    nums[i - 1] = nums[i];
                    nums[i] = temp;
                    orderChanged = true;
                }
            }
        } while (orderChanged);
    }
}
*/

/*
public class Solution {
    public void SortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.Length - 1;
        int temp = 0;
        while(mid <= high) 
        {
            if(nums[mid] == 0) {
               temp = nums[low];
               nums[low] = nums[mid];
               nums[mid] = temp;

               mid++;
               low++; 
            }
            else if(nums[mid] == 2)
            {
               temp = nums[high];
               nums[high] = nums[mid];
               nums[mid] = temp;

               high--;
            }
            else
            {
                mid++;
            }
        }
    }
}
*/