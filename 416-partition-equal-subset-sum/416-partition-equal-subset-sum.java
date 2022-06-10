class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % 2 != 0) {
            return false;
        }
        
        
        int target = sum / 2;
        HashSet<Integer> results = new HashSet<>();
        ArrayList<Integer> temp;
        results.add(0);
        for (int num : nums) {
            temp = new ArrayList<>(results);
            for (int i : temp) {
                results.add(num + i);
            }
        }
        
        if (results.contains(target)) {
            return true;
        }
        return false;
    }
}