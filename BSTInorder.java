/*
Given a binary tree, return the inorder traversal of its nodes' values.
*/

public class Solution1 {
    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    List<Integer> resultList;
    public List<Integer> inorderTraversal(TreeNode root) {
        resultList=new ArrayList<>();
        inorder(root);
        return resultList;
    }
    private void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        resultList.add(root.val);
        inorder(root.right);
    }
}

public class Solution2 {
    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    List<Integer> resultList;
    public List<Integer> inorderTraversal(TreeNode root) {
        resultList=new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp=root;
        while(temp!=null){
            stack.push(temp);
            temp=temp.left;
        }
        while(!stack.isEmpty()){
           temp= stack.pop();
           resultList.add(temp.val);
           if(temp.right!=null){
              temp=temp.right;
              while(temp!=null){
                stack.push(temp);
                temp=temp.left;
              }
           }
        }
        return resultList;
    }
    private void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        resultList.add(root.val);
        inorder(root.right);
    }
}
