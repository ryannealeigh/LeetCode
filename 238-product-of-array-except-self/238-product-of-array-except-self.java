class Solution {
    // can't divide so we need to compute prefix and suffix products
    // the result array doesn't count as extra space, so we can store our data there
    
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        
        // compute the prefixes
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = product;
            product *= nums[i];
        }
        
        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * product;
            product *= nums[i];
        }
        
        return result;
    }
}