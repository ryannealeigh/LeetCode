class Solution {
    public void moveZeroes(int[] nums) {
        int write = 0;
        int nonZero = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num != 0) {
                nums[write] = num;
                if (write != i) {
                    nums[i] = 0;
                }
                write++;
            }
        }
    }
}