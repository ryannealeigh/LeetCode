class Solution {
    int[][] grid;
    int[][] distances;
    int m;
    int n;
    int[][] deltas = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
    
    public int orangesRotting(int[][] grid) {

        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        distances = new int[m][n];
        for (int[] row : distances) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        int freshCount = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 2) {
                    dfs(row, col, 0);
                }
                if (grid[row][col] == 1) {
                    freshCount++;
                }
            }
        }
        
        if (freshCount == 0) {
            return 0;
        }
        
        int result = Integer.MIN_VALUE;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if there is an unreachable fresh orange return -1
                if (grid[i][j] == 1 && distances[i][j] == Integer.MAX_VALUE) {
                    return -1;
                }
                if (distances[i][j] != Integer.MAX_VALUE) {
                    result = Math.max(result, distances[i][j]);
                }
            }
        }
        
        return result;
    }
    
    private void dfs(int row, int col, int distance) {
        distances[row][col] = Math.min(distance, distances[row][col]);
        
        for (int i = 0; i < deltas.length; i++) {
            int newRow = row + deltas[i][0];
            int newCol = col + deltas[i][1];
            
            if (0 <= newRow && newRow < m && 0 <= newCol && newCol < n && grid[newRow][newCol] == 1 && distance + 1 < distances[newRow][newCol]) {
                dfs(newRow, newCol, distance + 1);
            }
        }
    }
}