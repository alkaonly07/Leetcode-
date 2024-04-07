class Solution {
    public boolean checkValidString(String s) {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == '*') {
                stack2.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else if (!stack2.isEmpty()) {
                    stack2.pop();
                } else {
                    return false; 
                }
            }
        }
        while (!stack.isEmpty() && !stack2.isEmpty()) {
            if (stack.peek() > stack2.peek()) {
                return false;
            }
            stack.pop();
            stack2.pop();
        }
        return stack.isEmpty();
        
    }
}