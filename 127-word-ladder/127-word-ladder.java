class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // trying bfs approach

        HashMap<String, List<String>> patterns = new HashMap<>();
        
        wordList.add(beginWord);
        for (String word : wordList) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                chars[i] = '*';
                String pattern = new String(chars);
                patterns.putIfAbsent(pattern, new ArrayList<String>());
                patterns.get(pattern).add(word);
                chars[i] = c;
            }
        }
        
        ArrayDeque<String> queue = new ArrayDeque<>();
        HashSet<String> used = new HashSet<>();

        queue.add(beginWord);
        used.add(beginWord);
        
        int count = 0;
        
        while (!queue.isEmpty()) {
            count++;
            
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String curr = queue.poll();
                if (curr.equals(endWord)) {
                    return count;
                }
                
                char[] chars = curr.toCharArray();
                for (int j = 0; j < curr.length(); j++) {
                    char c = chars[j];
                    chars[j] = '*';
                    String pattern = new String(chars);
                    for (String word : patterns.get(pattern)) {
                        if (!used.contains(word)) {
                            queue.add(word);
                            used.add(word);
                        }
                    }
                    chars[j] = c;
                }
            }
        }

        return 0;
    }
}
