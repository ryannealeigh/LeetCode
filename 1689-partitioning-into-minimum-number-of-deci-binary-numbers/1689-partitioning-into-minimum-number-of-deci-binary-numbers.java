class Solution {
    public int minPartitions(String n) {
        // determined by the largetst digit in the string
        
        int max = 0;
        for (int i = 0; i < n.length(); i++) {
            max = Math.max(max, Integer.parseInt(n.substring(i, i + 1)));
        }
        
        return max;
    }
}
