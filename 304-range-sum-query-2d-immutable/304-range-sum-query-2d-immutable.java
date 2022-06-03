class NumMatrix {
    int[][] matrix;
    int[][] cache;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        int m = matrix.length;
        int n = matrix[0].length;
        cache = new int[m + 1][n + 1];
        memoize(m, n);
    }
    
    private void memoize(int m, int n) {
        // init first row
        for (int col = 0; col < n; col++) {
            cache[1][col + 1] = cache[1][col] + matrix[0][col];
        }

        // init first col
        for (int row = 0; row < m; row++) {
            cache[row + 1][1] = cache[row][1] + matrix[row][0];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int sum = cache[i][j + 1] + cache[i + 1][j] + matrix[i][j] - cache[i][j];
                cache[i + 1][j + 1] = sum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {        
        return cache[row2 + 1][col2 + 1] - cache[row2 + 1][col1] - cache[row1][col2 + 1] + cache[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */