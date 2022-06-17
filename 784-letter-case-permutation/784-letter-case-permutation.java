class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        
        backtrack(s, new StringBuilder(), 0, result);
        
        return result;
    }
    
    private void backtrack(String s, StringBuilder curr, int index, List<String> result) {
        if (curr.length() == s.length()) {
            result.add(curr.toString());
            return;
        }
        
        if (index == s.length()) {
            return;
        }
                
        char c = s.charAt(index);
        if (Character.isLetter(c)) {
            curr.append(Character.toLowerCase(c));
            backtrack(s, curr, index + 1, result);
            curr.deleteCharAt(curr.length() - 1);
            
            curr.append(Character.toUpperCase(c));
            backtrack(s, curr, index + 1, result);
            curr.deleteCharAt(curr.length() - 1);
        } else {
            curr.append(c);
            backtrack(s, curr, index + 1, result);
            curr.deleteCharAt(curr.length() - 1);        
        }
    }
}