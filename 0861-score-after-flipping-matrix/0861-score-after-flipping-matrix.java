class Solution {
    public int matrixScore(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0) {
                flipRow(grid, i);
            }
        }
        for (int i = 1; i < grid[0].length; i++) {
            int count=0;
            for(int j=0;j<grid.length;j++){
                if(grid[j][i]==0){
                    count++;
                }
            }
            if(count>grid.length-count){
                flipColumn(grid,i);
            }
            }
        
        int score = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int columnScore = grid[i][j] << (grid[0].length - j - 1);
                score += columnScore;
            }
        }
        return score;
    }
        
    
    void flipRow(int[][] grid,int i){
        for(int k=0;k<grid[0].length;k++){
        grid[i][k]=1-grid[i][k];
        }
    }
    void flipColumn(int[][] grid,int j){
        for(int k=0;k<grid.length;k++){
        grid[k][j]=1-grid[k][j];
        }
    }
}