// class Solution {
//     public int findChampion(int n, int[][] edges) {
        
//     }
// }


public class Solution {

    public int findChampion(int n, int[][] edges) {
        // Initialize the indegree array to track the number of incoming edges for each team
        int[] indegree = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();

        // Create adjacency list
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Store the indegree and build the graph
        for (int[] edge : edges) {
            indegree[edge[1]]++;
            adjList.get(edge[0]).add(edge[1]);
        }

        int champ = -1;
        int champCount = 0;

        // Find candidate(s) with zero in-degree
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                champCount++;
                champ = i;
            }
        }

        // If more than one potential champion exists, return -1
        if (champCount > 1) return -1;

        // Verify the reachability of the identified candidate
        return canReachAllNodes(champ, adjList, n) ? champ : -1;
    }

    private boolean canReachAllNodes(int start, List<List<Integer>> adjList, int n) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        int visitedCount = 1;  // Start with the candidate node

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                    visitedCount++;
                }
            }
        }

        // If all nodes are visited, the candidate can reach all nodes
        return visitedCount == n;
    }
}
