import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), results);
        return results;
    }

    private void backtrack(int[] nums, List<Integer> current, List<List<Integer>> results) {
        if (current.size() == nums.length) {
            results.add(new ArrayList<>(current));
            return;
        }

        for (int num : nums) {
            if (current.contains(num)) {
                continue;
            }
            current.add(num);
            backtrack(nums, current, results);
            current.remove(current.size() - 1);
        }
    }
}


/*
 class Solution {
    public List<List<Integer>> permute(int[] n) {
       List<List<Integer>> l=new ArrayList<>();
       back(n,l,0);
       return l; 
    }
    public static void back(int[] n,List<List<Integer>> l,int st){
        if(n.length==st){
            l.add(p(n));
            return;
        }
        for(int i=st;i<n.length;i++){
            swap(n,st,i);
            back(n,l,st+1);
            swap(n,st,i);
        }
    }
    public static void swap(int[] n,int i,int j){
        int temp=n[i];
        n[i]=n[j];
        n[j]=temp;
    }
    public static List<Integer> p(int[] n){
        List<Integer> l=new ArrayList<>();
        for(int i=0;i<n.length;i++){
            l.add(n[i]);
        }
        return l;
    }

}
 */