class Solution {
    public int uniquePaths(int m, int n) {
        // dp array of size m + 1 x n + 1
        // recurrence relation -> dp[i][j] = dp[i][j - 1] + dp[i - 1][j]
        // init dp[0][0] = 1
        
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = 1;
        
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        
        return dp[m][n];
    }
}