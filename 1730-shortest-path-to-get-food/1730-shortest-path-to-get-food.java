class Solution {
    public int getFood(char[][] grid) {
        // need to do bfs here
        int rows = grid.length;
        int cols = grid[0].length;
        
        int[] start = new int[2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '*') {
                    start[0] = i;
                    start[1] = j;
                    break;
                }
            }
        }
        
        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        
        boolean[][] visited = new boolean[rows][cols];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        visited[start[0]][start[1]] = true;
        queue.add(start);
        
        int length = 0;
        while (!queue.isEmpty()) {
            length++;
            int n = queue.size();
            
            for (int i = 0; i < n; i++) {
                int[] curr = queue.poll();
                for (int j = 0; j < dirs.length; j++) {
                    int newRow = curr[0] + dirs[j][0];
                    int newCol = curr[1] + dirs[j][1];
                    
                    if (0 <= newRow && newRow < rows && 0 <= newCol && newCol < cols && !visited[newRow][newCol] && grid[newRow][newCol] != 'X') {
                        if (grid[newRow][newCol] == '#') {
                            return length;
                        }
                        visited[newRow][newCol] = true;
                        queue.add(new int[]{newRow, newCol});
                    }
                }
            }
        }
        
        return -1;
    }
}