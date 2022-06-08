class Solution {
    public int minSwaps(int[] data) {
        int count = 0;
        for (int i : data) {
            if (i == 1) {
                count++;
            }
        }
        int min = Integer.MAX_VALUE;
        
        int currentCount = 0;
        int start = 0;
        for (int i = 0; i < data.length; i++) {
            // add next element
            if (data[i] == 1) {
                currentCount++;
            }
            
            // if index is greater or equal to our window size
            if (i >= count - 1) {
                // check diff
                int diff = count - currentCount;
                min = Math.min(min, diff);
                
                // move start forward one element
                if (data[start++] == 1) {
                    currentCount--;
                }
            }
        }
        
        return min;
    }
}