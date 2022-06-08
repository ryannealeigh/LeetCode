class Solution {

    public int minSwaps(int[] data) {
        int count = 0;
        for (int i : data) {
            if (i == 1) {
                count++;
            }
        }
        
        if (count == 0) {
            return 0;
        }
        
        if (count <= 2) {
            return count - 1;
        }
        int min = Integer.MAX_VALUE;

        int currentCount = 0;
        int start = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 1) {
                currentCount++;
            }

            if (i >= count - 1) {
                int diff = count - currentCount;
                min = Math.min(min, diff);

                if (data[start++] == 1) {
                    currentCount--;
                }
            }
        }

        return min;
    }
}
