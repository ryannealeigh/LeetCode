class Solution {
    TrieNode root;
    int rows;
    int cols;
    char[][] board;
    int maxLen;
    int[][] deltas = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    boolean[][] visited;
    
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        rows = board.length;
        cols = board[0].length;
        this.board = board;
        maxLen = 0;
        visited = new boolean[rows][cols];
        
        for (String word : words) {
            add(word);
            maxLen = Math.max(maxLen, word.length());
        }
        
        List<String> result = new ArrayList<>();
        HashSet<String> used = new HashSet<String>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char c = board[row][col];
                if (root.children[c - 'a'] != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(c);
                    search(row, col, sb, root.children[c - 'a'], result, used);
                }
            }
        }
        
        return result;
    }
    
    private void search(int row, int col, StringBuilder sb, TrieNode curr, List<String> result, HashSet<String> used) {     
        if (sb.length() > maxLen) {
            return;
        }
        
        visited[row][col] = true;
        
        if (curr.end && !used.contains(sb.toString())) {
            String str = sb.toString();
            result.add(str);
            used.add(str);
        }
        
        for (int i = 0; i < deltas.length; i++) {
            int newRow = row + deltas[i][0];
            int newCol = col + deltas[i][1];
            
            if (0 <= newRow && newRow < rows && 0 <= newCol && newCol < cols && !visited[newRow][newCol]) {
                char c = board[newRow][newCol];
                if (curr.children[c - 'a'] != null) {
                    sb.append(board[newRow][newCol]);
                    search(newRow, newCol, sb, curr.children[c - 'a'], result, used);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        
        visited[row][col] = false;
    }
    
    private void add(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            
            curr = curr.children[c - 'a'];
        }
        
        curr.end = true;
    }
    
    class TrieNode {
        boolean end;
        TrieNode[] children;
        
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}