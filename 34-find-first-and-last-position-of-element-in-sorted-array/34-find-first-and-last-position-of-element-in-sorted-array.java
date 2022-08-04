class Solution {
    public int[] searchRange(int[] nums, int target) {
        // find left of block
        // find right of block
        
        int left = 0, right = nums.length - 1;
        
        int first = -1, last = -1;
        
        // find first
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                // go left
                first = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                // go right
                left = mid + 1;
            } else {
                // go left
                right = mid - 1;
            }
        }
        
        // reset pointers
        left = 0;
        right = nums.length - 1;

        // find last
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                // go right
                last = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                // go right
                left = mid + 1;
            } else {
                // go left
                right = mid - 1;
            }
        }
        
        return new int[]{first, last};
    }
}