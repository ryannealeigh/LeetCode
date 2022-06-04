class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        HashSet<List<Integer>> results = new HashSet<>();
        int n = candidates.length;
        ArrayList<Integer> sums = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            backtrack(candidates, i, 0, sums, results, target);
        }
        
        Iterator<List<Integer>> iter = results.iterator();
        
        List<List<Integer>> result = new ArrayList<>();
        while (iter.hasNext()) {
            result.add(iter.next());
        }
        
        return result;
    }
    
    private void backtrack(int[] candidates, int i, int sum, ArrayList<Integer> sums, HashSet<List<Integer>> results, int target) {    
        if (sum == target) {
            results.add(new ArrayList<Integer>(sums));
            return;
        }
        if (i == candidates.length) {
            if (sum == target) {
                results.add(new ArrayList<Integer>(sums));
            } 
            return;
        }
        
        // choose candidates[i]
        int val = candidates[i];
        if (sum + val <= target) {
            sums.add(val);
            backtrack(candidates, i, sum + val, sums, results, target);
            sums.remove(sums.size() - 1);
        }
        
        // don't choose candidates[i] and move i forward
        backtrack(candidates, i + 1, sum, sums, results, target);
    }
}
