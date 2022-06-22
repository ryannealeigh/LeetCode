class Solution {
    public String convert(String s, int numRows) {
        // divide the numRows / 2 to get the number of columns between verticals
        // so 1 col will handle numRows characters, then numRows / 2 will handle numRows / 2 characters
        // so 1 "block" is numRows + (numRows / 2)
        // we can divide s.length() / blockSize

        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        
        int row = 0;
        boolean down = true;
        
        for (int i = 0; i < s.length(); i++) {
            rows.get(row).append(s.charAt(i));
            if (down && row == numRows - 1) {
                down = false;
            }
            if (!down && row == 0) {
                down = true;
            }
            
            if (down) {
                row++;
            } else {
                row--;
            }
        }
        
        for (int i = 1; i < rows.size(); i++) {
            rows.get(0).append(rows.get(i));
        }
        
        return rows.get(0).toString();
    }
}