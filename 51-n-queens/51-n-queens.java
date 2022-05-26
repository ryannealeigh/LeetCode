class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        char[][] board = new char[n][n];
        
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        
        backtrack(board, 0, n, results);
        
        return results;
    }
    
    private void backtrack(char[][] board, int row, int n, List<List<String>> results) {
        if (row == n) {
            List<String> result = new ArrayList<>();
            
            for (char[] rowChars : board) {
                result.add(new String(rowChars));
            }
            results.add(result);
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (row == 0 || isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(board, row + 1, n, results);
                board[row][col] = '.';
            }
        }
    }
    
    private boolean isSafe(char[][] board, int lastRow, int lastCol, int n) {
        // check above column
        for (int row = lastRow - 1; row >= 0; row--) {
            if (board[row][lastCol] == 'Q') {
                return false;
            }
        }
        
        // check left upper diagonal
        for (int row = lastRow - 1, col = lastCol - 1; row >= 0 && col >= 0; row--, col--) {
            if (board[row][col] == 'Q') {
                return false;
            }
        }
        
        // check right upper diagonal
        for (int row = lastRow - 1, col = lastCol + 1; row >= 0 && col < n; row--, col++) {
            if (board[row][col] == 'Q') {
                return false;
            }
        }
        
        return true;
    }
}