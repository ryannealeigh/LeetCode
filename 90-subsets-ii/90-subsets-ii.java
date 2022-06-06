class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        backtrack(nums, 0, nums.length, new ArrayList<Integer>(), result);
        return new ArrayList<>(result);
    }
    
    private void backtrack(int[] nums, int index, int n, ArrayList<Integer> curr, List<List<Integer>> result) {
        result.add(new ArrayList<>(curr));
        
        for (int i = index; i < n; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            curr.add(nums[i]);
            backtrack(nums, i + 1, n, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}