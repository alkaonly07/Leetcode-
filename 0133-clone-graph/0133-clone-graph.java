/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node ==null){
            return null;
        }
        Map<Node,Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        
        visited.put(node, new Node(node.val,new ArrayList<>()));
        while(!queue.isEmpty()){
            Node current = queue.poll();
            for(Node neighbour : current.neighbors){
                if(!visited.containsKey(neighbour)){
                    visited.put(neighbour, new Node(neighbour.val, new ArrayList<>()));
                    queue.add(neighbour);
                }
                visited.get(current).neighbors.add(visited.get(neighbour));
            }
        }
        return visited.get(node);
    }
}