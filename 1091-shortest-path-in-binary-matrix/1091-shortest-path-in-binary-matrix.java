class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int n = grid.length;
        // If the start or end is blocked, there's no path
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }

        // Directions for 8 possible moves (up, down, left, right, and 4 diagonals)
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        // BFS initialization
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1}); // Start with the top-left corner, distance is 1
        grid[0][0] = 1; // Mark as visited

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            int dist = cell[2];

            // Check if we've reached the bottom-right corner
            if (row == n - 1 && col == n - 1) {
                return dist;
            }

            // Explore all 8 possible directions
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                // Check if the new position is within bounds and not visited
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0) {
                    queue.offer(new int[]{newRow, newCol, dist + 1});
                    grid[newRow][newCol] = 1; // Mark as visited
                }
            }
        }

        // If we exit the loop, there's no path
        return -1;
        
        
    }
}