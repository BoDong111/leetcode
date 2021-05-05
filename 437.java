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
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }
        int[] result=new int[1];
        Map<Integer, Integer> map=new HashMap<>();
        map.put(0, 1);
        dfs(root, 0, targetSum, result, map);
        return result[0];
    }
    public void dfs(TreeNode root, int prefixsum, int sum, int[] result, Map<Integer, Integer> map){
        if(root==null){
            return;
        }
        prefixsum+=root.val;
        if(map.containsKey(prefixsum-sum)){
            result[0]+=map.get(prefixsum-sum);
        }
        map.put(prefixsum, map.getOrDefault(prefixsum, 0)+1);
        dfs(root.left, prefixsum, sum, result, map);
        dfs(root.right, prefixsum, sum, result, map);
        map.put(prefixsum, map.get(prefixsum)-1);
    }
}