class Solution {
    public boolean isValid(String s) {
//         Stack<Character> stack=new Stack<>();
//         for(char c:s.toCharArray()){
//             if(c=='(' || c=='{' || c==']' ){
//                 stack.push(c);
//             }
//             else{
//                 if(stack.isEmpty())
//                     return false;
                
//             char popped=stack.pop();
//                 if((c=='(' && popped!=')') ||( c=='[' && popped!=']')||(c=='{' && popped!='}')){
//                     return false;
//                 }
//             }
//         }
//         return stack.isEmpty();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                // Push opening brackets onto the stack
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    // If stack is empty, there's no corresponding opening bracket
                    return false;
                }
                char top = stack.pop();
                // Check if the popped bracket matches the current closing bracket
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        // If the stack is not empty after iterating through the string, there are unmatched opening brackets
        return stack.isEmpty();
        
    }
}