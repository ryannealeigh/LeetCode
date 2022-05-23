class Solution {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        HashSet<Integer> numset = new HashSet<>();
        for (int num : nums) {
            numset.add(num);
        }

        int max = 1;

        for (Integer num : numset) {
            if (!numset.contains(num - 1)) {
                int count = 1;
                int curr = num;

                while (numset.contains(curr + 1)) {
                    curr++;
                    count++;
                    max = Math.max(max, count);
                }
            }
        }

        return max;
    }
}
