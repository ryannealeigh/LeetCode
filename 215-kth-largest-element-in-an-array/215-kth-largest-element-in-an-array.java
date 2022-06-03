class Solution {
    public int findKthLargest(int[] nums, int k) {
        // quickselect
        
        int left = 0;
        int right = nums.length - 1;
        quickSelect(nums, left, right, k);
        
        return nums[nums.length - k];
    }
    
    private void quickSelect(int[] nums, int left, int right, int k) {
        int pivot = nums[right];
        int low = left;
        
        for (int i = left; i < right; i++) {
            int val = nums[i];
            if (val <= pivot) {             // we will swap val at nums[i] with value at nums[low]
                nums[i] = nums[low];
                nums[low++] = val;
            }
        }
        
        // swap pivot
        nums[right] = nums[low];
        nums[low] = pivot;
        
        if (low == nums.length - k) {
            return;
        } else if (low > nums.length - k) {                 // go left
            quickSelect(nums, left, low - 1, k);
        } else {                                            // go right
            quickSelect(nums, low + 1, right, k);
        }
    }
}