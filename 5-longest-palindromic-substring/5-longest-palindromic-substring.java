class Solution {
    public String longestPalindrome(String s) {
        int max = 1;
        int maxL = 0;
        int maxR = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int l = i, r = i;
            int count = -1;
            
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                count += 2;
                if (count * 2 > max) {
                    max = count * 2;
                    maxL = l;
                    maxR = r;
                }

                l--;
                r++;
            }
            
            count = 0;
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                count += 2;
                if (count * 2 > max) {
                    max = count * 2;
                    maxL = l;
                    maxR = r;
                }
                
                l--;
                r++;
            }
        }
        
        return s.substring(maxL, maxR + 1);
    }
}