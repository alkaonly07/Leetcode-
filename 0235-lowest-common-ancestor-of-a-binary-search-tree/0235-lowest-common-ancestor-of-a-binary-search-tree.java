/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//          if (root == null || root == p || root == q) {
//             return root;
//         }
        
//         // Search in the left subtree
//         TreeNode left = lowestCommonAncestor(root.left, p, q);
        
//         // Search in the right subtree
//         TreeNode right = lowestCommonAncestor(root.right, p, q);
        
//         // If both left and right are non-null, root is the LCA
//         if (left != null && right != null) {
//             return root;
//         }
        
//         // Otherwise, return the non-null subtree (either left or right)
//         return left != null ? left : right;
        
//     }
// }

import java.util.*;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Map to store the parent pointers
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        // Stack to perform the tree traversal
        Deque<TreeNode> stack = new ArrayDeque<>();
        
        // Initialize the traversal by setting root's parent as null
        parent.put(root, null);
        stack.push(root);
        
        // Traverse the tree until we find both p and q
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            
            // If the left child exists, set its parent and push it onto the stack
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            
            // If the right child exists, set its parent and push it onto the stack
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        
        // Set to store ancestors of p
        Set<TreeNode> ancestors = new HashSet<>();
        
        // Trace the path from p to the root and add all ancestors of p to the set
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        
        // Trace the path from q to the root and find the first common ancestor
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }
        
        // The first common ancestor found is the LCA
        return q;
    }
}
