public class Solution {

    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int maxArea = 0;
        
        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] >= heights[i]) {
                int[] prev = stack.pop();
                maxArea = Math.max(maxArea, prev[1] * (i - prev[0]));
                start = prev[0];
            }
            stack.push(new int[]{start, heights[i]});
        }
        while (!stack.isEmpty()) {
            int[] prev = stack.pop();
            maxArea = Math.max(maxArea, prev[1] * (heights.length - prev[0]));
        }
        return maxArea;
    }
}
