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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        postOrderHelper(root,result);
        return result;
        
    }
    public void postOrderHelper(TreeNode node,List<Integer> result){
        if(node==null){
            return;
        }
        // postOrderHelper(node.left, result);
        // postOrderHelper(node.right,result);
        // result.add(node.val);
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(node);
        while(!stack1.isEmpty()){
            TreeNode node1= stack1.pop();
            stack2.push(node1);
            if(node1.left!=null){
                stack1.push(node1.left);
            }
            if(node1.right!=null){
                stack1.push(node1.right);
            }
        }
        while(!stack2.isEmpty()){
            TreeNode node2=stack2.pop();
            result.add(node2.val);
        }
        
    }
}