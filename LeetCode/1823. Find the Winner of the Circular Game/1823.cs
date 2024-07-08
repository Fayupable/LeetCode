public class Solution
{
    public int FindTheWinner(int n, int k)
    {
        var list = new List<int>();
        for (int i = 1; i <= n; i++)
        {
            list.Add(i);
        }
        int index = 0;
        while (list.Count > 1)
        {
            index = (index + k - 1) % list.Count;
            list.RemoveAt(index);
        }
        return list[0];

    }
}

/*

using System.Linq;
public class Solution {
    public int FindTheWinner(int n, int k)
    {
        k--;

        int x = 0;
  
        List<int> a = new List<int>();

        for (int i = 1; i <= n; i++) {
            a.Add(i);
        }
  
         A(a, k, x);

         return a.FirstOrDefault();
    }

    private void A(List<int> arr, int k, int x)
    {
        if (arr.Count == 1) 
        {
            return;
        }
      
        x = ((x + k) % arr.Count);
      
        arr.RemoveAt(x);
      
        A(arr, k, x);
    }
}
    
*/

/*
public class Solution {
    public List<int> initList = new();

    public int startIndex = 0;

    public int FindTheWinner(int n, int k) {
        for (int i = 1; i <= n; i++) {
            initList.Add(i);
        }

        while (initList.Count > 1) {
            startIndex = (startIndex + k - 1) % initList.Count;
            initList.RemoveAt(startIndex);
        }
        
        return initList[0];
    }
}
*/
/*
public class Solution {
    public int FindTheWinner(int N, int K) {
    var position = 0;
    for(int i=2;i<=N;i++)
    {
        position = (position+K)%i;
    }
        return position+1;
    }
}
*/
/*

using System.Linq;
public class Solution {
    public int FindTheWinner(int n, int k)
    {
        

        k = k - 1;

        int x = 0;
  
        List<int> a = new List<int>();

        for (int i = 1; i <= n; i++) {
            a.Add(i);
        }

        if (a.Count == 1) 
        {
            return a.FirstOrDefault();
        }
  
         A(a, k, x);

         return a.FirstOrDefault();
    }

    private void A(List<int> arr, int k, int x)
    {
        if (arr.Count == 1) 
        {
            return;
        }
      
        x = ((x + k) % arr.Count);
      
        arr.RemoveAt(x);
      
        A(arr, k, x);
    }
}
*/
