class Solution {
    int rows;
    int cols;
    int[][] grid;
    int[][] deltas = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
    
    public int closedIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        this.grid = grid;
        
        int count = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0 && closed(row, col)) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private boolean closed(int row, int col) {
        grid[row][col] = 1;
        
        boolean isClosed = true;
        if (row == 0 || row == rows - 1 || col == 0 || col == cols - 1) {
            isClosed = false;
        }

        for (int i = 0; i < deltas.length; i++) {
            int newRow = row + deltas[i][0];
            int newCol = col + deltas[i][1];
            
            if (0 <= newRow && newRow < rows && 0 <= newCol && newCol < cols && grid[newRow][newCol] == 0) {
                
                isClosed &= closed(newRow, newCol);
            }
        }
        
        return isClosed;
    }
}