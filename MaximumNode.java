/*
Find the maximum node in a binary tree, return the node.
*/

public class Solution {
    /*
     * @param root: the root of tree
     * @return: the max node
     */
    TreeNode maxNode;
    public TreeNode maxNode(TreeNode root) {
        if(root==null) return root;
        maxNode = root;
        inorder(root);
        return maxNode;
    }
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(root.val > maxNode.val) maxNode = root;
        inorder(root.right);
    }
}

