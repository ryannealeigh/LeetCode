class Solution {
    public boolean canJump(int[] nums) {
        // dfs with memoization
        // for int j = 0 to nums[i]
        
        Boolean[] dp = new Boolean[nums.length];
        dp[nums.length - 1] = true;
        return dfs(0, nums, dp);
    }
    
    private boolean dfs(int index, int[] nums, Boolean[] dp) {
        if (index == nums.length - 1) {
            return true;
        }
        
        if (index >= nums.length) {
            return false;
        }
        
        if (dp[index] != null) {
            return dp[index];
        }
        
        for (int i = 1; i <= nums[index]; i++) {
            int nextPosition = index + i;
            if (nextPosition > nums.length - 1) {
                break;
            }
            if (dfs(nextPosition, nums, dp)) {
                dp[nextPosition] = true;
                return dp[nextPosition];
            }
        }
        
        dp[index] = false;
        return false;
    }
}