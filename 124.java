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
    public int maxPathSum(TreeNode root) {
        int[] result=new int[1];
        result[0]=Integer.MIN_VALUE;
        dfs(root, result);
        return result[0];
    }
    public int dfs(TreeNode root, int[] result){
        if(root==null){
            return 0;
        }
        int left=dfs(root.left, result);
        int right=dfs(root.right, result);
        left=left>0?left:0;
        right=right>0?right:0;
        result[0]=Math.max(result[0], left+right+root.val);
        return Math.max(left, right)+root.val;
    }
}