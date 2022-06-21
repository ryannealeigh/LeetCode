class Solution {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        int i = 0;
        int totalDiff = 0;
        int kLargest = 0;
        for (i = 0; i < heights.length - 1; i++) {
            if (heights[i] >= heights[i + 1]) {
                continue;
            }

            int diff = heights[i + 1] - heights[i];
            totalDiff += diff;
            kLargest += diff;

            heap.add(diff);
            if (heap.size() > ladders) {
                int num = heap.poll();
                kLargest -= num;
            }

            if (totalDiff - kLargest > bricks) {
                break;
            }
        }

        return i;
    }
}
