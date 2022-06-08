class Solution {

    public int minSwaps(int[] data) {
        int count = 0;
        for (int i : data) {
            count += i;
        }
        
        if (count == 0) {
            return 0;
        } else if (count <= 2) {
            return count - 1;
        }
        int min = Integer.MAX_VALUE;

        int currentCount = 0;
        int start = 0;
        for (int i = 0; i < data.length; i++) {
            currentCount += data[i];
            if (i >= count - 1) {
                min = Math.min(min, count - currentCount);
                currentCount -= data[start++];
            }
        }

        return min;
    }
}
