class Solution {
    public List<List<Integer>> permute(int[] nums) {        
        boolean[] used = new boolean[nums.length];
        // we want to start at each index for all possible permutations
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<Integer>(), used, result);
        
        return result;
    }
    
    private void backtrack(int[] nums, List<Integer> curr, boolean[] used, List<List<Integer>> result) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                curr.add(nums[i]);
                backtrack(nums, curr, used, result);
                used[i] = false;
                curr.remove(curr.size() - 1);
            }
        }
    }
}