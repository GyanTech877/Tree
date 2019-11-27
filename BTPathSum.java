/*
Given a binary tree, find all paths that sum of the nodes in the path equals to a given number target.
A valid path is from root node to any of the leaf nodes.
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        List<Integer> curr = new ArrayList<>();
        curr.add(root.val);
        constructPathRecur(root,target,curr,result);
        return result;
    }
    private void constructPathRecur(TreeNode root, int target,List<Integer> current, List<List<Integer>> result){
        if(root.left==null && root.right ==null){
            if(target==root.val) result.add(new ArrayList<>(current));
            return;
        }
        if(root.left!=null) {
            current.add(root.left.val);
            constructPathRecur(root.left,target-root.val,current,result);
            current.remove(current.size()-1);
        }
        if(root.right!=null){
            current.add(root.right.val);
            constructPathRecur(root.right,target-root.val,current,result);
            current.remove(current.size()-1);
        }
    }
}
