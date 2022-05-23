class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> results = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            twoSum(nums, nums[i], i + 1, nums.length - 1, results);
        }
        
        return new ArrayList<List<Integer>>(results);
    }
    
    private void twoSum(int[] nums, int i, int left, int right, HashSet<List<Integer>> results) {
        int target = -i;
        
        while (left < right) {
            int leftNum = nums[left], rightNum = nums[right];
            int sum = leftNum + rightNum;
            if (sum == target) {
                results.add(List.of(i, leftNum, rightNum));
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}