class Solution {
    public int orangesRotting(int[][] grid) {
//         int n=grid.length;
//         int minutes=0;
//         if(grid[])
//         for(int i=0;i<n;i++){
            
//         }
        
        
//     }
//     void bfs(int[][] grid, int node,boolean[] visited){
//         Queue<Integer> queue=new LinkedList<>();
//         queue.add(node);
//         visited[node]=true;
//         while(!queue.isEmpty()){
//             int current=queue.poll();
//             for(int i=0;i<grid.length;i++){
//                 if(!visited[i] && grid[current][i]==1){
//                     queue.add(i);
//                     visited[i]=true;
//                 }
//             }
//         }
//     }
        if (grid == null || grid.length == 0) {
            return -1;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int freshOranges = 0;
        Queue<int[]> queue = new LinkedList<>();

        // Initialize the queue with all rotten oranges and count fresh oranges.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        // If there are no fresh oranges, return 0 as no time is needed.
        if (freshOranges == 0) {
            return 0;
        }

        int minutes = 0;
        // Directions array for moving in 4 directions (right, down, left, up).
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // BFS to rot adjacent fresh oranges.
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                for (int[] direction : directions) {
                    int newRow = current[0] + direction[0];
                    int newCol = current[1] + direction[1];
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.add(new int[]{newRow, newCol});
                        freshOranges--;
                    }
                }
            }
            minutes++;
        }

        // If there are still fresh oranges left, return -1, otherwise return minutes.
        return freshOranges == 0 ? minutes - 1 : -1;
    }
}
