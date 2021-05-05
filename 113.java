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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> prefixSum=new ArrayList<>();
        dfs(root, sum, prefixSum, result);
        return result;
    }
    public void dfs(TreeNode root, int sum, List<Integer> prefixSum, List<List<Integer>> result){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            prefixSum.add(root.val);
            if(sumpath(prefixSum)==sum){
                result.add(new ArrayList(prefixSum));
            }
            prefixSum.remove(prefixSum.size()-1);
            return;
           }
        prefixSum.add(root.val);
        dfs(root.left, sum, prefixSum, result);
        dfs(root.right,sum, prefixSum, result);
        prefixSum.remove(prefixSum.size()-1);
    }
    public int sumpath(List<Integer> list){
        int result=0;
        for(int i:list){
            result+=i;
        }
        return result;
    }
}