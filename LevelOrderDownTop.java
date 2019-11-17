/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
(ie, from left to right, level by level from leaf to root).
*/

public class Solution {
    /**
     * @param root: A tree
     * @return: buttom-up level order a list of lists of integer
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        List<List<Integer>> result =new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null) return result;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> l = new ArrayList<>();
            while(size-->0){
                TreeNode curr = queue.poll();
                l.add(curr.val);
                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
            }
            result.add(0,l);
        }
        return result;
    }
}
