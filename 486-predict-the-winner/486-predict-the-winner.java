class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int[][] memo = new int[nums.length][nums.length];
        return search(nums, 0, nums.length - 1, memo) >= 0;
    }
    
    private int search(int[] nums, int start, int end, int[][] memo) {
        if (start == end) {
            return nums[start];
        }
        if (memo[start][end] != 0) {
            return memo[start][end];
        }
        
        int a = nums[start] - search(nums, start + 1, end, memo);
        int b = nums[end] - search(nums, start, end - 1, memo);
        memo[start][end] = Math.max(a, b);
        
        return memo[start][end];
    }
}