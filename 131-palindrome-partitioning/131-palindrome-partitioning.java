class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        search(0, s, new ArrayList<String>(), result);

        return result;
    }

    private void search(int i, String s, List<String> curr, List<List<String>> result) {
        if (i >= s.length()) {
            result.add(new ArrayList<>(curr));
        }

        for (int j = i + 1; j <= s.length(); j++) {
            String sub = s.substring(i, j);
            if (isPalindrome(sub)) {
                curr.add(sub);
                search(j, s, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        
        return true;
    }
}
