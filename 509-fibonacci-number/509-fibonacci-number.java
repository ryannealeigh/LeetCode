class Solution {
    public int fib(int n) {
        int one = 0;
        int two = 1;
        
        if (n < 2) {
            return n;
        }
        
        for (int i = 2; i <= n; i++) {
            int temp = two;
            two = one + two;
            one = temp;
        }
        
        return two;
    }
}