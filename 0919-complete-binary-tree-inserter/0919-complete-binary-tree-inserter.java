/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class CBTInserter {
    private TreeNode root;
    private Queue<TreeNode> queue;

    public CBTInserter(TreeNode root) {
        this.root = root;
        this.queue = new LinkedList<>();
        
        Queue<TreeNode> tempQueue = new LinkedList<>();
        tempQueue.add(root);
        
        while (!tempQueue.isEmpty()) {
            TreeNode node = tempQueue.poll();
            if (node.left != null) {
                tempQueue.add(node.left);
            }
            if (node.right != null) {
                tempQueue.add(node.right);
            }
            if (node.left == null || node.right == null) {
                queue.add(node);
            }
        }
    }
    
    public int insert(int val) {
        TreeNode node = new TreeNode(val);
        TreeNode parent = queue.peek();
        
        if (parent.left == null) {
            parent.left = node;
        } else {
            parent.right = node;
            queue.poll(); // Move to the next node
        }
        
        queue.add(node);
        return parent.val;
    }
    
    public TreeNode get_root() {
        return this.root;
    }
}
/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */