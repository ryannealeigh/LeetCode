class Solution {
    public int countOdds(int low, int high) {
        int rangeSize = (high - low) + 1;
        if (low % 2 != 0 && high % 2 != 0) {
            return 1 + rangeSize / 2;
        }
        return rangeSize / 2;
    }
}