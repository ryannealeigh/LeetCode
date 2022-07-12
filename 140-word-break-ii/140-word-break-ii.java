class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {
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
