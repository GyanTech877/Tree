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

public class Solution2 {
    /**
     * @param root: root of the given tree
     * @return: whether it is a mirror of itself 
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()){
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();
            if(leftNode == null && rightNode ==null) return true;
            if(leftNode == null || rightNode ==null) return false;
            if(leftNode.val != rightNode.val) return false;
            queue.offer(leftNode.left);
            queue.offer(rightNode.right);
            queue.offer(leftNode.right);
            queue.offer(rightNode.left);
        }
        return true;
    }
}
