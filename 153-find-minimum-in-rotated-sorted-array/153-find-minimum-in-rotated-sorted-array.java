class Solution {
    public int findMin(int[] nums) {        
        int left = 0, right = nums.length - 1;
        int min = Integer.MAX_VALUE;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = nums[mid];
            min = Math.min(min, val);
            
            // right sorted portion
            if (val <= nums[nums.length - 1]) {
                // go left
                right = mid - 1;
            } else {
                // go right
                left = mid + 1;
            }

        }
        
        return min;
    }
}