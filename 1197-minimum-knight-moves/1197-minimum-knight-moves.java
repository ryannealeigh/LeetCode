class Solution {

    public int minKnightMoves(int x, int y) {
        boolean[][] visited = new boolean[607][607];
        ArrayDeque<List<Integer>> queue = new ArrayDeque<>();

        queue.add(List.of(0, 0));

        int[] deltaRow = new int[] { -2, -1, 1, 2, 2, 1, -1, -2 };
        int[] deltaCol = new int[] { 1, 2, 2, 1, -1, -2, -2, -1 };

        int count = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                List<Integer> coords = queue.poll();
                int row = coords.get(0);
                int col = coords.get(1);
                
                if (row == x && col == y) {
                    return count;
                }

                for (int j = 0; j < deltaRow.length; j++) {                    
                    if (!visited[row + deltaRow[j] + 302][col + deltaCol[j] + 302]) {
                        visited[row + deltaRow[j] + 302][col + deltaCol[j] + 302] = true;
                        queue.add(List.of(row + deltaRow[j], col + deltaCol[j]));
                    }
                }
            }
            count++;
        }
        
        return count;
    }
}
