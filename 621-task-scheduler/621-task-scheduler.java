class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> counts = new HashMap<>();
        for (char task : tasks) {
            counts.put(task, counts.getOrDefault(task, 0) + 1);
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (Character key : counts.keySet()) {
            maxHeap.add(counts.get(key));
        }
        
        ArrayDeque<List<Integer>> queue = new ArrayDeque<>();
        
        int count = 0;
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            count++;

            if (!maxHeap.isEmpty()) {
                int current = maxHeap.poll();
                current--;
                if (current > 0) {
                    queue.add(List.of(current--, count + n));
                }
            }
            
            if (!queue.isEmpty()) {
                if (queue.peek().get(1) == count) {
                    maxHeap.add(queue.poll().get(0));
                }
            }
        }
        
        return count;
    }
}