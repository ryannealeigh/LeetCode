class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        
        HashSet<Integer> used;
        // we want to start at each index for all possible permutations
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<Integer>(), new HashSet<Integer>(), result);
        
        return result;
    }
    
    private void backtrack(int[] nums, List<Integer> curr, HashSet<Integer> used, List<List<Integer>> result) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!used.contains(i)) {
                used.add(i);
                curr.add(nums[i]);
                backtrack(nums, curr, used, result);
                used.remove(i);
                curr.remove(curr.size() - 1);
            }
        }
    }
}