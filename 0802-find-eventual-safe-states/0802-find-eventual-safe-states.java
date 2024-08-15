class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n=graph.length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[n];
        for(int i=0;i<n;i++){
            for(int node : graph[i]){
                adj.get(node).add(i);
                inDegree[i]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        boolean[] safe=new boolean[n];
        while(!queue.isEmpty()){
            int current=queue.poll();
            safe[current]=true;
            for(int neighbour : adj.get(current)){
                inDegree[neighbour]--;
                if(inDegree[neighbour]==0){
                    queue.add(neighbour);
                }
            }
        }
        List<Integer> safeNode = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(safe[i]){
                safeNode.add(i);
            }
        }
        return safeNode;
    }
}