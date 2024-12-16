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
    public int rob(TreeNode root) {
        int[] options = travel(root);
        return Math.max(options[0],options[1]);
        
    }
    private int[] travel(TreeNode root){
        if(root == null){
            return new int[2];
        }
        int[] left_choice = travel(root.left);
        int[] right_choice = travel(root.right);
        int[] options = new int[2];
        
        options[0] = root.val + left_choice[1] +  right_choice[1];
        options[1]=Math.max(left_choice[0], left_choice[1]) +
                    Math.max(right_choice[0], right_choice[1]);
        return options;
    }
}