class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length() + 1;
        int[] result = new int[n];
        
        int I = 0;
        int D = n - 1;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                result[i] = I++;
            } else {
                result[i] = D--;
            }
        }
        
        result[n - 1] = I;
        
        return result;
    }
}