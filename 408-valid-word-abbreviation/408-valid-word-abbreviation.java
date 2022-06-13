class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if (abbr.length() == 0) {
            return true;
        }
        int i = 0, j = 0;
        StringBuilder num = new StringBuilder();
        while (i < word.length() && j < abbr.length()) {
            num.setLength(0);
            while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                num.append(abbr.charAt(j++));
            }

            if (num.length() > 0) {
                String nums = num.toString();
                if (nums.charAt(0) == '0') {
                    return false;
                }

                i += Integer.parseInt(nums);

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