class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int two = nums[0];
        if (n == 1) {
            return two;
        }
        int one = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length; i++) {
            int temp = one;
            one = Math.max(one, two + nums[i]);
            two = temp;
        }
        
        return one;
    }
}