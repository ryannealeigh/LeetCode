class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        
        for (int i = 0; i < n; i++) {
            for (String word : wordDict) {
                int length = word.length();
                int start = i - length + 1;
                if (start >= 0 && s.substring(start, i + 1).equals(word) && dp[start]) {
                    dp[i + 1] = true;
                }
            }
        }
        
        return dp[s.length()];
    }
}