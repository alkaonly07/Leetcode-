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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        dfs(root, targetSum, result, current);
        return result;
        
    }
    private void dfs(TreeNode node, int targetSum,List<List<Integer>> result,  List<Integer> current ){
        if(node ==null){
            return;
        }
        current.add(node.val);
        targetSum -= node.val;
        if(node.left ==null && node.right == null && targetSum ==0){
            result.add(new ArrayList<>(current));
        }
        else{
            dfs(node.left, targetSum, result, current);
            dfs(node.right, targetSum, result, current);
        }
        current.remove(current.size()-1);
    }
}