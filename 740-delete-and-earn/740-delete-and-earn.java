class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + num);
            max = Math.max(max, num);
        }
        
        int[] dp = new int[max + 1];
        
        dp[0] = 0;
        dp[1] = counts.getOrDefault(1, 0);
        
        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], counts.getOrDefault(i, 0) + dp[i - 2]);
        }
        
        return dp[max];
    }
}