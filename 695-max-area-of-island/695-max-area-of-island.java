class Solution {
    int[][] coords = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
    int rows;
    int cols;
    int[][] grid;
    
    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        this.grid = grid;
        
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, countIsland(i, j));
                }
            }
        }
        
        return maxArea;
    }
    
    private int countIsland(int row, int col) {
        if (grid[row][col] == 0) {
            return 0;
        }
        
        grid[row][col] = 0;
        
        int currentCount = 1;
        
        for (int i = 0; i < coords.length; i++) {
            int newRow = row + coords[i][0];
            int newCol = col + coords[i][1];
            
            if (0 <= newRow && newRow < rows && 0 <= newCol && newCol < cols) {
                currentCount += countIsland(newRow, newCol);
            }
        }
        
        return currentCount;
    }
}