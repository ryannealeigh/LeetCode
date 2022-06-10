class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length < 2)
            return false;
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) return false;
        sum /= 2;
        
        boolean dp[] = new boolean[sum + 1];
        dp[0] = true;
        
        for (int val : nums) {
            for (int j = sum; j >= val; j--) {
                dp[j] |= dp[j - val];
                if (dp[sum]) return true;
            }
        }
        return false;
    }
}