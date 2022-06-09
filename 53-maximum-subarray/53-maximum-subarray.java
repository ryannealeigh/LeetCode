class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum = Math.max(num, sum + num);
            max = Math.max(max, sum);
        }
        
        return max;
    }
}