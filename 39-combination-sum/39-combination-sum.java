class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<>();
        
        backtrack(candidates, 0, 0, new ArrayList<Integer>(), results, target);
                
        return results;
    }
    
    private void backtrack(int[] candidates, int i, int sum, ArrayList<Integer> curr, List<List<Integer>> results, int target) {    
        if (sum == target) {
            results.add(new ArrayList<Integer>(curr));
            return;
        }
        if (i == candidates.length || sum > target || candidates[i] > target) {
            return;
        }
        
        // choose candidates[i]
        curr.add(candidates[i]);
        backtrack(candidates, i, sum + candidates[i], curr, results, target);
        curr.remove(curr.size() - 1);
        
        // don't choose candidates[i] and move i forward
        backtrack(candidates, i + 1, sum, curr, results, target);
    }
}
