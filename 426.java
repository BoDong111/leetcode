/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    public Node treeToDoublyList(Node root) {
        if(root==null){
            return null;
        }
        Node[] prev=new Node[1];
        Node dummy=new Node(0, null, null);
        prev[0]=dummy;
        dfs(root, prev);
        prev[0].right=dummy.right;
        dummy.right.left=prev[0];
        return dummy.right;
    }
    public void dfs(Node root, Node[] prev){
        if(root==null){
            return;
        }
        dfs(root.left, prev);
        prev[0].right=root;
        root.left=prev[0];
        prev[0]=root;
        dfs(root.right, prev);
    }
}