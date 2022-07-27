class Solution {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        HashMap<Integer, StringBuilder> map = new HashMap<>();

        for (int i = 0; i < numRows; i++) {
            map.put(i, new StringBuilder());
        }

        int row = 0;
        boolean down = true;

        for (int i = 0; i < s.length(); i++) {
            map.get(row).append(s.charAt(i));

            if (down && row == numRows - 1) {
                down = false;
            }
            if (!down && row == 0) {
                down = true;
            }

            if (down) {
                row++;
            } else {
                row--;
            }
        }

        StringBuilder result = map.get(0);

        for (int i = 1; i < numRows; i++) {
            result.append(map.get(i));
        }

        return result.toString();
    }
}
