class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        List<Integer> result = new ArrayList<>();
        int resultSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            result.add(nums[i]);
            resultSum += nums[i];
            sum -= nums[i];
            if (resultSum > sum) {
                break;
            }
        }
        
        return result;
    }
}