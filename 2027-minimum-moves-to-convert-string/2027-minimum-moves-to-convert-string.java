class Solution {
    public int minimumMoves(String s) {
        char[] chars = s.toCharArray();
        
        int count = 0;
        int free = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'X') {
                if (free <= 0) {
                    free = 3;
                    count++;
                }
                chars[i] = 'O';
            }
            free--;
        }
        
        return count;
    }
}