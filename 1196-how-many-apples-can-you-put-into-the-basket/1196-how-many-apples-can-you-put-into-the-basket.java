class Solution {
    public int maxNumberOfApples(int[] weight) {
        int[] count = new int[1001];
        
        for (int val : weight) {
            count[val]++;
        }
        
        // take smallest apples until 5000 units are used up
        int basketCapacity = 5000;
        int units = 0;
        for (int i = 1; i <= 1000; i++) {
            while (count[i] > 0 && basketCapacity >= i) {
                count[i]--;
                units++;
                basketCapacity -= i;
            }
            
            if (basketCapacity < i) {
                break;
            }
        }
        
        return units;
    }
}