class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        HashSet<Integer> uniqueCounts = new HashSet<>();
        
        for (int i : arr) {
            counts.put(i, counts.getOrDefault(i, 0) + 1);
        }
        
        for (int i : counts.keySet()) {
            int count = counts.get(i);
            if (uniqueCounts.contains(count)) {
                return false;
            }
            uniqueCounts.add(count);
        }
        
        return true;
    }
}