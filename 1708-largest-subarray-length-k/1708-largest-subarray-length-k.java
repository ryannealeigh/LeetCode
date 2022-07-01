class Solution {
    public int[] largestSubarray(int[] nums, int k) {
        int[] result = new int[k];
        
        int bestIndex = 0;
        for (int i = 1; i <= nums.length - k; i++) {
            if (nums[i] > nums[bestIndex]) {
                bestIndex = i;
            }
        }
        
        int index = 0;
        for (int i = bestIndex; i < bestIndex + k; i++) {
            result[index++] = nums[i];
        }
        
        return result;
    }
}