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
            
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    // equal case
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
            }
        }
        
        public int countConnected() {
            HashSet<Integer> roots = new HashSet<>();
            for (int i = 0; i < root.length; i++) {
                roots.add(find(i));
            }
            
            return roots.size();
        }
    }

    public int countComponents(int n, int[][] edges) {
        UnionFind dsu = new UnionFind(n);
        
        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }
        
        return dsu.countConnected();
    }
}
