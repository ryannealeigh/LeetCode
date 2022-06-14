class Solution {
    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        int n = coins.length;
        // coins are rows and amount is column
        int[][] dp = new int[n + 1][amount + 1];
        
        for (int i = 1; i <= n; i++) {
            int coin = coins[i - 1];            // get coin value corresponding to this row

            for (int j = 1; j <= amount; j++) {     // j is equal to current amount we are considering
                int remainder = j - coin;
                
                if (remainder == 0) {
                    dp[i][j] = 1;
                } else if (remainder > 0) {
                    for (int row = 1; row <= i; row++) {
                        dp[i][j] += dp[row][remainder];
                    }
                }
            }
        }
        
        int total = 0;
        // add up last column corresponding to amount
        for (int i = 0; i <= n; i++) {
            total += dp[i][amount];
        }
        return total;
    }
}