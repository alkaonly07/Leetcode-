class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor=image[sr][sc];
        if(initialColor==color){
            return image;
        }
        Queue<int[]> queue=new LinkedList<>();
        int rows=image.length;
        int cols=image[0].length;
        queue.add(new int[]{sr,sc});
        int[][] directions={{0,1}, {1,0}, {0,-1}, {-1,0}};
        while(!queue.isEmpty()){
                    int[] current=queue.poll();
                    int row=current[0];
                    int col=current[1];
                    image[row][col]=color;
            for(int[] direction : directions){
                int newrow=row+direction[0];
                int newcol=col+direction[1];
                if(newrow>=0 && newcol>=0 && newrow<rows && newcol<cols && image[newrow][newcol]==initialColor){
                
                    queue.add( new int[]{newrow,newcol});
                }
            }
            
        }
        return image;
        
    }
}