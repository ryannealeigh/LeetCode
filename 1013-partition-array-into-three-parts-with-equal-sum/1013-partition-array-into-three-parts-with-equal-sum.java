class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        // find total sum of the array and divide by 3 for target
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        
        if (sum % 3 != 0) {
            return false;
        }
        
        int target = sum / 3;
        
        int currTotal = 0;
        int count = 0;
        int i;
        for (i = 0; i < arr.length; i++) {
            currTotal += arr[i];
            if (count < 2 && currTotal == target) {
                currTotal = 0;
                count++;
            }
            if (count == 2) {
                i++;
                break;
            }
        }
        
        if (i == arr.length) {
            return false;
        }
        
        for (i = i; i < arr.length; i++) {
            currTotal += arr[i];
        }
        
        return currTotal == target && count == 2;
    }
}