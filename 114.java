class Solution {
    public void flatten(TreeNode root) {
        TreeNode[] prev=new TreeNode[1];
        helper(root, prev);
    }
    public void helper(TreeNode root, TreeNode[] prev){
        if(root==null){
            return;
        }
        helper(root.right, prev);
        helper(root.left, prev);
        root.right=prev[0];
        root.left=null;
        prev[0]=root;
    }
}