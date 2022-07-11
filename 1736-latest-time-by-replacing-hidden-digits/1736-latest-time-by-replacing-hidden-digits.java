class Solution {
    public String maximumTime(String time) {
        char[] chars = time.toCharArray();
        
        if (chars[0] == '?') {
            if (chars[1] != '?' && chars[1] >= '4') {
                chars[0] = '1';
            } else {
                chars[0] = '2';
            }
        }
        
        if (chars[1] == '?') {
            if (chars[0] == '0' || chars[0] == '1') {
                chars[1] = '9';
            } else {
                chars[1] = '3';
            }
        }
        
        if (chars[3] == '?') {
            chars[3] = '5';
        }
        
        if (chars[4] == '?') {
            chars[4] = '9';
        }
        
        return new String(chars);
    }
}