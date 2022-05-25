class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper("(", 1, 0, n, result);
        return result;
    }
    
    private void helper(String str, int open, int closed, int n, List<String> result) {
        if (open == n && closed == n) {
            result.add(str);
            return;
        }
        if (open < n) {
            helper(str + "(", open + 1, closed, n, result);
        }
        if (closed < n && closed < open) {
            helper(str + ")", open, closed + 1, n, result);
        }
    }
}