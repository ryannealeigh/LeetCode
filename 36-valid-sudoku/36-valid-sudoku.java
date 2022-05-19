class Solution {

    /*
        use HashMap of rows, cols, subsquares to HashSet of current ints
        iterate over entire array, check for each element
        in 3 discrete HashSets, if it does exist already, then return false
        if it doesn't exist, then we add it
        
    */
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Integer>> rows = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> cols = new HashMap<>();
        // we divide row and col by 3 to get coordinates for the subsquare
        HashMap<String, HashSet<Integer>> squares = new HashMap<>();

        // init the map
        for (int i = 0; i < 9; i++) {
            rows.put(i, new HashSet<Integer>());
            cols.put(i, new HashSet<Integer>());
        }

        // init the square sets
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String key = "";
                key += i;
                key += j;
                squares.put(key, new HashSet<Integer>());
            }
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                int val = board[row][col];

                if (val == '.') {
                    continue;
                }

                // row check
                HashSet<Integer> rowSet = rows.get(row);
                if (rowSet.contains(val)) {
                    return false;
                }
                rowSet.add(val);

                // col check
                HashSet<Integer> colSet = cols.get(col);
                if (colSet.contains(val)) {
                    return false;
                }
                colSet.add(val);

                // square check
                String key = "";
                key += (row / 3);
                key += (col / 3);

                HashSet<Integer> squareSet = squares.get(key);
                if (squareSet.contains(val)) {
                    return false;
                }
                squareSet.add(val);
            }
        }

        return true;
    }
}
