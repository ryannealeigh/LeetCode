class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<List<Integer>> pairs = new ArrayList<>();
        
        for (int i = 0; i < position.length; i++) {
            pairs.add(List.of(position[i], speed[i]));
        }
        
        Collections.sort(pairs, (a, b) -> a.get(0) - b.get(0));
        int n = pairs.size();
        
        double slowest = ((double) target - pairs.get(n - 1).get(0)) / pairs.get(n - 1).get(1);
        int count = 1;
        
        for (int i = n - 2; i >= 0; i--) {
            double timeToTarget = ((double) target - pairs.get(i).get(0)) / pairs.get(i).get(1);

            if (timeToTarget > slowest) {
                slowest = timeToTarget;
                count++;
            }
        }
        
        return count;
    }
}