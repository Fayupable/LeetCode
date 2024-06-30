import java.util.*;

class Solution {
    private class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            // Initialize each node as its own parent
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int node) {
            // Find the root parent of the node
            if (parent[node] != node) {
                parent[node] = find(parent[node]);  // path compression
            }
            return parent[node];
        }

        public boolean union(int node1, int node2) {
            // Merge the two nodes
            int root1 = find(node1);
            int root2 = find(node2);

            // If the nodes are already connected, this edge is redundant
            if (root1 == root2) return false;

            // Union by rank
            if (rank[root1] > rank[root2]) {
                // Attach root2 under root1
                parent[root2] = root1;
            } else if (rank[root1] < rank[root2]) {
                // Attach root1 under root2
                parent[root1] = root2;
            } else {
                // If ranks are equal, attach root2 under root1 (arbitrarily)
                parent[root2] = root1;
                rank[root1]++;
            }
            return true;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        // Sort edges by type, descending
        UnionFind aliceUF = new UnionFind(n + 1);
        // Bob's UnionFind is separate from Alice's
        UnionFind bobUF = new UnionFind(n + 1);
        // Count of removable edges
        int removableEdges = 0;

        // First handle type 3 edges, which benefit both Alice and Bob
        for (int[] edge : edges) {
            // If this is a type 3 edge, try to add it to both Alice and Bob's UnionFind
            if (edge[0] == 3) {
                // If either Alice or Bob already have this edge, it is redundant
                boolean aliceAdded = aliceUF.union(edge[1], edge[2]);
                // If Alice didn't need this edge, check if Bob does
                boolean bobAdded = bobUF.union(edge[1], edge[2]);
                if (!aliceAdded && !bobAdded) {  // Neither Alice nor Bob needed this edge
                    removableEdges++;
                }
            }
        }

        // Now handle type 1 (Alice only) and type 2 (Bob only) edges
        for (int[] edge : edges) {
            if (edge[0] == 1) {  // Alice only
                if (!aliceUF.union(edge[1], edge[2])) {
                    removableEdges++;  // This edge is redundant for Alice
                }
            } else if (edge[0] == 2) {  // Bob only
                if (!bobUF.union(edge[1], edge[2])) {
                    removableEdges++;  // This edge is redundant for Bob
                }
            }
        }

        // Verify connectivity: both should be able to traverse the entire graph
        int aliceRoot = aliceUF.find(1);
        int bobRoot = bobUF.find(1);
        for (int i = 2; i <= n; i++) {
            if (aliceUF.find(i) != aliceRoot || bobUF.find(i) != bobRoot) {
                return -1;  // If any node is not fully reachable, return -1
            }
        }

        return removableEdges;
    }
}

//other people's solution

/*
 class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int []parA=new int[n];
        int []parB=new int[n];
        int []rankA=new int[n];
        int []rankB=new int[n];
        
        for(int i=0;i<n;i++){
            parA[i]=parB[i]=i;
            rankA[i]=rankB[i]=0;
        }
        
        
        //using lamda to srot
        Arrays.sort(edges,(a,b)->{
            //a>b->+ve
            //a<b->-ve
            //a=b->equal
            if(a[0]==3){
                return -1;
            }
            else if(b[0]==3){
                return 1;
            }
            else{
                return 0;
            }
        });
        
        int rc=0;//remove count
        int ra=1;//ek edge 2 logo ko jodta hai
        int rb=1;
        for(int i=0;i<edges.length;i++){
            int type=edges[i][0];
            int u=edges[i][1]; u--;
            int v=edges[i][2]; v--;
            
            if(type==1){
                //alice
                boolean erA=union(parA,rankA,u,v);//edge required
                
                if(erA==false){
                    rc++;
                }
                else{
                    ra++;
                }
            }
            else if(type==2){
                //bob
                boolean erB=union(parB,rankB,u,v);//edge required
                
                if(erB==false){
                    rc++;
                }
                else{
                    rb++;
                }
            }
            else{
                //alice and bob
                boolean erA=union(parA,rankA,u,v);
                boolean erB=union(parB,rankB,u,v);
                
                if(erA==false && erB==false){
                    rc++;
                }
                else{
                    ra++;
                    rb++;
                }
            }
        }
        if(ra==n && rb==n){
            return rc;
        }
        else{
            return -1;
        }
        
    }
    public static int find(int []par,int x){
        if(par[x]==x){
            return x;
        }
        else{
            int ans=find(par,par[x]);
            par[x]=ans;
            return ans;
        }
    }
    public static boolean union(int par[],int []rank,int u,int v){
        int lu=find(par,u);
        int lv=find(par,v);
        
        if(lu!=lv){
            //merging is possible
            if(rank[lu]<rank[lv]){
                par[lu]=lv;
            }
            else if(rank[lu]>rank[lv]){
                par[lv]=lu;
            }
            else{
                par[lu]=lv;
                rank[lv]++;
            }
            return true;
        }
        else{
            return false;
        }
    }
}
 */