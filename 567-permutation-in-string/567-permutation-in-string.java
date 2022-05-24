class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] counts = new int[128];
        int distinct = 0;
        
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            counts[c]++;
            if (counts[c] == 1) {
                distinct++;
            }
        }
        
        int start = 0;
        int windowSize = s1.length();

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            counts[c]--;
            
            if (counts[c] == 0) {
                distinct--;
            }
            
            if (i >= windowSize - 1) {
                if (distinct == 0) {
                    return true;
                } else {
                    // add back first character to counts and slide forward
                    char sc = s2.charAt(start++);
                    counts[sc]++;
                    if (counts[sc] == 1) {
                        distinct++;
                    }
                }
            }
        }
        
        return false;
    }
}