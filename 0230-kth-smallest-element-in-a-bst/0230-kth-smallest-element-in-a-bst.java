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
    private int count = 0; // Counter to keep track of the number of nodes visited
    private int result = 0; // To store the k-th smallest value

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return result;
    }

    private void dfs(TreeNode node, int k) {
        if (node == null) {
            return; // Base case: return if the node is null
        }

        // Traverse the left subtree
        dfs(node.left, k);

        // Increment the counter
        count++;
        
        // Check if the current node is the k-th smallest
        if (count == k) {
            result = node.val; // Store the k-th smallest value
            return; // Return to stop further traversal
        }

        // Traverse the right subtree
        dfs(node.right, k);
        
    }
}