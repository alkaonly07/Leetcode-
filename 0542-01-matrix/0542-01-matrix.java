class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows=mat.length;
        int cols=mat[0].length;
       int[][] direction={{0,1},{1,0},{0,-1},{-1,0}};
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(mat[i][j]==0){
                    queue.add(new int[]{i,j});
                }
                else{
                    mat[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        while(!queue.isEmpty()){
            int[] current=queue.poll();
            int x=current[0];
            int y=current[1];
            for(int[] dir: direction){
                int newx=x+dir[0];
                int newy=y+dir[1];
                if(newx>=0 && newx<rows && newy>=0 && newy<cols && mat[newx][newy]>mat[x][y]+1){
                    mat[newx][newy]=mat[x][y]+1;
                    queue.add(new int[]{newx,newy});
                }
            }
        }
        
        return mat;
    }
}