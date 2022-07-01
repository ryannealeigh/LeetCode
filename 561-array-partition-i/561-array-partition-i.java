class Solution {
    public int arrayPairSum(int[] nums) {
        // need to sort in non-descending order
        Arrays.sort(nums);
        
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += Math.min(nums[i], nums[i + 1]);
        }
        
        return sum;
    }
}