class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] counts = new int[128];
        int start = 0, longest = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            counts[c]++;
            
            while (counts[c] > 1) {
                char sc = s.charAt(start);
                counts[sc]--;
                start++;
            }
            longest = Math.max(longest, i - start + 1);
        }
        
        return longest;
    }
}