class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        int[][] pairs = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }
        
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        
        double slowestTime = ((double) target - pairs[n - 1][0]) / pairs[n - 1][1];
        int count = 1;
        
        for (int i = n - 2; i >= 0; i--) {
            double currTime = ((double) target - pairs[i][0]) / pairs[i][1];

            if (currTime > slowestTime) {
                slowestTime = currTime;
                count++;
            }
        }
        
        return count;
    }
}