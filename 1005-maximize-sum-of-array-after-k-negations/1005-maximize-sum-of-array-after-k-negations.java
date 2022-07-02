class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int sum = 0;
        for (int num : nums) {
            sum += num;
            heap.add(num);
        }
        
        for (int i = 0; i < k; i++) {
            int val = heap.poll();
            sum -= val;
            val *= -1;
            sum += val;
            heap.add(val);
        }
        
        return sum;
    }
}