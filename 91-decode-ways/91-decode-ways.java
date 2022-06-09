class Solution {
    public int numDecodings(String s) {
        char[] str = s.toCharArray();
        if (str[0] == '0') {
            return 0;
        }
        
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 1; i < n; i++) {
            if (str[i] == '0' && str[i - 1] > '2') {
                return 0;
            }

            if (str[i] != '0') {
                dp[i + 1] += dp[i];
            }
            
            if (str[i - 1] == '1' || (str[i - 1] == '2' && str[i] <= '6')) {
                dp[i + 1] += dp[i - 1];
            } 
        }
        
        return dp[n];
    }
}