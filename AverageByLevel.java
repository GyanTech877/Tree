/*
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
*/


public class Solution {
    /**
     * @param root: the binary tree of the  root
     * @return: return a list of double
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averageOfLevels=new ArrayList<>();
        if(root==null) return averageOfLevels;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int nodes=queue.size();
            int sum=0;
            for(int i=0;i<nodes;i++){
                TreeNode curr=queue.poll();
                sum+=curr.val;
                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
            }
            double average=(double)sum/(double)nodes;
            averageOfLevels.add(average);
        }
        return averageOfLevels;
    }
}
