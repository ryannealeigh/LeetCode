class Solution {
    public List<Integer> minSubsequence(int[] nums) {        
        int[] countSort = new int[101];
        int sum = 0;
        for (int num : nums) {
            countSort[num]++;
            sum += num;
        }
        
        List<Integer> result = new ArrayList<>();
        int resultSum = 0;
        for (int i = 100; i >= 1; i--) {
            while (countSort[i] > 0) {
                countSort[i]--;
                result.add(i);
                resultSum += i;
                sum -= i;
                if (resultSum > sum) {
                    break;
                }
            }
            
            if (resultSum > sum) {
                break;
            }
        }
        
        return result;
    }
}