/*
Find the sum of all left leaves in a given binary tree.
*/

public class Solution {
    /**
     * @param root: t
     * @return: the sum of all left leaves
     */
    int sumOfLeftLeaves;
    public int sumOfLeftLeaves(TreeNode root) {
       sumOfLeftLeaves=0;
       if(root==null) return sumOfLeftLeaves;
       traverse(root);
       return sumOfLeftLeaves;
    }
    private boolean traverse(TreeNode root){
        if(root.left==null && root.right ==null) return true;
        if(root.left!=null){
            boolean resultL = traverse(root.left);
            if(resultL) sumOfLeftLeaves+=root.left.val;
        }
        if(root.right!=null){
           traverse(root.right);
        }
        return false;
    }
}
