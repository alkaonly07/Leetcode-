class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // making adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        
        for(int[] prerequisite: prerequisites){
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            adj.get(prereq).add(course);
            inDegree[course]++;
        }
        
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        ArrayList<Integer> topo=new ArrayList<>();
        while(!queue.isEmpty()){
            int current=queue.poll();
            topo.add(current);
            for(int neighbour : adj.get(current)){
                inDegree[neighbour]--;
                if(inDegree[neighbour]==0){
                    queue.add(neighbour);
                }
            }
        }
        int[] result =new int[topo.size()];
        if(topo.size()!= numCourses){
            return new int[0];
        }
            for(int i=0;i<topo.size();i++){
                result[i]=topo.get(i);
            }
        return result;
    }
}