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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result= new ArrayList<>();
        preOrderHelper(root, result);
        return result;
        
    }
    public void preOrderHelper(TreeNode node, List<Integer> result){
        if(node==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            TreeNode node1=stack.pop();
            result.add(node1.val);
            if(node1.right!=null){
                stack.push(node1.right);
            }
            if(node1.left!=null){
                stack.push(node1.left);
            }
        }        
    }
}