class Solution {
    public void moveZeroes(int[] nums) {
        int write = 0;
        int nonZero = 0;
        
        for (int num : nums) {
            if (num != 0) {
                nums[write++] = num;
                nonZero++;
            }
        }
                
        for (int i = nums.length - 1; i >= nonZero; i--) {
            nums[i] = 0;
        }
    }
}