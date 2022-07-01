class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> Integer.compare(a[1], b[1]));
        
        int max = 0;
        int i = boxTypes.length - 1;
        while (truckSize > 0 && i >= 0) {
            max += boxTypes[i][1];
            boxTypes[i][0]--;
            truckSize--;
            if (boxTypes[i][0] == 0) {
                i--;
            }
        }
        
        return max;
    }
}