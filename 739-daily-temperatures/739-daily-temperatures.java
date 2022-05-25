class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        int hottest = 0;
        int count;

        for (int i = temperatures.length - 1; i >= 0; i--) {
            int currentTemp = temperatures[i];
            hottest = Math.max(hottest, currentTemp);
            if (hottest == currentTemp) {
                continue;
            }
            
            count = 1;
            while (temperatures[i + count] <= currentTemp) {
                count += result[i + count];
            }
            result[i] = count;
        }

        return result;
    }
}
