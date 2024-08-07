class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        int provinces=0;
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                provinces++;
                bfs(isConnected,i,visited);
            }
        }
        return provinces;
        
        
    }
    void bfs(int[][] isConnected, int node,boolean[] visited){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(node);
        visited[node]=true;
        while(!queue.isEmpty()){
            int current=queue.poll();
            for(int i=0;i<isConnected.length;i++){
                if(!visited[i] && isConnected[current][i]==1){
                    queue.add(i);
                    visited[i]=true;
                }
            }
        }
        
    }
}