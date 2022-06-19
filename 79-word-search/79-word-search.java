class Solution {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        // pruning: case 1: not enough characters in board
        if (word.length() > m * n) return false;

        // pruning: case 2: board does not contain characters or enough characters that word contains
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int temp = count.getOrDefault(board[i][j], 0);
                count.put(board[i][j], temp + 1);
            }
        }

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!count.containsKey(c)) {
                return false;
            } else {
                int temp = count.get(c);
                if (temp == 1) {
                    count.remove(c);
                } else {
                    count.put(c, temp - 1);
                }
            }
        }
        // Backtracking: if a solution is possible, search for it
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] marked = new boolean[m][n];
                    marked[i][j] = true;
                    if (backtracking(board, word, i, j, 1, marked)) return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] board, String word, int i, int j, int index, boolean[][] marked) {
        if (index == word.length()) return true;
        int m = board.length;
        int n = board[0].length;
        int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        for (int d = 0; d < directions.length; d++) {
            int x = i + directions[d][0];
            int y = j + directions[d][1];
            if (x < 0 || x >= m || y < 0 || y >= n) continue;
            if (board[x][y] == word.charAt(index) && !marked[x][y]) {
                marked[x][y] = true;
                if (backtracking(board, word, x, y, index + 1, marked)) return true;
                marked[x][y] = false;
            }
        }
        return false;
    }
}
