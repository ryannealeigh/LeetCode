class Solution {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            int val = nums[mid];

            if (val == target) {
                return mid;
            }

            // right sorted portion
            if (val <= nums[nums.length - 1]) {
                if (val > target || target > nums[nums.length - 1]) {
                    // go left
                    right = mid - 1;
                } else {
                    // go right
                    left = mid + 1;
                }
            } else { // left sorted portion
                if (val < target || target < nums[0]) {
                    // go right
                    left = mid + 1;
                } else {
                    // go left
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
