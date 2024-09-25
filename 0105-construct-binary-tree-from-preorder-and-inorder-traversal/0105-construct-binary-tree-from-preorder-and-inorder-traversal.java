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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }

        // Map to store the index of each value in inorder traversal
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // Recursively construct the binary tree
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, 
                                     int[] inorder, int inStart, int inEnd, 
                                     Map<Integer, Integer> inorderMap) {
        // Base case: if there are no elements to construct the tree
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // The first element of preorder is the root of the current tree
        TreeNode root = new TreeNode(preorder[preStart]);

        // Get the index of the root from inorder traversal
        int inRoot = inorderMap.get(root.val);

        // Numbers of nodes in the left subtree
        int leftTreeSize = inRoot - inStart;

        // Recursively build the left and right subtrees
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftTreeSize, 
                                    inorder, inStart, inRoot - 1, inorderMap);
        root.right = buildTreeHelper(preorder, preStart + leftTreeSize + 1, preEnd, 
                                     inorder, inRoot + 1, inEnd, inorderMap);

        return root;
        
    }
}