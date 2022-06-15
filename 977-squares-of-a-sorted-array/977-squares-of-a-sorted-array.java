class Solution {
    public int[] sortedSquares(int[] nums) {
        // two pointer at beginning and end of array
        // select largest absolute value
        // insert to end of result array
        int[] result = new int[nums.length];
        
        int i = 0, j = nums.length - 1;
        
        int write = nums.length - 1;
        
        while (i <= j) {
            if (Math.abs(nums[i]) >= Math.abs(nums[j])) {
                result[write--] = nums[i] * nums[i];
                i++;
            } else {
                result[write--] = nums[j] * nums[j];
                j--;
            }
        }
        
        return result;
    }
}