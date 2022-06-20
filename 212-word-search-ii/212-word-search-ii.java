class TrieNode {
    public HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    public String word = null;
    public TrieNode() {}
}

class Solution {    
    int rows;
    int cols;
    char[][] board;
    List<String> result;
    boolean[][] visited;
        
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            
            for (char c : word.toCharArray()) {
                if (node.children.containsKey(c))
                    node = node.children.get(c);
                else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(c, newNode);
                    node = newNode;
                }
            }
            node.word = word;
        }

        result = new ArrayList<>();
        rows = board.length;
        cols = board[0].length;
        this.board = board;
        visited = new boolean[board.length][board[0].length];
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (root.children.containsKey(board[row][col]))
                    search(row, col, root);
            }
        }
        return result;
    }
    
    private void search(int row, int col, TrieNode parent) {
        Character letter = board[row][col];
        TrieNode currNode = parent.children.get(letter);

        if (currNode.word != null) {
            result.add(currNode.word);
            currNode.word = null;
        }
        
        // mark current letter as visited
        visited[row][col] = true;
        
        // offsets
        int[] deltaRow = new int[]{0,0,1,-1};
        int[] deltaCol = new int[]{1,-1,0,0};
        
        for (int i = 0; i < deltaRow.length; i++) {
            int newRow = row + deltaRow[i];
            int newCol = col + deltaCol[i];
            if (0 <= newRow && newRow < rows && 0 <= newCol && newCol < cols && !visited[newRow][newCol]) {
                if (currNode.children.containsKey(board[newRow][newCol]))
                    search(newRow, newCol, currNode);
            }
        }
        
        visited[row][col] = false;
        
        if (currNode.children.isEmpty()) {
            parent.children.remove(letter);
        }
    }
}