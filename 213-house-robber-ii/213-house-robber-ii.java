class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (nums.length == 3) {
            return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        }

        int two = 0;
        int one = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = one;
            one = Math.max(two + nums[i], one);
            two = temp;
        }
        
        int firstMax = one;
        
        two = 0;
        one = 0;
        
        for (int i = 1; i < nums.length; i++) {
            int temp = one;
            one = Math.max(two + nums[i], one);
            two = temp;
        }

        return Math.max(one, firstMax);
    }
}