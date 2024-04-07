class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder result=new StringBuilder();
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                stack.push(i);
            }
            else if(c==')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    s=s.substring(0,i)+s.substring(i+1);
                    i--;
                }
            }
        }
        while(!stack.isEmpty()){
        int index=stack.pop();
        s=s.substring(0,index)+s.substring(index+1);
        }
        return s;

    }
}