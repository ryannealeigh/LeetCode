class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if (abbr.length() == 0) {
            return true;
        }
        int i = 0, j = 0;
        
        while (i < word.length() && j < abbr.length()) {
            String num = "";
            while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                num += abbr.charAt(j++);
            }

            if (num.length() > 0) {
                if (num.charAt(0) == '0') {
                    return false;
                }

                i += Integer.parseInt(num);

                continue;
            }
            
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
            } else {
                return false;
            }
        }
        if (i == word.length() && j == abbr.length()) {
            return true;
        }
        return false;
    }
}