class Solution {
    public int maxDistance(int[] colors) {
        
        int leftDist = 0;
        int rightDist = 0;
        
        int leftMost = colors[0];
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] != leftMost) {
                leftDist = i;
            }
        }
        
        int rightMost = colors[colors.length - 1];
        for (int i = colors.length - 1; i >= 0; i--) {
            if (colors[i] != rightMost) {
                rightDist = (colors.length - 1) - i;
            }
        }
        
        return Math.max(leftDist, rightDist);
    }
}