class Solution {
    HashMap<Character, String> map;
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        List<String> result = new ArrayList<>();
        
        search(digits, 0, new StringBuilder(), result);
            
        return result;
    }
    
    private void search(String digits, int index, StringBuilder curr, List<String> result) {
        if (index == digits.length()) {
            result.add(curr.toString());
            return;
        }
        
        char val = digits.charAt(index);
        String letters = map.get(val);
        
        for (int i = 0; i < letters.length(); i++) {
            curr.append(letters.charAt(i));
            search(digits, index + 1, curr, result);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}