/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         if (root == null || root == p || root == q) {
            return root;
        }
        
        // Search in the left subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        
        // Search in the right subtree
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // If both left and right are non-null, root is the LCA
        if (left != null && right != null) {
            return root;
        }
        
        // Otherwise, return the non-null subtree (either left or right)
        return left != null ? left : right;
        
    }
}