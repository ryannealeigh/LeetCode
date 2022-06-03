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
                int cacheRow = i + 1;
                int cacheCol = j + 1;
                int sum = cache[cacheRow - 1][cacheCol] + cache[cacheRow][cacheCol - 1] + matrix[i][j] - cache[cacheRow - 1][cacheCol - 1];
                cache[cacheRow][cacheCol] = sum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        row2++;
        col1++;
        col2++;
        int totalSum = cache[row2][col2];
        int leftSum = cache[row2][col1 - 1];
        int topSum = cache[row1 - 1][col2];
        int diagonalSum = cache[row1 - 1][col1 - 1];
        
        int sum = totalSum - leftSum - topSum + diagonalSum;
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */