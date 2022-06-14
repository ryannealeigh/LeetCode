class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) dfs(image, sr, sc, color, newColor);
        
        return image;
    }
    
    private void dfs(int[][] image, int row, int col, int color, int newColor) {
        if (image[row][col] == color) {
            image[row][col] = newColor;
            if (row > 0) dfs(image, row - 1, col, color, newColor);
            if (col > 0) dfs(image, row, col - 1, color, newColor);
            if (row < image.length - 1) dfs(image, row + 1, col, color, newColor);
            if (col < image[0].length - 1) dfs(image, row, col + 1, color, newColor);
        }
    }
}