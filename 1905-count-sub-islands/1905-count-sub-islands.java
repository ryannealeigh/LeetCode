class Solution {
    int rows;
    int cols;
    int[][] deltas = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        rows = grid1.length;
        cols = grid1[0].length;
        
        int count = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid2[row][col] == 1 && isSubIsland(row, col, grid1, grid2)) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private boolean isSubIsland(int row, int col, int[][] grid1, int[][] grid2) {
        grid2[row][col] = 0;
        
        boolean subIsland = true;
        if (grid1[row][col] != 1) {
            subIsland = false;
        }
        
        for (int i = 0; i < deltas.length; i++) {
            int newRow = row + deltas[i][0];
            int newCol = col + deltas[i][1];
            
            if (0 <= newRow && newRow < rows && 0 <= newCol && newCol < cols && grid2[newRow][newCol] == 1) {
                subIsland &= isSubIsland(newRow, newCol, grid1, grid2);
            }
        }
        
        return subIsland;
    }
}