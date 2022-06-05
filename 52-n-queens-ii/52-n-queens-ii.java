class Solution {
    int count;
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        count = 0;
        
        backtrack(board, n, 0);
        
        return count;
    }
    
    private void backtrack(char[][] board, int n, int row) {
        if (row == n) {
            count++;
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(board, n, row + 1);
                board[row][col] = '.';
            }
        }
    }
    
    private boolean isSafe(char[][] board, int row, int col, int n) {      
        // check column, decrement row only
        for (int newRow = row - 1; newRow >= 0; newRow--) {
            if (board[newRow][col] == 'Q') {
                return false;
            }
        }

        // check left diagonal
        for (int newRow = row - 1, newCol = col - 1; newRow >= 0 && newCol >= 0; newRow--, newCol--) {               
            if (board[newRow][newCol] == 'Q') {
                return false;
            }
        }
            
        // check right diagonal
        for (int newRow = row - 1, newCol = col + 1; newRow >= 0 && newCol < n; newRow--, newCol++) {
            if (board[newRow][newCol] == 'Q') {
                return false;
            }
        }
        
        return true;
    }
}