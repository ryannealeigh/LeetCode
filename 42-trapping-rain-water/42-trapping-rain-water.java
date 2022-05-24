class Solution {
    public int trap(int[] height) {
        int maxLeft = 0, maxRight = 0;
        int left = 0, right = height.length - 1;
        int sum = 0;
        int val = 0;
        
        while (left <= right) {
            if (maxLeft <= maxRight) {
                val = maxLeft - height[left];
                if (val > 0) {
                    sum += val;
                }
                maxLeft = Math.max(maxLeft, height[left]);
                left++;
            } else {
                val = maxRight - height[right];
                if (val > 0) {
                    sum += val;
                }
                maxRight = Math.max(maxRight, height[right]);
                right--;
            }
        }
        return sum;
    }
}