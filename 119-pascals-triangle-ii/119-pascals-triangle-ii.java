class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return List.of(1);
        }
        if (rowIndex == 1) {
            return List.of(1, 1);
        }
        List<Integer> prev = List.of(1, 1);
        int row = 2;
        while (row <= rowIndex) {
            List<Integer> nextRow = new ArrayList<>();
            nextRow.add(1);
            for (int i = 0; i < prev.size() - 1; i++) {
                nextRow.add(prev.get(i) + prev.get(i + 1));
            }
            nextRow.add(1);
            row++;
            prev = nextRow;
        }
        
        return prev;
    }
}