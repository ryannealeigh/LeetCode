class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.contains(beginWord)) {
            wordList.remove(beginWord);
        }
        
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                String curr = queue.poll();
                if (curr.equals(endWord)) {
                    return count;
                }

                List<String> toRemove = new ArrayList<>();
                for (int j = 0; j < wordList.size(); j++) {
                    String nextWord = wordList.get(j);
                    if (offByOne(curr, nextWord)) {
                        queue.add(nextWord);
                        toRemove.add(nextWord);
                    }
                }
                
                wordList.removeAll(toRemove);
            }
        }

        return 0;
    }

    private boolean offByOne(String a, String b) {
        int offBy = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                offBy++;
            }
        }

        return offBy == 1;
    }
}
