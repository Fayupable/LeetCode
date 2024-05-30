class Solution {
    public int minimumDistance(int[][] points) {
        // Initialize the maximum and minimum x and y coordinates and their indices
        final int INF = Integer.MAX_VALUE;
        int maxX1 = -INF, maxX2 = -INF, maxY1 = -INF, maxY2 = -INF;
        int minX1 = INF, minX2 = INF, minY1 = INF, minY2 = INF;
        int maxXi = 0, minXi = 0, maxYi = 0, minYi = 0;

        // Iterate over all points
        for (int i = 0; i < points.length; i++) {
            int[] p = points[i];
            int x = p[0] + p[1];
            int y = p[1] - p[0];

            // Update the maximum x coordinates and their indices
            if (x > maxX1) {
                maxX2 = maxX1;
                maxX1 = x;
                maxXi = i;
            } else if (x > maxX2) {
                maxX2 = x;
            }

            // Update the minimum x coordinates and their indices
            if (x < minX1) {
                minX2 = minX1;
                minX1 = x;
                minXi = i;
            } else if (x < minX2) {
                minX2 = x;
            }

            // Update the maximum y coordinates and their indices
            if (y > maxY1) {
                maxY2 = maxY1;
                maxY1 = y;
                maxYi = i;
            } else if (y > maxY2) {
                maxY2 = y;
            }

            // Update the minimum y coordinates and their indices
            if (y < minY1) {
                minY2 = minY1;
                minY1 = y;
                minYi = i;
            } else if (y < minY2) {
                minY2 = y;
            }
        }

        // Initialize the minimum distance to INF
        int ans = INF;
        // Iterate over the indices of the points with the maximum and minimum x and y coordinates
        for (int i : new int[]{maxXi, minXi, maxYi, minYi}) {
            // Calculate the distances in the x and y directions
            int dx = (i == maxXi ? maxX2 : maxX1) - (i == minXi ? minX2 : minX1);
            int dy = (i == maxYi ? maxY2 : maxY1) - (i == minYi ? minY2 : minY1);
            // Update the minimum distance with the maximum of the distances in the x and y directions
            ans = Math.min(ans, Math.max(dx, dy));
        }
        // Return the minimum distance
        return ans;
    }
}

/*
 
class Solution {

        public int minimumDistance(int[][] points) {
        int len = points.length;
        int[] X = new int[len];
        int[] Y = new int[len];
        for(int i=0;i<len;i++){
            X[i] = points[i][0]-points[i][1];
            Y[i] = points[i][0]+points[i][1];
        };
        
        Arrays.sort(X);
        Arrays.sort(Y);
        int min = Integer.MAX_VALUE;
        for (int[] p : points){
            int xs = 0;
            int xe = len-1;
            int ys=0;
            int ye=len-1;
            if(X[xs]==p[0]-p[1]){
                xs++;
            }else
            if(X[xe]==p[0]-p[1]){
                xe--;
            }

            if(Y[ys]==p[0]+p[1]){
                ys++;
            }else
            if(Y[ye]==p[0]+p[1]){
                ye--;
            }
            min = Math.min(min,Math.max(X[xe]-X[xs],Y[ye]-Y[ys]));
        }
        return min;
    }
}
 */

 /*
  class Solution 
{
    public int minimumDistance(int[][] points) 
    {
        int n=points.length,minMaxDist=Integer.MAX_VALUE;
        ArrayList<int[]>v1=new ArrayList<>(),v2=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            v1.add(new int[]{points[i][0]+points[i][1],i});
            v2.add(new int[]{points[i][0]-points[i][1],i});
        }
        Collections.sort(v1,(a,b)->a[0]-b[0]);
        Collections.sort(v2,(a,b)->a[0]-b[0]);
        for(int i=0;i<n;i++)
        {
            int[] v1Max=v1.get(n-1)[1]==i? v1.get(n-2):v1.get(n-1);
            int[] v2Max=v2.get(n-1)[1]==i? v2.get(n-2):v2.get(n-1);
            int[] v1Min=v1.get(0)[1]==i? v1.get(1):v1.get(0);
            int[] v2Min=v2.get(0)[1]==i? v2.get(1):v2.get(0);
            minMaxDist=Math.min(minMaxDist,Math.max(v1Max[0]-v1Min[0],v2Max[0]-v2Min[0]));
        }
        return minMaxDist;
    }
}
  */

  /*
   class Solution {
    class p{
        long val;
        long id;
        p(long val, long id){
            this.val = val;
            this.id = id;
        }
    }

    class p1{
        int i;
        int j;
        long val;
        p1(int i, int j, long val){
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }

    public int getFront(ArrayList<p> al, int i1, int i2){
        for(int i = 0;i < al.size();i++){
            if(al.get(i).id == i1 || al.get(i).id == i2){
                continue;
            }
            return (int)al.get(i).id;
        }
        return -1;
    }

    public int getBack(ArrayList<p> al, int i1, int i2){
        for(int i = al.size() - 1;i >= 0;i--){
            if(al.get(i).id == i1 || al.get(i).id == i2){
                continue;
            }
            return (int)al.get(i).id;
        }
        return -1;
    }

    public void soltn(int[][] points, ArrayList<p> xplusy, ArrayList<p> xminusy, HashMap<Integer, p> map, int notTake){
        for(int i = 0;i < points.length;i++){
            if(i == notTake) continue;
            int j1 = getFront(xplusy, i, notTake);
            int j2 = getFront(xminusy, i, notTake);
            int j3 = getBack(xminusy, i, notTake);
            int j4 = getBack(xplusy, i, notTake);
            ArrayList<p1> al = new ArrayList<>();
            al.add(new p1(i, j1, points[i][0] + points[i][1] - (points[j1][0] + points[j1][1])));
            al.add(new p1(i, j2, points[i][0] - points[i][1] - (points[j2][0] - points[j2][1])));
            al.add(new p1(i, j3, -(points[i][0] - points[i][1]) + points[j3][0] - points[j3][1]));
            al.add(new p1(i, j4, -(points[i][0] + points[i][1]) + (points[j4][0] + points[j4][1])));
            Collections.sort(al, (a, b) -> (int)(b.val - a.val));
            map.put(i, new p(al.get(0).val, al.get(0).j));
        }
    }

    public long getMin(int[][] points, ArrayList<p1> al, ArrayList<p> xplusy, ArrayList<p> xminusy){
        long ans = Integer.MAX_VALUE;
        for(p1 t : al){
            long tempans = Integer.MIN_VALUE;
            HashMap<Integer, p> hm = new HashMap<>();
            soltn(points, xplusy, xminusy, hm, t.i);
            for(Integer t1 : hm.keySet()){
                tempans = Math.max(tempans, hm.get(t1).val);
            }
            ans = Math.min(ans, tempans);
            tempans = Integer.MIN_VALUE;
            hm.clear();
            soltn(points, xplusy, xminusy, hm, t.j);
            for(Integer t1 : hm.keySet()){
                tempans = Math.max(tempans, hm.get(t1).val);
            }
            ans = Math.min(ans, tempans);
        }
        return ans;
    }

    public int minimumDistance(int[][] points) {
        ArrayList<p> xplusy = new ArrayList<>();
        ArrayList<p> xminusy = new ArrayList<>();
        for(int i = 0;i < points.length;i++){
            xplusy.add(new p(points[i][0] + points[i][1], i));
            xminusy.add(new p(points[i][0] - points[i][1], i));
        }
        Collections.sort(xplusy, (a, b) -> (int)(a.val - b.val));
        Collections.sort(xminusy, (a, b) -> (int)(a.val - b.val));
        HashMap<Integer, p> map = new HashMap<>();
        soltn(points, xplusy, xminusy, map, -1);
        ArrayList<p1> al = new ArrayList<>();
        long max = Integer.MIN_VALUE;
        for(Integer t : map.keySet()){
            max = Math.max(max, map.get(t).val);
        }
        for(Integer t : map.keySet()){
            if(max == map.get(t).val){
                al.add(new p1(t, (int)map.get(t).id, map.get(t).val));
            }
        }
        return (int)getMin(points, al, xplusy, xminusy);
    }
}
   */