class Solution {
    public int wiggleMaxLength(int[] nums) {
        // find the positive first subsequence
        // find the negative first subsequence
        // return greatest length
        
        int posLast = -1;
        int negLast = 1;

        int posLength = 1;
        int negLength = 1;
        
        for (int i = 0; i < nums.length - 1; i++) {
            int diff = nums[i + 1] - nums[i];
            
            if (diff > 0) {
                if (posLast < 0) {
                    posLast = diff;
                    posLength++;
                }
                if (negLast < 0) {
                    negLast = diff;
                    negLength++;
                }
            }
            
            if (diff < 0) {
                if (posLast > 0) {
                    posLast = diff;
                    posLength++;
                }
                if (negLast > 0) {
                    negLast = diff;
                    negLength++;
                }
            }
        }
        
        return Math.max(posLength, negLength);
    }
}