public class Solution 
{
    public int MinDays(int[] bloomDay, int m, int k) 
    {
        int start = 0, end = int.MaxValue;
        while(start < end)
        {
            int mid = start + (end - start) / 2;
            if(!IsPossible(bloomDay, m, k, mid))
                start = mid + 1;
            else
                end = mid;
        }
        
        return IsPossible(bloomDay, m, k, start) ? start : -1;
    }
    
    private bool IsPossible(int[] bloomDay, int m, int k, int day)
    {
        int count = 0, i = 0;
        while(i <= bloomDay.Length - k)
        {
            if(bloomDay[i] <= day)
            {
                int j = i;
                for(j = i; j < i + k; j++)
                    if(bloomDay[j] > day)
                        break;
                if(j == i + k)
                    count++;
                i = j;
            }
            else
                i++;
        }
        
        return count >= m;
    }
}

/*
public class Solution
{
    bool CanBeMade(int[] days, int day, int k, int m)
    {
        int count = 0;
        int bcount = 0;
        for(int i = 0; i < days.Length; i++)
        {
            if (days[i] > day)
            {
                count = 0;
            } 
            else
            {
                count++;
            }
            if(count == k) {
                bcount++;
                count = 0;
            }
        }
        if(bcount >= m) return true;
        return false;
    }

    public int MinDays(int[] bloomDay, int m, int k)
    {
        if ((long)m * k > bloomDay.Length) return -1;
        int l = 1, h = int.MinValue;
        for(int i = 0; i < bloomDay.Length; i++)
        {
            h = Math.Max(h, bloomDay[i]);
        }
        int ans = 0;
        while(l <= h)
        {
            int mid = (l + h) / 2;

            if(CanBeMade(bloomDay, mid, k, m) == true)
            {
                ans = mid;
                h = mid - 1;
            }
            else
            {
                l = mid + 1;
            }
        }
        return ans;
    }
}
*/

/*
public class Solution
{
    public int MinDays(int[] bloomDay, int m, int k)
    {
        var max = bloomDay[0];

        for (var i = 1; i < bloomDay.Length; i++)
        {
            max = Math.Max(max, bloomDay[i]);
        }

        var l = 0;
        var r = max;

        while (l <= r)
        {
            var day = l + (r - l) / 2;

            if (Check(bloomDay, m, k, day))
            {
                r = day - 1;
            }
            else
            {
                l = day + 1;
            }
        }

        return l > max? -1 : l;
    }

    private bool Check(int[] bloomDay, int m, int k, int day)
    {
        var cur = 0;
        for (var i = 0; i < bloomDay.Length; i++)
        {
            if (bloomDay[i] <= day)
            {
                cur++;
            }
            else
            {
                cur = 0;
            }

            if (cur == k)
            {
                cur = 0;
                m--;
            }

            if (m == 0) return true;
        }

        return false;
    }
}
*/