class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : stones) {
            heap.add(i);
        }
        
        while (heap.size() > 1) {
            int x = heap.poll(); // largest
            int y = heap.poll(); // 2nd largest
            
            if (x != y) {
                heap.add(x - y);
            }
        }
        
        if (heap.size() == 0) {
            return 0;
        } else {
            return heap.poll();
        }
    }
}