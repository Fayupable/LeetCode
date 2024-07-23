using System;
using System.Collections.Generic;
using System.Linq;

public class Solution {
    public int[] FrequencySort(int[] nums) {
        // Dictionary to store the frequency of each element
        Dictionary<int, int> freq = new Dictionary<int, int>();
        foreach (var num in nums) {
            if (freq.ContainsKey(num)) {
                freq[num]++;
            } else {
                freq[num] = 1;
            }
        }

        // Sort the array based on the frequency and then by value in descending order if frequencies are the same
        var result = nums.OrderBy(x => freq[x]).ThenByDescending(x => x).ToArray();

        return result;
    }
}


/*
public class Solution {
    public int[] FrequencySort(int[] nums) {
        var dic=new Dictionary<int,int>();
        foreach(var n in nums){
            if(!dic.TryAdd(n,1))
            dic[n]++;
        }
        int count=0;
        foreach(var d in dic.OrderBy(x=>x.Value).ThenByDescending(x=>x.Key)){
            for(int i=0;i<d.Value;i++){
                nums[count]=d.Key;
                count++;
            }
        }
        return nums;
        
    }
}
*/
/*
public class Solution {
    public int[] FrequencySort(int[] nums) {

        if(nums==null || nums.Length==0)
            return new int[]{};

		var map = new Dictionary<int, int>();
        for(var i=0; i<nums.Length; i++){            
            var num = nums[i];
            if(!map.ContainsKey(num))
                map.Add(num, 0);
            map[num]++;
        }
        
        var pq = new PriorityQueue<int[], int[]>(new CustomHeap());
        foreach(var item in map){
            var newItem = new int[]{item.Key, item.Value};
            pq.Enqueue(newItem, newItem);
        }
        
        var llist = new LinkedList<int>();
        while(pq.Count>0){
            var current = pq.Dequeue();
            for(var i=0; i<current[1]; i++){
                llist.AddLast(current[0]);
            }            
        }

        return llist.ToArray();
    }

    public class CustomHeap:IComparer<int[]>{
        public int Compare(int[] a, int[] b){
            if(a[1] != b[1])
                return a[1] - b[1];
            return b[0] - a[0];
        }
    }
}
*/
