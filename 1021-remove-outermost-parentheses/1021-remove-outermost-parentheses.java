class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        // Stack<Character> stack = new Stack<>();
        int count = 0;
        for(char c : s.toCharArray()){
            if(c =='('){
                // if(!stack.isEmpty()){
                //     result.append(c);
                // }
                if(count>0){
                    result.append(c);
                }
                // stack.push(c);
                count++;
            }
            if(c ==')'){
                // stack.pop();
                count--;
                // if(!stack.isEmpty()){
                //     result.append(c);
                // }
                if(count>0){
                    result.append(c);
                }
            }
        }
        return result.toString();
    }
}