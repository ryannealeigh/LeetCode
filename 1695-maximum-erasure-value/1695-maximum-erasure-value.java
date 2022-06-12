class Solution {
    // maximum sum subarray with unique elements
    // sliding window with hashmap or table of character counts
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        
        int sum = 0, start = 0;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            sum += current;
            counts.put(current, counts.getOrDefault(current, 0) + 1);
            
            while (start < i && counts.get(current) > 1) {
                int si = nums[start];
                sum -= si;
                start++;
                // remove from the sum
                // move start forward
                // lower the count
                counts.put(si, counts.get(si) - 1);
            }
            
            // get max from old max and current sum
            max = Math.max(max, sum);
        }
        
        return max;
    }
}