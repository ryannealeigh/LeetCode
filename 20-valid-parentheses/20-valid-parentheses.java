class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else if (c == ')' && stack.pop() != '(') {
                return false;
            } else if (c == '}' && stack.pop() != '{') {
                return false;
            } else if (c == ']' && stack.pop() != '[') {
                return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}