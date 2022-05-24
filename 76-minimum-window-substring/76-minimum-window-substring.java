class Solution {
    public String minWindow(String s, String t) {
        int[] counts = new int[128];
        int distinct = 0;
        int start = 0;
        String result = s + "#";
        
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            counts[c]++;
            if (counts[c] == 1) {
                distinct++;
            }
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            counts[c]--;
            if (counts[c] == 0) {
                distinct--;
            }
            
            while (distinct == 0) {
                if ((i - start + 1) < result.length()) {
                    result = s.substring(start, i + 1);
                }
                char sc = s.charAt(start++);
                counts[sc]++;
                if (counts[sc] == 1) {
                    distinct++;
                }
            }
        }
        
        return result.length() <= s.length() ? result : "";
    }
}