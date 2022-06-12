class Solution {
    public int minOperations(int[] nums, int x) {
        int current = 0;
        for (int num : nums) {
            current += num;
        }
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int left = 0;

        for (int right = 0; right < n; right++) {
            current -= nums[right];
            while (current < x && left <= right) {
                current += nums[left];
                left += 1;
            }
            if (current == x) {
                min = Math.min(min, (n-1-right)+left);
            }
        }
        return min != Integer.MAX_VALUE ? min : -1;
    }
}