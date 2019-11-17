/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
*/

public class Solution {
    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
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
            result.add(l);
        }
        return result;
    }
}
