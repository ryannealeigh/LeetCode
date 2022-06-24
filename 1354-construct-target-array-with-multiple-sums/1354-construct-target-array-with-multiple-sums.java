class Solution {
    public boolean isPossible(int[] target) {
        if (target.length == 1 && target[0] != 1) {
            return false;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        
        int sum = 0;
        for (int i : target) {
            heap.add(i);
            sum += i;
        }
            
        while (heap.peek() > 1) {
            int curr = heap.poll();
            int rest = sum - curr;
            if (rest == 1) {
                return true;
            }
            
            int x = curr % rest;
            if (x == 0 || x == curr) {
                return false;
            }
            heap.add(x);
            sum += x - curr;
        }
        
        return true;
    }
}