class MinStack {
    int[] arr;
    int topOfStack;

    public MinStack() {
        this.arr=new int[1000];
        this.topOfStack=-1;
        
    }
    
    public void push(int val) {
        if(topOfStack==arr.length-1){
            return;
        }
        topOfStack++;
        arr[topOfStack]=val;
    }
    
    public void pop() {
        if(topOfStack==-1){
            return;
        }
        else{
            int topStack=arr[topOfStack];
            topOfStack--;
        }
     
    }
    
    public int top() {
        if(topOfStack==-1){
            return -1;
        }
        else{
            return arr[topOfStack];
        }
    
    }
    
    public int getMin() {
        if(topOfStack==-1){
            return -1;
        }
        else{
            int count=0;
            int min=Integer.MAX_VALUE;
            while(count<=topOfStack){
                if(arr[count]<min){
                    min=arr[count];
                }
                count++;
            }
            return min;
        }
        
    }
    
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */