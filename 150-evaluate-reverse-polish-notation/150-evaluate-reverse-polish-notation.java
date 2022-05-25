class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x + y);
            } else if (tokens[i].equals("-")) {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x - y);
            } else if (tokens[i].equals("*")) {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x * y);
            } else if (tokens[i].equals("/")) {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x / y);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        
        return stack.pop();
    }
}