class Solution {
    public boolean canJump(int[] nums) {
        // dfs with memoization
        // for int j = 0 to nums[i]
        
        Boolean[] dp = new Boolean[nums.length];
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
        
        boolean canReach = false;

        for (int i = 1; i <= nums[index]; i++) {
            if (index + i > nums.length - 1) {
                break;
            }
            canReach |= dfs(index + i, nums, dp);
            if (canReach) {
                break;
            }
        }
        
        dp[index] = canReach;
        return canReach;
    }
}