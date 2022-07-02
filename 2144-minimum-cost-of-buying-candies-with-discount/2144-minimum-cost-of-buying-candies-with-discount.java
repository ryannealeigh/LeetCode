class Solution {

    public int minimumCost(int[] costs) {
        int[] counts = new int[101];
        
        for (int cost : costs) {
            counts[cost]++;
        }
        
        int count = 0;
        int sum = 0;
        for (int i = 100; i >= 1; i--) {
            while (counts[i] > 0) {
                counts[i]--;
                count++;
                if (count % 3 == 0) {
                    continue;
                }
                sum += i;
            }
        }

        return sum;
    }
}
