class Solution {
    int ar[], n, p=-1, max=Integer.MIN_VALUE, res[];
    public int[] longestObstacleCourseAtEachPosition(int[] obs) {
        n=obs.length;
        ar=new int[n];
        res=new int[n];
        for(int i=0, ind;i<n;i++) {
            if(max<=obs[i]) {
                max=obs[i];
                p++;
                ind=p;
            }else{
                ind=find(obs[i], p);
                if(ind==p) max=obs[i];
            }
            ar[ind]=obs[i];
            res[i]=ind+1;
        }
        return res;
    }
    private int find(int num, int r) {
        int l=0, m;
        while(l<r) {
            m=(l+r)/2;
            if(ar[m]<=num) l=m+1;
            else r=m;
        }
        return ar[r]==num?r+1:r;
    }
}