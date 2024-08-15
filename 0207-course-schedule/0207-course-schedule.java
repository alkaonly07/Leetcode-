class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] inDegree=new int[numCourses];
        for(int[] prerequisite : prerequisites){
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
        int count=0;
        while(!queue.isEmpty()){
            int current = queue.poll();
            count++;
            for(int neighbour:adj.get(current)){
                inDegree[neighbour]--;
                if(inDegree[neighbour]==0){
                    queue.add(neighbour);
                }
            }
        }
        return count==numCourses;
        
    }
}