class Solution {
    class UnionFind {
        int[] root;
        public UnionFind(int size) {
            root = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
            }
        }
        
        public int find(int x) {
            return root[x];
        }
        
        public void union(int x, int y) {
            int rootX = root[x];
            int rootY = root[y];
            
            if (rootX != rootY) {
                for (int i = 0; i < root.length; i++) {
                    if (root[i] == rootY) {
                        root[i] = rootX;
                    }
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