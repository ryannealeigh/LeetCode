class Solution {
    int rows;
    int cols;
    int[][] grid;
    int[][] deltas = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    
    public int numEnclaves(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        this.grid = grid;
        
        int count = 0;
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                List<List<Integer>> coords = new ArrayList<>();
                if (grid[row][col] == 1) {
                    Pair<Boolean, Integer> result = isEnclave(row, col);
                    if (result.getKey()) {
                        count += result.getValue();
                    }
                }
            }
        }
        
        return count;
    }
    
    private Pair<Boolean, Integer> isEnclave(int row, int col) {
        grid[row][col] = 0;
        
        boolean enclave = true;
        
        if (row == 0 || row == rows - 1 || col == 0 || col == cols - 1) {
            enclave = false;
        }
        
        int count = 1;
        
        for (int i = 0; i < deltas.length; i++) {
            int newRow = row + deltas[i][0];
            int newCol = col + deltas[i][1];
            
            if (0 <= newRow && newRow < rows && 0 <= newCol && newCol < cols && grid[newRow][newCol] == 1) {
                Pair<Boolean, Integer> pair = isEnclave(newRow, newCol);
                enclave &= pair.getKey();
                count += pair.getValue();
            }
        }
        
        return new Pair(enclave, count);
    }
}