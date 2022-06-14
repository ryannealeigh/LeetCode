class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        int div = salary.length - 2;
        int total = 0;
        
        for (int i = 0; i < salary.length; i++) {
            int sal = salary[i];
            min = Math.min(min, sal);
            max = Math.max(max, sal);
            total += sal;
        }
        
        total -= min;
        total -= max;
        
        return (double) total / div;
    }
}