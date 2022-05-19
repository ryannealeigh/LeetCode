class Solution {

    public int lengthOfLongestSubstring(String s) {
        int start = 0, length = 0;

        char[] map = new char[256];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map[c]++;

            // need to move start forward until we get rid of this character previously
            if (map[c] > 1) {
                while (map[c] > 1) {
                    char sc = s.charAt(start);
                    map[sc]--;
                    start++;
                }
            }

            length = Math.max(length, i - start + 1);
        }

        return length;
    }
}
