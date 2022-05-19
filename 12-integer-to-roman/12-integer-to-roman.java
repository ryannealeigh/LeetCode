class Solution {

    public String intToRoman(int num) {
        if (num > 3999 || num < 1) return null;
        StringBuilder sb = new StringBuilder();

        int count = 1;

        while (num > 0) {
            int digit = num % 10;
            num /= 10;

            if (count == 1) {
                if (digit == 4) {
                    sb.append("IV");
                } else if (digit == 9) {
                    sb.append("IX");
                } else if (digit >= 5) {
                    sb.append("V");
                    digit -= 5;
                }
                if (digit < 4) {
                    for (int i = 1; i <= digit; i++) {
                        sb.append("I");
                    }
                }
            }

            if (count == 2) {
                int insert = 0;
                if (digit == 4) {
                    sb.insert(insert, "XL");
                } else if (digit == 9) {
                    sb.insert(insert, "XC");
                } else if (digit >= 5) {
                    sb.insert(insert++, "L");
                    digit -= 5;
                }
                if (digit < 4) {
                    for (int i = 1; i <= digit; i++) {
                        sb.insert(insert, "X");
                    }
                }
            }

            if (count == 3) {
                int insert = 0;
                if (digit == 4) {
                    sb.insert(insert, "CD");
                } else if (digit == 9) {
                    sb.insert(insert, "CM");
                } else if (digit >= 5) {
                    sb.insert(insert++, "D");
                    digit -= 5;
                }
                if (digit < 4) {
                    for (int i = 1; i <= digit; i++) {
                        sb.insert(insert, "C");
                    }
                }
            }

            if (count == 4) {
                int insert = 0;
                for (int i = 1; i <= digit; i++) {
                    sb.insert(insert, "M");
                }
            }
            count++;
        }
        return sb.toString();
    }
}
