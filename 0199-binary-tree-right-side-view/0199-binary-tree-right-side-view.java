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
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
       List<Integer> result = new ArrayList<>();
        
        // Base case: if the tree is empty, return an empty list
        if (root == null) {
            return result;
        }
        
        // Use a queue for level-order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode rightmostNode = null;
            
            // Traverse all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                
                // The last node encountered at this level will be the rightmost node
                rightmostNode = currentNode;
                
                // Add the left and right children to the queue if they exist
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            
            // Add the rightmost node's value of this level to the result
            result.add(rightmostNode.val);
        }
        
        return result; 
    }
}