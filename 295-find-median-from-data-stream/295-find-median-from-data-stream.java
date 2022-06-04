class MedianFinder {
    PriorityQueue<Integer> low;
    PriorityQueue<Integer> high;

    public MedianFinder() {
        low = new PriorityQueue<>(Comparator.reverseOrder());
        high = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        low.add(num);
        high.add(low.poll());

        if (high.size() > low.size()) {
            low.add(high.poll());
        }
    }
    
    public double findMedian() {
        if (low.size() > high.size()) {
            return low.peek();
        } else {
            return (low.peek() + high.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */