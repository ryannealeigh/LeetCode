class Solution {

    public int threeSumClosest(int[] nums, int target) {
        // add up all 3 tuples in nums and compare diff to target
        // sort first then do two pointer for O(n^2) TC

        Arrays.sort(nums);
        int best = 0;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;

            int currTarget = target - nums[i];
            while (left < right) {
                int sum = nums[left] + nums[right];
                int diff = Math.abs(currTarget - sum);
                if (diff < minDiff) {
                    minDiff = diff;
                    best = sum + nums[i];
                }

                if (sum == currTarget) {
                    return target;
                } else if (sum < currTarget) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return best;
    }
}
