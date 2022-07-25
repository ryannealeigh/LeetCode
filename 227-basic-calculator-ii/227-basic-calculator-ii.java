class Solution {

    public int calculate(String s) {
        // one sweep for multiplication and division
        // one sweep for addition and substraction
        // split string on operators

        String[] split = s.split("[-+*/]");

        int i = 0;

        ArrayDeque<String> stack = new ArrayDeque<>();
        HashSet<Character> operators = new HashSet<>();
        operators.add('*');
        operators.add('-');
        operators.add('+');
        operators.add('/');

        int start = 0;
        while (i < s.length()) {
            while (i < s.length() && !operators.contains(s.charAt(i))) {
                i++;
            }

            // if stack contains a value and current operator is multiply or divide, handle it now
            if (!stack.isEmpty() && (stack.peekLast().equals("*") || stack.peekLast().equals("/"))) {
                String op = stack.pollLast();

                long prevLong = Long.parseLong(stack.pollLast().trim());
                long currLong = Long.parseLong(s.substring(start, i).trim());
                long intermediate = prevLong;

                if (op.equals("*")) {
                    intermediate *= currLong;
                    stack.add(Long.toString(intermediate));
                } else {
                    intermediate /= currLong;
                    stack.add(Long.toString(intermediate));
                }
            } else { // if stack is empty or current operator is not * or /
                String sub = s.substring(start, i);
                stack.add(sub);
            }

            start = i;

            // still have an operator here to add
            if (i < s.length()) {
                String sub = s.substring(start, start + 1);
                stack.add(sub);
                start++;
                i++;
            }
        }

        // System.out.println(stack.toString());
        while (stack.size() > 1) {
            long prevLong = Long.parseLong(stack.pollFirst().trim());
            String op = stack.pollFirst().trim();
            long currLong = Long.parseLong(stack.pollFirst().trim());

            long intermediate = prevLong;

            if (op.equals("-")) {
                intermediate -= currLong;
                stack.addFirst(Long.toString(intermediate));
            } else {
                intermediate += currLong;
                stack.addFirst(Long.toString(intermediate));
            }
        }

        return Integer.parseInt(stack.peek().trim());
    }
}
