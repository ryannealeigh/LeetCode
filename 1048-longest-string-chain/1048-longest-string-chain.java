class Solution {

    public int longestStrChain(String[] words) {
        HashSet<String> wordSet = new HashSet<>();
        for (String word : words) {
            wordSet.add(word);
        }

        HashMap<String, Integer> counts = new HashMap<>();

        // dynamic programming
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));

        for (int i = words.length - 1; i >= 0; i--) {
            String parent = words[i];
            StringBuilder child = new StringBuilder();
            child.append(parent);
            for (int j = 0; j < child.length(); j++) {
                char c = child.charAt(j);
                child.deleteCharAt(j);
                if (wordSet.contains(child.toString())) {
                    int childLen = counts.getOrDefault(child.toString(), 1);
                    int parentLen = counts.getOrDefault(parent, 1) + 1;

                    counts.put(child.toString(), Math.max(childLen, parentLen));
                }
                child.insert(j, c);
            }
        }

        int result = 1;
        for (String key : counts.keySet()) {
            result = Math.max(result, counts.get(key));
        }

        return result;
    }
}
