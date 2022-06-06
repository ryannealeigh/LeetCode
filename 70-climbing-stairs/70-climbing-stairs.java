class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int prev = 1;
        int last = 2;
        int result = 0;
        
        int count = 2;
        while (count < n) {
            count++;
            result = prev + last;
            prev = last;
            last = result;
        }
        
        return result;
    }
}