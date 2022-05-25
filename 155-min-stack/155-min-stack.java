class MinStack {
    ArrayDeque<List<Integer>> stack;
    
    public MinStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(List.of(val, val));
        } else {
            stack.push(List.of(val, Math.min(stack.peek().get(1), val)));
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().get(0);
    }
    
    public int getMin() {
        return stack.peek().get(1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */