class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // can sort it but this is worse than just counting
        // can do a hashmap count for each input
        // if already sorted, don't need to count at all
        // would just iterate with two pointers and add to result
        // while the value is the same
        // if nums2 is on disk and memory is constrained, I would process chunks
        // this would mean grabbing every value in a certain range, not splitting in the middle of a run
        // of values
        ArrayList<Integer> result = new ArrayList<>();
        
        HashMap<Integer, Integer> count1 = new HashMap<>();
        HashMap<Integer, Integer> count2 = new HashMap<>();
        
        for (int num : nums1) {
            count1.put(num, count1.getOrDefault(num, 0) + 1);
        }
        
        for (int num : nums2) {
            count2.put(num, count2.getOrDefault(num, 0) + 1);
        }

        for (Integer num : count1.keySet()) {
            int one = count1.get(num);
            int two = count2.getOrDefault(num, 0);
            
            for (int i = 0; i < Math.min(one, two); i++) {
                result.add(num);
            }
        }
        
        int[] arr = new int[result.size()];
        
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        
        return arr;
    }
}