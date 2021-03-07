/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode n=lca(root, p, q);
        return distance(root, p)+distance(root, q)-2*distance(root, n.val);
    }
    public TreeNode lca(TreeNode root, int p, int q){
        if(root==null||root.val==p||root.val==q){
            return root;
        }
        TreeNode left=lca(root.left, p, q);
        TreeNode right=lca(root.right, p, q);
        if(left!=null&&right!=null){
            return root;
        }
        return left==null?right:left;
    }
    public int distance(TreeNode root, int target){
        if(root==null){
            return -1;
        }
        if(root.val==target){
            return 0;
        }
        int left=distance(root.left, target);
        int right=distance(root.right, target);
        if(left==-1&&right==-1){
            return -1;
        }
        return left<0?right+1:left+1;
    }
}