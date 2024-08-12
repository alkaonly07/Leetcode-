class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int rows = board.length;
        int cols = board[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Start from 'O's on the boundary and mark all connected 'O's
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') queue.add(new int[]{i, 0});
            if (board[i][cols - 1] == 'O') queue.add(new int[]{i, cols - 1});
        }
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') queue.add(new int[]{0, j});
            if (board[rows - 1][j] == 'O') queue.add(new int[]{rows - 1, j});
        }

        // Directions for the 4 neighbors (right, down, left, up)
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // BFS to mark safe 'O's
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            board[row][col] = 'S'; // Mark as safe

            for (int[] dir : directions) {
                int newr = row + dir[0];
                int newc = col + dir[1];

                // Check if the new position is within bounds and is an 'O'
                if (newr >= 0 && newr < rows && newc >= 0 && newc < cols && board[newr][newc] == 'O') {
                    queue.add(new int[]{newr, newc});
                }
            }
        }

        // Step 2: Flip all remaining 'O's to 'X', and all 'S' (safe) back to 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; // Surrounded regions
                } else if (board[i][j] == 'S') {
                    board[i][j] = 'O'; // Safe regions
                }
            }
        }
    }
}
