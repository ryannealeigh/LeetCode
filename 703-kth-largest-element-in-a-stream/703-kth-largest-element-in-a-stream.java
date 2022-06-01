class KthLargest {
    PriorityQueue<Integer> heap;
    int k;
    
    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>();

        for (int i : nums) {                    // add all values to heap
            heap.add(i);
        }
        
        while (heap.size() > k) {               // discard all but k values from heap
            heap.poll();
        }
        this.k = k;
    }
    
    public int add(int val) {
        heap.add(val);                          // add newest value to heap
        if (heap.size() > k)
            heap.poll();                        // discard lowest value, leaving k top values
        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */