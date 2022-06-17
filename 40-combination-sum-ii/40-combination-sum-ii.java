class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, new ArrayList<>(), 0, result);
        
        return result;
    }
    
    private void backtrack(int[] candidates, int remaining, List<Integer> curr, int index, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            int val = candidates[i];
            if (remaining - val < 0) {
                break;
            }

            curr.add(val);
            backtrack(candidates, remaining - val, curr, i + 1, result);
            curr.remove(curr.size() - 1);
        }
    }
}