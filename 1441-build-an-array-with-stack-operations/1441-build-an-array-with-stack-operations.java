class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> s= new ArrayList<>();
        int k=0;
        Stack<Integer> stack=new Stack<>();
        for(int i=1;i<=n;i++){
            stack.push(i);
            s.add("Push");
            if(stack.peek()!=target[k]){
                stack.pop();
                s.add("Pop");
                k--;
            }
            if(k==target.length-1){
                break;
            }
            k++;
        }  
        return s;
    }
}