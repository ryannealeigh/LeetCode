class Solution {
    class Value {
        int row;
        int col;
        int val;
        
        public Value(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        // like merge k sorted lists
        // for this we can use a min heap
        // add object with row, col, value for each row to heap
        // then poll items out of the heap until we hit k items polled out
        // when we poll an item out we also add the next item for it's row
        int n = matrix.length;
        
        PriorityQueue<Value> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        
        for (int i = 0; i < n; i++) {
            heap.add(new Value(i, 0, matrix[i][0]));
        }
        
        int count = 0;
        int prev = 0;
        while (count < k) {
            count++;
            Value curr = heap.poll();
            prev = curr.val;
            if (curr.col < n - 1) {
                int row = curr.row;
                int newCol = curr.col + 1;
                heap.add(new Value(curr.row, newCol, matrix[row][newCol]));
            }
        }
                
        return prev;
    }
}