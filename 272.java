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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result=new ArrayList<>();
        Deque<Integer> window=new LinkedList<>();
        inorder(root, target, k, window);
        while(!window.isEmpty()){
            result.add(window.pollLast());
        }
        return result;
    }
    public void inorder(TreeNode root, double target, int k, Deque<Integer> window){
        if(root==null){
            return;
        }
        inorder(root.left, target, k, window);
        if(window.size()<k){
            window.offerFirst(root.val);
        }
        else{
            int tmp=window.peekLast();
            if(Math.abs(tmp-target)>Math.abs(target-root.val)){
                window.pollLast();
                window.offerFirst(root.val);
            }
        }
        inorder(root.right, target, k, window);
    }
}