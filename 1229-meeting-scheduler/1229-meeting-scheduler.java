class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        Arrays.sort(slots1, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(slots2, (a, b) -> Integer.compare(a[0], b[0]));
        
        while (i < slots1.length && j < slots2.length) {            
            if (slots1[i][0] > slots2[j][1] || slots1[i][0] + duration > slots2[j][1] || slots2[j][0] + duration > slots2[j][1]) {
                j++;
            } else if (slots2[j][0] > slots1[i][1] || slots2[j][0] + duration > slots1[i][1] || slots1[i][0] + duration > slots1[i][1]) {
                i++;
            } else {
                int start = Math.max(slots1[i][0], slots2[j][0]);
                int end = start + duration;
                result.add(start);
                result.add(end);
                return result;
            }
        }
        
        return result;
    }
}