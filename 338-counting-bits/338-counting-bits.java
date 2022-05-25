class Solution {

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        String binary;
        for (int i = 0; i <= n; i++) {
            binary = Integer.toBinaryString(i);

            int count = 0;
            for (int j = 0; j < binary.length(); j++) {
                if (binary.charAt(j) == '1') {
                    count++;
                }
            }
            ans[i] = count;
        }

        return ans;
    }
}
