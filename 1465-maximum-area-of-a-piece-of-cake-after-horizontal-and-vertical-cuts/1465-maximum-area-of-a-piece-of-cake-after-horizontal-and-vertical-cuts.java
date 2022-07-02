class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long maxRowGap = 0;
        long maxColGap = 0;
        
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        long last = 0;
        for (int val : horizontalCuts) {
            maxRowGap = Math.max(maxRowGap, val - last);
            last = val;
        }
        maxRowGap = Math.max(maxRowGap, h - last);
        
        last = 0;
        for (int val : verticalCuts) {
            maxColGap = Math.max(maxColGap, val - last);
            last = val;
        }
        maxColGap = Math.max(maxColGap, w - last);

        return (int) ((maxRowGap * maxColGap) % (1000000007));
    }
}