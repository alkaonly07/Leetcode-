class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack=new Stack<>();
        int sum=0;
        for(String val:operations){
            if(val.equals("C")){
                sum-=stack.pop();
            }
            else if(val.equals("D")){
                int s=stack.peek();
                stack.push(s*2);
                sum+=s*2;
            }
            else if(val.equals("+")){
                int pop1=stack.pop();
                int peek1=stack.peek();
                stack.push(pop1);
                stack.push(pop1+peek1);
                sum+=pop1+peek1;
            }
            else{
                int value=Integer.parseInt(val);
                stack.push(value);
                sum+=value;
            }
        }
        return sum;
        
    }
}