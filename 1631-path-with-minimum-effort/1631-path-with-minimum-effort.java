class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] effort = new int[rows][cols];
        
        // Initialize the effort array with a large value
        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        // Use a PriorityQueue to process cells by their minimum effort
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0, 0, 0}); // {row, col, current effort}
        effort[0][0] = 0;
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int row = current[0];
            int col = current[1];
            int currentEffort = current[2];
            
            // If we reached the bottom-right cell, return the effort
            if (row == rows - 1 && col == cols - 1) {
                return currentEffort;
            }
            
            // Explore the neighbors
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    int newEffort = Math.max(currentEffort, Math.abs(heights[newRow][newCol] - heights[row][col]));
                    
                    if (newEffort < effort[newRow][newCol]) {
                        effort[newRow][newCol] = newEffort;
                        pq.offer(new int[]{newRow, newCol, newEffort});
                    }
                }
            }
        }
        
        return 0;
    }
}