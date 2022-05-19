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
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if (!row[i].contains(c) && !col[j].contains(c) && !box[boxIdx].contains(c)) {
                    row[i].add(c);
                    col[j].add(c);
                    box[boxIdx].add(c);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
