class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int two = cost[0];
        int one = cost[1];
        
        for (int i = 2; i < cost.length; i++) {
            int temp = one;
            one = Math.min(one, two) + cost[i];
            two = temp;
        }
        
        return Math.min(one, two);
    }
}