class Solution {
    public String decodeString(String s) {
        int n = s.length();
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char currentChar = s.charAt(i);

            if (currentChar == ']') {
                StringBuilder temp = new StringBuilder();
                // Pop characters until '[' is encountered
                while (!stack.isEmpty() && stack.peek() != '[') {
                    temp.insert(0, stack.pop());
                }
                // Remove the '[' from the stack
                stack.pop();

                // Extract and parse the repeat count
                StringBuilder countStr = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    countStr.insert(0, stack.pop());
                }
                int repeatCount = Integer.parseInt(countStr.toString());

                // Repeat the decoded string and push it back onto the stack
                String decodedStr = temp.toString();
                for (int j = 0; j < repeatCount; j++) {
                    for (char ch : decodedStr.toCharArray()) {
                        stack.push(ch);
                    }
                }
            } else {
                stack.push(currentChar);
            }
        }

        // Build the result from the stack
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }

        return res.toString();
    }
}
