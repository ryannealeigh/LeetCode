class Solution {

    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] row = new HashSet[9];
        HashSet<Character>[] col = new HashSet[9];
        HashSet<Character>[] box = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int boxIdx = (i / 3) * 3 + (j / 3);
                if (board[i][j] == '.') {
                    continue;
                }
                if (row[i].contains(board[i][j]) || col[j].contains(board[i][j]) || box[boxIdx].contains(board[i][j])) {
                    return false;
                }
                row[i].add(board[i][j]);
                col[j].add(board[i][j]);
                box[boxIdx].add(board[i][j]);
            }
        }
        return true;
    }
}
