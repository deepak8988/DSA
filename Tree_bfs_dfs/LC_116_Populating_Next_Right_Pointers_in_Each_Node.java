/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node ans=root;
        Node start_level=root;
        Node prev=null;
        while(start_level!=null && start_level.left!=null){      // to handle leaf level
            Node cur=start_level;
            while(cur!=null){
                if(prev!=null)
                    prev.next=cur.left;
                cur.left.next=cur.right;
                prev=cur.right;
                cur=cur.next;
            }
            start_level=start_level.left;
            prev=null;
        }
        return ans;
    }
}
