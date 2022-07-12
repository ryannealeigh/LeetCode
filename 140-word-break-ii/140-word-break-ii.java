class Solution {

    public class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean end;

        public TrieNode() {
            children = new HashMap<>();
            end = false;
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
//         TrieNode trie = new TrieNode();
//         int maxLength = 0;
//         for (String word : wordDict) {
//             maxLength = Math.max(maxLength, word.length());
//             TrieNode curr = trie;

//             for (int i = 0; i < word.length(); i++) {
//                 char c = word.charAt(i);
//                 trie.children.putIfAbsent(c, new TrieNode());
//                 curr = trie.children.get(c);
//                 if (i == word.length() - 1) {
//                     curr.end = true;
//                 }
//             }
//         }
        
        List<String> result = new ArrayList<>();
        
        search(s, wordDict, result, new StringBuilder());
        
        return result;
    }
    
    private void search(String s, List<String> wordDict, List<String> result, StringBuilder curr) {
        if (s.length() == 0) {
            result.add(curr.substring(0, curr.length() - 1));
        }
        
        for (String str : wordDict) {
            if (s.startsWith(str)) {
                curr.append(str);
                curr.append(" ");
                search(s.substring(str.length()), wordDict, result, curr);
                curr.delete(curr.length() - str.length() - 1, curr.length());
            }
        }

    }
}
