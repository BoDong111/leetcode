/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<TreeNode> set=new HashSet<>();
        for(TreeNode n: nodes){
            set.add(n);
        }
        return lca(root, set);
    }
    public TreeNode lca(TreeNode root, Set<TreeNode> set){
        if(root==null||set.contains(root)){
            return root;
        }
        TreeNode left=lca(root.left, set);
        TreeNode right=lca(root.right, set);
        if(left!=null&&right!=null){
            return root;
        }
        return left==null?right:left;
    }
}