class Solution {
    /*
        keep counter "count"
        keep 2d array "visited"
        for each starting position
            if value == 1 && not already visited
                call dfs()
                increment count
        
        return count
            
        dfs()
            mark current as visited
            for each direction (up, down, left, right)
                if value == 1 and not already in visited
                    call dfs()
    */
    int rows;
    int cols;
    char[][] grid;
    
    public int numIslands(char[][] grid) {
        int count = 0;
        rows = grid.length;
        cols = grid[0].length;
        this.grid = grid;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void dfs(int row, int col) {
        grid[row][col] = '0';
        int[] deltaRow = new int[]{0,0,1,-1};
        int[] deltaCol = new int[]{1,-1,0,0};
        
        for (int i = 0; i < deltaRow.length; i++) {
            int newRow = row + deltaRow[i];
            int newCol = col + deltaCol[i];
            
            if (0 <= newRow && newRow < rows && 0 <= newCol && newCol < cols) {
                if (grid[newRow][newCol] == '1')
                    dfs(newRow, newCol);
            }
        }
    }
}