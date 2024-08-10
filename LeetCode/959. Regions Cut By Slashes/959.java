class Solution {
    class UnionFind {
        private int[] parent;
        private int[] rank;
        
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }
    
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        UnionFind uf = new UnionFind(4 * n * n);
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int index = 4 * (r * n + c);
                char val = grid[r].charAt(c);
                
                // Connect internal parts of each cell
                if (val == '/') {
                    uf.union(index + 0, index + 3);
                    uf.union(index + 1, index + 2);
                } else if (val == '\\') {
                    uf.union(index + 0, index + 1);
                    uf.union(index + 2, index + 3);
                } else {
                    uf.union(index + 0, index + 1);
                    uf.union(index + 1, index + 2);
                    uf.union(index + 2, index + 3);
                }
                
                // Connect bordering cells
                // Connect right neighbor
                if (c + 1 < n) {
                    uf.union(index + 1, 4 * (r * n + (c + 1)) + 3);
                }
                // Connect bottom neighbor
                if (r + 1 < n) {
                    uf.union(index + 2, 4 * ((r + 1) * n + c) + 0);
                }
            }
        }
        
        int regions = 0;
        for (int i = 0; i < 4 * n * n; i++) {
            if (uf.find(i) == i) {
                regions++;
            }
        }
        
        return regions;
    }
}