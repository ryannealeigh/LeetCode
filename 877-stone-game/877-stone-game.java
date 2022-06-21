class Solution {
    public boolean stoneGame(int[] piles) {
        int[][] memo = new int[piles.length][piles.length];
        return search(piles, 0, piles.length - 1, memo) >= 0;
    }
    
    private int search(int[] piles, int start, int end, int[][] memo) {
        if (start == end) {
            return piles[start];
        }
        
        if (memo[start][end] > 0) {
            return memo[start][end];
        }
        
        int a = piles[start] - search(piles, start + 1, end, memo);
        int b = piles[end] - search(piles, start, end - 1, memo);
        memo[start][end] = Math.max(a, b);
        
        return memo[start][end];
    }
}