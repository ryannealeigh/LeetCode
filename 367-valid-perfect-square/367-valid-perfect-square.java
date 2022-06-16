class Solution {
    public boolean isPerfectSquare(int num) {
        long l = 1, r = num / 2 + 1;
        
        while (l <= r) {
            long mid = l + (r - l) / 2;
            
            long prod = mid * mid;
            if (prod == num) {
                return true;
            } else if (prod < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return false;
    }
}