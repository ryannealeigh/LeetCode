class TicTacToe {
    int n;
    HashMap<String, Integer> counts = new HashMap<>();

    public TicTacToe(int n) {
        this.n = n;
    }

    public int move(int row, int col, int player) {
        String rowKey = row + "r" + player;
        counts.put(rowKey, counts.getOrDefault(rowKey, 0) + 1);
        if (counts.get(rowKey) == n) {
            return player;
        }
        
        System.out.println(rowKey);
        
        String colKey = col + "c" + player;
        counts.put(colKey, counts.getOrDefault(colKey, 0) + 1);
        if (counts.get(colKey) == n) {
            return player;
        }
        
        System.out.println(colKey);

        if (row == col) {
            String diagKey = "diag" + player;
            counts.put(diagKey, counts.getOrDefault(diagKey, 0) + 1);
            if (counts.get(diagKey) == n) {
                return player;
            }
            
            System.out.println(diagKey);
        }
        
        if (row + col == n - 1) {
            String diagKey = "anti" + player;
            counts.put(diagKey, counts.getOrDefault(diagKey, 0) + 1);
            if (counts.get(diagKey) == n) {
                return player;
            }
            
            System.out.println(diagKey);
        }

        return 0;
    }
}
/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
