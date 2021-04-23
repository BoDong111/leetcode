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
class BSTIterator {
    Deque<TreeNode> stack=new ArrayDeque<>();
    public BSTIterator(TreeNode root) {
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
    }
    
    public int next() {
        TreeNode tmp=stack.pop();
        int res=tmp.val;
        if(tmp.right!=null){
            tmp=tmp.right;
            while(tmp!=null){
                stack.push(tmp);
                tmp=tmp.left;
            }
        }
        return res;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}