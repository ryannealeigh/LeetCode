class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        
        int[] dp = new int[n];
        dp[0] = 1;
        
        for (int i = 1; i < n; i++) {
            int current = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < current) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            
            if (dp[i] < 1) {
                dp[i] = 1;
            }
        }
        
        int result = Integer.MIN_VALUE;
        for (int val : dp) {
            result = Math.max(result, val);
        }
        return result;
    }
}