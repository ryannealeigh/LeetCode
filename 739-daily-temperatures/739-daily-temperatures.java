class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        int hottest = 0;
        int count;

        for (int i = temperatures.length - 1; i >= 0; i--) {
            int currentTemp = temperatures[i];
            hottest = Math.max(hottest, currentTemp);
            count = 1;
            if (hottest == currentTemp) {
                result[i] = 0;
            } else {
                while (i + count < temperatures.length && temperatures[i + count] <= currentTemp) {
                    if (result[i + count] == 0) {
                        count = 0;
                        break;
                    }
                    count += result[i + count];
                }
                result[i] = count;
            }
            
        }

        return result;
    }
}
