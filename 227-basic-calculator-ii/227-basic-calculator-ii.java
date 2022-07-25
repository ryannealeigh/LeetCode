class Solution {

    public int calculate(String s) {
        // one sweep for multiplication and division
        // one sweep for addition and substraction
        // split string on operators

        String str = s.replace(" ", "");
        String[] split = str.split("(?=[-+*/])|(?<=[-+*/])");
        System.out.println(Arrays.toString(split));

        ArrayDeque<String> stack = new ArrayDeque<>();

        for (String val : split) {
            // if stack contains a value and current operator is multiply or divide, handle it now
            if (!stack.isEmpty() && (stack.peekLast().equals("*") || stack.peekLast().equals("/"))) {
                String op = stack.pollLast();
                long prevLong = Long.parseLong(stack.pollLast());
                long currLong = Long.parseLong(val);
                
                long intermediate = prevLong;

                if (op.equals("*")) {
                    intermediate *= currLong;
                    stack.add(Long.toString(intermediate));
                } else {
                    intermediate /= currLong;
                    stack.add(Long.toString(intermediate));
                }
            } else { // if stack is empty or current operator is not * or /
                stack.add(val);
            }
        }

        System.out.println(stack.toString());
        while (stack.size() > 1) {
            long prevLong = Long.parseLong(stack.pollFirst());
            String op = stack.pollFirst();
            long currLong = Long.parseLong(stack.pollFirst());

            long intermediate = prevLong;

            if (op.equals("-")) {
                intermediate -= currLong;
                stack.addFirst(Long.toString(intermediate));
            } else {
                intermediate += currLong;
                stack.addFirst(Long.toString(intermediate));
            }
        }

        return Integer.parseInt(stack.peek());
    }
}
