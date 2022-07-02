class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        
        int count = 0;
        int sum = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            count++;
            if (count % 3 == 0) {
                continue;
            }
            sum += cost[i];
        }
        
        return sum;
    }
}