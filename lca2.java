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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result=helper(root, p, q);
        if(result==p){
            if(helper(p, q, q)==null){
                return null;
            }
        }
        else if(result==q){
            if(helper(q, p, p)==null){
                return null;
            }
        }
        return result;
    }
    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(root==null||root==p||root==q){
            return root;
        }
        TreeNode left=helper(root.left, p, q);
        TreeNode right=helper(root.right, p, q);
        if(left!=null&&right!=null){
            return root;
        }
        return left==null?right:left;
    }
}