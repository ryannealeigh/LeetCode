class Solution {
    class DSU {
        int[] root;
        int[] rank;
        
        public DSU(int size) {
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int x) {
            int original = x;
            while (x != root[x]) {
                x = root[x];
            }
            root[original] = x;
            return x;
        }
        
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            
            if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else {
                root[rootX] = rootY;
                rank[rootY] += 1;
            }
        }
    }
    
    public boolean validTree(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            
            if (dsu.find(x) == dsu.find(y)) {
                return false;
            }
            
            dsu.union(x, y);
        }
        
        HashSet<Integer> roots = new HashSet<>();
        for (int i = 0; i < n; i++) {
            roots.add(dsu.find(i));
        }
        
        return roots.size() == 1;
    }
}