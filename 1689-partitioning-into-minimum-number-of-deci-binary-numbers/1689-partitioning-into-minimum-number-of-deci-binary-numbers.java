class Solution {
    public int minPartitions(String n) {
        // determined by the largetst digit in the string
        
        int max = 0;
        char[] chars = n.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
            int val = Character.getNumericValue(chars[i]);
            max = Math.max(max, val);
        }
        
        return max;
    }
}
