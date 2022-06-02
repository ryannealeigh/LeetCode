class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        int i = 0;
        int n = nums.length;
        
        backtrack(i, n, current, result, nums);
        
        return result;
    }
    
    private void backtrack(int i, int n, List<Integer> current, List<List<Integer>> result, int[] nums) {
        if (i == n) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        backtrack(i + 1, n, current, result, nums);
        current.add(nums[i]);
        backtrack(i + 1, n, current, result, nums);
        current.remove(current.size() - 1);
    }
}