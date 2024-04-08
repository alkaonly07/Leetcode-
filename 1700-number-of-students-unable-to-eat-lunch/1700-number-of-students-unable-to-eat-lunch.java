class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
    int len = students.length; 
    Queue<Integer> queue = new LinkedList<>();
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < len; i++) {
        stack.push(sandwiches[len - i - 1]);
        queue.offer(students[i]);
    }
    int last = 0;
    while (queue.size() > 0 && last < queue.size()) {
        if (stack.peek() == queue.peek()) {
            stack.pop();
            queue.poll();
            last = 0;
        } else{
            queue.offer(queue.poll()); 
            last++;
        }
    }
    return queue.size();
    }
}