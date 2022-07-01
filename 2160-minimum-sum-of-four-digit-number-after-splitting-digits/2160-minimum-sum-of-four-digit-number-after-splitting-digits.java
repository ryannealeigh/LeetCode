class Solution {
    public int minimumSum(int num) {
        int[] digits = new int[4];

        int index = 3;
        while (num > 0) {
            int digit = num % 10;
            digits[index--] = digit;
            num /= 10;
        }
        
        Arrays.sort(digits);
        
        int a = (digits[0] * 10) + digits[2];
        int b = (digits[1] * 10) + digits[3];
        
        return a + b;
    }
}