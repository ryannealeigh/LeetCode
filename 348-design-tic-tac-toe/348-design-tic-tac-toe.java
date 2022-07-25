class TicTacToe {
    int n;
    int[] rows;
    int[] cols;
    int diag;
    int anti;
    
    public TicTacToe(int n) {
        this.n = n;
        rows = new int[n];
        cols = new int[n];
        diag = 0;
        anti = 0;
    }

    public int move(int row, int col, int player) {
        if (player == 1) {
            rows[row]++;
            cols[col]++;
            if (row == col) {
                diag++;
            }
            if (row + col == n - 1) {
                anti++;
            }
        } else {
            rows[row]--;
            cols[col]--;
            if (row == col) {
                diag--;
            }
            if (row + col == n - 1) {
                anti--;
            }
        }
        
        if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diag) == n || Math.abs(anti) == n) {
            return player;
        }
        return 0;
    }
}
/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
