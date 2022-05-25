class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int start = 0;
        
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            while (!deque.isEmpty() && current > nums[deque.peekFirst()]) {
                deque.pollFirst();
            }
            deque.offerFirst(i);
            
            if (i >= k - 1) {
                result[index++] = nums[deque.peekLast()];
                if (i + 1 - k == deque.peekLast()) {
                    deque.pollLast();
                }
            }
        }
        
        return result;
    }
}