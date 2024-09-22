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
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int result = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, root.val));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> currentPair = queue.poll();
            TreeNode currentNode = currentPair.getKey();
            int currentSum = currentPair.getValue();

            // If the current node is a leaf, add its value to the result
            if (currentNode.left == null && currentNode.right == null) {
                result += currentSum;
            }

            // Otherwise, continue the BFS by adding children to the queue
            if (currentNode.left != null) {
                queue.offer(new Pair<>(currentNode.left, currentSum * 10 + currentNode.left.val));
            }
            if (currentNode.right != null) {
                queue.offer(new Pair<>(currentNode.right, currentSum * 10 + currentNode.right.val));
            }
        }

        return result;
        
    }
}