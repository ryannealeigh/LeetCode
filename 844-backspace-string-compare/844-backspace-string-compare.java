class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        
        while (i >= 0 || j >= 0) {
            int sdel = 0, tdel = 0;
                        
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    sdel++;
                    i--;
                } else if (sdel > 0) {
                    sdel--;
                    i--;
                } else {
                    break;
                }
            }
                        
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    tdel++;
                    j--;
                } else if (tdel > 0) {
                    tdel--;
                    j--;
                } else {
                    break;
                }
            }
                        
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j) || (i >= 0 ^ j >= 0)) {
                return false;
            }

            i--;
            j--;
        }
        return true;
    }
}