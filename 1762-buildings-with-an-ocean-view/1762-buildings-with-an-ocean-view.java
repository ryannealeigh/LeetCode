class Solution {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.add(n - 1);
        
        for (int i = n - 2; i >= 0; i--) {
            if (heights[stack.peek()] < heights[i]) {
                stack.push(i);
            }
        }
        
        int i = 0;
        int[] result = new int[stack.size()];
        while (stack.size() > 0) {
            result[i++] = stack.pop();
        }
        
        return result;
    }
}