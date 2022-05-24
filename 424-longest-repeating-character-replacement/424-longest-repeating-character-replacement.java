class Solution {
    public int characterReplacement(String s, int k) {
        int maxFreq = 0, result = 0, start = 0;
        int[] counts = new int[128];
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            counts[c]++;
            maxFreq = Math.max(maxFreq, counts[c]);

            while (start < s.length() && (i - start + 1) - maxFreq > k) {
                char sc = s.charAt(start);
                counts[sc]--;
                start++;
            }
            
            result = Math.max(result, i - start + 1);
        }
        
        return result;
    }
}