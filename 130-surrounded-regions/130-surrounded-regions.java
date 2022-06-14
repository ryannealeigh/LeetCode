class Solution {
    char[][] board;
    int rows;
    int cols;
    int[][] deltas = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
    boolean[][] visited;
    
    public void solve(char[][] board) {
        this.board = board;
        rows = board.length;
        cols = board[0].length;
        visited = new boolean[rows][cols];
        
        for (int row = 1; row < rows - 1; row++) {
            for (int col = 1; col < cols - 1; col++) {
                if (board[row][col] == 'O' && !visited[row][col]) {
                    List<List<Integer>> coords = new ArrayList<>();
                    if (isSurrounded(row, col, coords)) {
                        for (List<Integer> coord : coords) {
                            board[coord.get(0)][coord.get(1)] = 'X';
                        }
                    }
                }
            }
        }
    }
    
    private boolean isSurrounded(int row, int col, List<List<Integer>> coords) {
        visited[row][col] = true;

        if (row == 0 || row == rows - 1 || col == 0 || col == cols - 1) {
            return false;
        }
        
        coords.add(List.of(row, col));
        boolean surrounded = true;
        
        for (int i = 0; i < deltas.length; i++) {
            int newRow = row + deltas[i][0];
            int newCol = col + deltas[i][1];
            
            if (0 <= newRow && newRow < rows && 0 <= newCol && newCol < cols && board[newRow][newCol] == 'O' && !visited[newRow][newCol]) {
                surrounded &= isSurrounded(newRow, newCol, coords);
            }
        }
        
        return surrounded;
    }
}