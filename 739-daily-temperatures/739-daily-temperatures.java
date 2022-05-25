class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // next greatest element for each element
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        
        return result;
    }
}