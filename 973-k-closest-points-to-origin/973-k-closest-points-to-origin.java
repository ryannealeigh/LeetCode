class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Double.compare(Math.sqrt(a[0] * a[0] + a[1] * a[1]), Math.sqrt(b[0] * b[0] + b[1] * b[1])));
        
        for (int[] point : points) {
            heap.add(point);
        }
        
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }
        
        return result;
    }
}