class WordDictionary {
    TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
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
    
    public boolean search(String word) {
        return recurse(word, root, 0);
    }
    
    private boolean recurse(String word, TrieNode curr, int index) {
        if (index == word.length()) {
            return curr.end;
        }
        char c = word.charAt(index);
        boolean found = false;

        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (curr.children[i] != null) {
                    found |= recurse(word, curr.children[i], index + 1);
                }
            }
        } else if (curr.children[c - 'a'] != null) {
            found |= recurse(word, curr.children[c - 'a'], index + 1);
        }
        
        return found;
    }
    
    class TrieNode {
        boolean end;
        TrieNode[] children;
        
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */