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
     public boolean isSymmetric(TreeNode root) {
    //     return root == null || isSymmetric(root.left, root.right);
    // }
    // private boolean isSymmetric(TreeNode l, TreeNode r){
    //     if(l == null && r ==null){
    //         return l==r;
    //     }
    //     return l.val == r.val && isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);
    // }
     return root==null || isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode p, TreeNode q) {

        if(p == null || q == null){
            return p == q;
        }

        return p.val == q.val && isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }
    
    
}