/*
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
*/

public class Solution1 {
    /**
     * @param root: The root of binary tree
     * @return: An integer
     */
    public int minDepth(TreeNode root) {
        // write your code here
        if(root==null) return 0;
        if(root.left ==null && root.right ==null) return 1;
        int lD=minDepth(root.left);
        int rD=minDepth(root.right);
        if(root.left!=null && root.right!=null) return 1+ Math.min(lD,rD);
        else if(root.left!=null) return 1+ lD;
        return 1+ rD;
    }
}

public class Solution2 {
    /**
     * @param root: The root of binary tree
     * @return: An integer
     */
    class QNode{
        TreeNode treeNode;
        int level;
        public QNode(TreeNode treeNode,int level){
            this.treeNode=treeNode;
            this.level=level;
        }
    }
    public int minDepth(TreeNode root) {
        // write your code here
        if(root==null) return 0;
        if(root.left ==null && root.right ==null) return 1;
        Queue<QNode> queue = new LinkedList<>();
        queue.offer(new QNode(root,1));
        while(!queue.isEmpty()){
            QNode qNode = queue.poll();
            if(qNode.treeNode.left == null && qNode.treeNode.right == null) return qNode.level;
            if(qNode.treeNode.left != null) {
              queue.offer(new QNode(qNode.treeNode.left,qNode.level+1)); 
            }
            if(qNode.treeNode.right != null) {
              queue.offer(new QNode(qNode.treeNode.right,qNode.level+1));   
            }
        }
        return 0;
    }
}
