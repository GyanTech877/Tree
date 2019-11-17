/*
A full binary tree is a binary tree where each node has exactly 0 or 2 children.

Return a list of all possible full binary trees with N nodes.  Each element of the answer is the root node of one possible tree.

Each node of each tree in the answer must have node.val = 0.

You may return the final list of trees in any order.

*/

class Solution {
    private Map<Integer,List<TreeNode>> cache=new HashMap<>();
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> result=new ArrayList<>();
        if(N%2 == 0) return result;
        if(N==1){
            result.add(new TreeNode(0));
            cache.put(1,result);
            return result;
        }
        if(cache.containsKey(N)){
            return cache.get(N);
        }
        N=N-1;
        for(int i=1;i<N;i+=2){
            List<TreeNode> left=allPossibleFBT(i);
            List<TreeNode> right=allPossibleFBT(N-i);
            for(TreeNode ln: left){
                for(TreeNode rn: right){
                    TreeNode root=new TreeNode(0);
                    root.left=ln;
                    root.right=rn;
                    result.add(root);
                }
            }
        }
        cache.put(N,result);
        return result;
    }
}
