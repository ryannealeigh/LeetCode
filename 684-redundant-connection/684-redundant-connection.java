class Solution {
    class UnionFind {
        int[] root;
        int[] rank;
        
        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int x) {
            while (x != root[x]) {
                x = root[x];
            }
            return x;
        }
        
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
            }
        }
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind dsu = new UnionFind(edges.length + 1);
        
        for (int[] edge : edges) {
            if (dsu.find(edge[0]) == dsu.find(edge[1])) {
                return edge;
            } else {
                dsu.union(edge[0], edge[1]);
            }
        }
        
        return new int[]{};
    }
}