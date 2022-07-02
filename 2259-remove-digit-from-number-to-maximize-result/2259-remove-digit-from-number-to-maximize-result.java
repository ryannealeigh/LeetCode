class Solution {

    public String removeDigit(String number, char digit) {
        StringBuilder a = new StringBuilder(number);

        boolean found = false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == digit) {
                if (i < a.length() - 1 && a.charAt(i + 1) > a.charAt(i)) {
                    a.deleteCharAt(i);
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            for (int i = a.length() - 1; i >= 0; i--) {
                if (a.charAt(i) == digit) {
                    a.deleteCharAt(i);
                    break;
                }
            }
        }

        return a.toString();
    }
}
