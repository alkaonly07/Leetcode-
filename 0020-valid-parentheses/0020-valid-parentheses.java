class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }
            else{
                    if(stack.isEmpty()){
                        return false;
            }
            
            char stackch = stack.pop();
            if ((ch == ')' && stackch != '(') ||
                    (ch == ']' && stackch != '[') ||
                    (ch == '}' && stackch != '{')) {
                    return false;
                }
        }
        }
        
        return stack.isEmpty();
        
    }
}