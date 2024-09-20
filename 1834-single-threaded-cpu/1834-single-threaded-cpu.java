class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] taskWithIndex = new int[n][3];
        for(int i=0;i<n;i++){
            taskWithIndex[i][0] = tasks[i][0];
            taskWithIndex[i][1] = tasks[i][1];
            taskWithIndex[i][2] = i;     
        }
        Arrays.sort(taskWithIndex,(a,b) -> Integer.compare(a[0],b[0]));
        
        PriorityQueue<int[]> availableTask = new PriorityQueue<>((a,b) -> {
            if(a[1]==b[1]){
                return Integer.compare(a[2],b[2]);
            }
            return Integer.compare(a[1],b[1]);
        });
        int i = 0;
        int time = 0;
        List<Integer> order = new ArrayList<>();
        while(order.size()<n){
            while(i<n && taskWithIndex[i][0] <= time){
                availableTask.offer(taskWithIndex[i]);
                i++;
            }
            if(!availableTask.isEmpty()){
                int[] current = availableTask.poll();
                time += current[1];
                order.add(current[2]);
            }
            else{
                time = taskWithIndex[i][0];
            }
        }
        return order.stream().mapToInt(Integer::intValue).toArray();
        
     }
}