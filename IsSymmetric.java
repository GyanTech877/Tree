/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
*/

public class Solution1 {
    /**
     * @param root: root of the given tree
     * @return: whether it is a mirror of itself 
     */
    public boolean isSymmetric(TreeNode root) {
       return isSymmetricRec(root,root);
    }
    private boolean isSymmetricRec(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        return (root1.val == root2.val) && isSymmetricRec(root1.left,root2.right) && isSymmetricRec(root1.right,root2.left); 
    }
}
