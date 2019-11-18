/*
Given a binary tree, find the length of the longest consecutive sequence path.
The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
The longest consecutive path need to be from parent to child (cannot be the reverse).
*/

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    int longestConsecutive;
    public int longestConsecutive(TreeNode root) {
        // write your code here
        longestConsecutive=0;
        findRecur(root,1);
        return longestConsecutive;
    }
    private void findRecur(TreeNode root,int number){
        if(root == null) return;
        longestConsecutive=Math.max(longestConsecutive,number);
        if(root.left!=null){
            if(root.left.val-1 == root.val) findRecur(root.left,number+1);
            else findRecur(root.left,1);
        }
        if(root.right!=null){
           if(root.right.val-1 == root.val) findRecur(root.right,number+1);
            else findRecur(root.right,1); 
        }
    }
}
