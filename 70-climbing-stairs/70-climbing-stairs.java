class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int prev = 1;
        int last = 2;
        
        int count = 2;
        while (count < n) {
            count++;
            int temp = last;
            last = prev + last;
            prev = temp;
        }
        
        return last;
    }
}