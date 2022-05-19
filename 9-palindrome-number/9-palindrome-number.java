class Solution {

    public boolean isPalindrome(int x) {
        String integer = Integer.toString(x);

        System.out.println(integer);
        int mid = integer.length() / 2;

        return integer.substring(0, integer.length() % 2 == 0 ? mid : mid + 1).equals(new StringBuilder(integer.substring(mid, integer.length())).reverse().toString());
    }
}
