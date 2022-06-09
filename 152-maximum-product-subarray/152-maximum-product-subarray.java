class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] post = new int[n];
        
        int max = Integer.MIN_VALUE;

        int mul = 1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] == 0) {
                pre[i] = 0;
                mul = 1;
            } else {
                mul *= nums[i];
                pre[i] = mul;
            }
        }
        
        mul = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                post[i] = 0;
                mul = 1;
            } else {
                mul *= nums[i];
                post[i] = mul;
            }
        }

        for (int i : pre) {
            max = Math.max(max, i);
        }
        
        for (int i : post) {
            max = Math.max(max, i);
        }
        
        return max;
    }
}