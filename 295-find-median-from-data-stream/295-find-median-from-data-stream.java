class MedianFinder {
    PriorityQueue<Integer> low;
    PriorityQueue<Integer> high;

    public MedianFinder() {
        low = new PriorityQueue<>(Comparator.reverseOrder());
        high = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (low.isEmpty()) {
            low.add(num);
        } else if (num > low.peek()) {
            high.add(num);
        } else {
            low.add(num);
        }

        if (low.size() < high.size()) {
            low.add(high.poll());
        }
        
        if (high.size() < low.size() - 1) {
            high.add(low.poll());
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