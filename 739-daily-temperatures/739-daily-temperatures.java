class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        int hottest = 0;
        int count;

        for (int i = temperatures.length - 1; i >= 0; i--) {
            if (hottest <= temperatures[i]) {
                hottest = temperatures[i];
                continue;
            }
            
            count = 1;
            while (temperatures[i + count] <= temperatures[i]) {
                count += result[i + count];
            }
            result[i] = count;
        }

        return result;
    }
}
