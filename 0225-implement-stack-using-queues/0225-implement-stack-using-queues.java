class MyStack {
    Queue<Integer> queue;
    Queue<Integer> queue2;
    

    public MyStack() {
        this.queue=new LinkedList<>();
        this.queue2=new LinkedList<>();
    }
    
    public void push(int x) {
        queue2.add(x);
        while (!queue.isEmpty()) {
            queue2.add(queue.remove());
        }
        Queue<Integer> temp = queue;
        queue = queue2;
        queue2 = temp;
        
    }
    
    public int pop() {
        if(empty()){
            return -1;
        }
        else{
            return queue.remove();
        }  
    }
    public int top() {
        if(empty()){
            return -1;
        }
        else{
            return queue.peek();
        } 
    }
    
    public boolean empty() {
       if (queue.isEmpty()){
            return true;
        } 
        else{
            return false;
        }
    }
}


/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */