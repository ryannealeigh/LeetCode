class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int diff = Integer.MAX_VALUE;
        int bestIndex = -1;
        
        int count = 0;
        for (int[] point : points) {
            if (point[0] == x) {
                // valid point
                if (Math.abs(point[1] - y) < diff) {
                    diff = Math.abs(point[1] - y);
                    bestIndex = count;
                }
            }
            if (point[1] == y) {
                // valid point
                if (Math.abs(point[0] - x) < diff) {
                    diff = Math.abs(point[0] - x);
                    bestIndex = count;
                }
            }
            count++;
        }
        
        return bestIndex;
    }
}