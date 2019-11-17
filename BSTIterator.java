/*
Design an iterator over a binary search tree with the following rules:

Elements are visited in ascending order (i.e. an in-order traversal)
next() and hasNext() queries run in O(1) time in average.
*/

public class BSTIterator {
    final Stack<TreeNode> stack;
    /*
    * @param root: The root of binary tree.
    */public BSTIterator(TreeNode root) {
        // do intialization if necessary
        TreeNode tempRoot=root;
        stack = new Stack<>();
        while(tempRoot!=null){
            stack.push(tempRoot);
            tempRoot=tempRoot.left;
        }
    }

    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        // write your code here
        return !stack.isEmpty();
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        // write your code here
        TreeNode returnedNode= stack.pop();
        TreeNode tempIterator=returnedNode;
        if(tempIterator.right!=null){
            tempIterator=tempIterator.right;
            while(tempIterator!=null){
                stack.push(tempIterator);
                tempIterator=tempIterator.left;
            }
        }
        return returnedNode;
    }
}
