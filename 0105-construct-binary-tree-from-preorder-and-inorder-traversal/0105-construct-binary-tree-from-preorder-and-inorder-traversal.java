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
        return tree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public TreeNode tree(int []pre,int prest,int prend,int []in,int inst,int inend){
        if(prest>prend || inst>inend){
            return null;
        }
        int ind=pre[prest];
        TreeNode root=new TreeNode(ind);

        int rootval=0;
        for(int i=inst;i<=inend;i++){
            if(in[i]==ind){
                rootval=i;
                break;
            }
        }

        int l=rootval-inst;

        root.left=tree(pre,prest+1,prest+l,in,inst,rootval-1);
        root.right=tree(pre,prest+l+1,prend,in,rootval+1,inend);
        
        return root;
    }
}