class Solution {
    public int minCostToMoveChips(int[] position) {
        int countOdd = 0;
        int countEven = 0;
        
        for (int pos : position) {
            if (pos % 2 == 0) {
                countEven++;
            } else {
                countOdd++;
            }
        }
        
        return Math.min(countOdd, countEven);
    }
}