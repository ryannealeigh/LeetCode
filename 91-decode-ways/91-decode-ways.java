class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        
        int n = s.length();

        int one = 1;
        int two = 1;
        int next;
        for (int i = 1; i < n; i++) {
            next = 0;
            if (s.charAt(i) == '0' && s.charAt(i - 1) > '2') {
                return 0;
            }

            if (s.charAt(i) != '0') {
                next += two;
            }
            
            if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
                next += one;
            }
            
            one = two;
            two = next;
        }
        
        return two;
    }
}