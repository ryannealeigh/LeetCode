class Solution {
    public String convert(String s, int numRows) {
        // divide the numRows / 2 to get the number of columns between verticals
        // so 1 col will handle numRows characters, then numRows / 2 will handle numRows / 2 characters
        // so 1 "block" is numRows + (numRows / 2)
        // we can divide s.length() / blockSize

        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        char[][] grid = new char[numRows][s.length()];
        for (char[] row : grid) {
            Arrays.fill(row, '-');
        }
        int index = 0;
        int row = 0;
        int col = 0;
        boolean down = true;
        
        while (index < s.length()) {
            grid[row][col] = s.charAt(index++);
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
                col++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != '-') {
                    sb.append(grid[i][j]);
                }
            }
        }
        
        return sb.toString();
    }
}