class Solution {
    int rows;
    int cols;
    int[][] deltas = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
    
    public void wallsAndGates(int[][] rooms) {
        rows = rooms.length;
        cols = rooms[0].length;
        
        ArrayDeque<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (rooms[row][col] == 0) {
                    queue.add(new Pair(row, col));
                }
            }
        }
        
        int distance = 0;
        // we start out with our queue being filled with gate locations
        while (!queue.isEmpty()) {
            distance++;
            int n = queue.size();
            
            for (int i = 0; i < n; i++) {
                Pair<Integer, Integer> pair = queue.poll();
                int row = pair.getKey();
                int col = pair.getValue();
                
                for (int j = 0; j < deltas.length; j++) {
                    int newRow = row + deltas[j][0];
                    int newCol = col + deltas[j][1];
                    
                    if (0 <= newRow && newRow < rows && 0 <= newCol && newCol < cols && rooms[newRow][newCol] == Integer.MAX_VALUE) {
                        rooms[newRow][newCol] = distance;
                        queue.add(new Pair(newRow, newCol));
                    }
                }
            }
        }
    }
}