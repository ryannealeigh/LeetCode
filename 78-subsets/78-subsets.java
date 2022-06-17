class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        backtrack(nums, new ArrayList<>(), 0, result);
        
        return result;
    }
    
    private void backtrack(int[] nums, List<Integer> curr, int index, List<List<Integer>> result) {
        result.add(new ArrayList<>(curr));
        
        for (int i = index; i < nums.length; i++) {            
            curr.add(nums[i]);
            backtrack(nums, curr, i + 1, result);
            curr.remove(curr.size() - 1);
        }
    }
}