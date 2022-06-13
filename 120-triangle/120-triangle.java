class Solution {
    int minPath;
    List<List<Integer>> triangle;
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> prev = triangle.get(0);
        
        List<Integer> temp = null;
        for (int row = 1; row < triangle.size(); row++) {
            temp = new ArrayList<>();
            List<Integer> current = triangle.get(row);
            temp.add(current.get(0) + prev.get(0));
            for (int i = 1; i < current.size() - 1; i++) {
                temp.add(Math.min(prev.get(i - 1), prev.get(i)) + current.get(i));
            }
            temp.add(current.get(current.size() - 1) + prev.get(prev.size() - 1));
            prev = temp;
        }
        
        int min = Integer.MAX_VALUE;
        for (Integer num : prev) {
            min = Math.min(min, num);
        }
        
        return min;
    }
}