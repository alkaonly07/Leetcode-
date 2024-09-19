class Solution {
    public int[] getOrder(int[][] tasks) {
        
     int n = tasks.length;
        
        // Store tasks as {enqueueTime, processingTime, index}
        int[][] taskWithIndex = new int[n][3];
        for (int i = 0; i < n; i++) {
            taskWithIndex[i][0] = tasks[i][0]; // enqueueTime
            taskWithIndex[i][1] = tasks[i][1]; // processingTime
            taskWithIndex[i][2] = i;           // index
        }
        
        // Sort the tasks by their enqueue time
        Arrays.sort(taskWithIndex, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Min-heap to store available tasks. 
        // Sort by processing time, then by index if there's a tie.
        PriorityQueue<int[]> availableTasks = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[2], b[2]); // by index
            }
            return Integer.compare(a[1], b[1]); // by processing time
        });
        
        int time = 0, i = 0; // i is the index in taskWithIndex
        List<Integer> order = new ArrayList<>();
        
        while (order.size() < n) {
            // Add all tasks whose enqueueTime <= current time to the heap
            while (i < n && taskWithIndex[i][0] <= time) {
                availableTasks.offer(taskWithIndex[i]);
                i++;
            }
            
            if (!availableTasks.isEmpty()) {
                // Get the task with the smallest processing time (and smallest index in case of a tie)
                int[] currentTask = availableTasks.poll();
                time += currentTask[1]; // Process this task
                order.add(currentTask[2]); // Add the original index of the task to the result
            } else {
                // If no task is available, fast-forward the time to the enqueue time of the next task
                time = taskWithIndex[i][0];
            }
        }
        
        // Convert the order to an array and return
        return order.stream().mapToInt(Integer::intValue).toArray();
    }
}