class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        int newSlow = 0;
        while (slow != newSlow) {
            slow = nums[slow];
            newSlow = nums[newSlow];
        }
        
        return slow;
    }
}