class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid.length==0 || grid==null){
            return -1;
        }
        Queue<int[]> queue=new LinkedList<>();
        int rows=grid.length;
        int cols=grid[0].length;
        int freshOranges=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                } 
                else if(grid[i][j]==1){
                    freshOranges++;
                }
            }
        }
        if(freshOranges==0){
            return 0;
        }
        int minutes=0;
        int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] current=queue.poll();
                for(int[] direction : directions){
                    int newRow=current[0]+direction[0];
                    int newCol=current[1]+direction[1];
                     if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol]=2;
                        queue.add(new int[]{newRow, newCol});
                        freshOranges--;
                    }
                    
                }
            }
            minutes++;
        }
        return freshOranges==0? minutes-1:-1;
        
    }
}