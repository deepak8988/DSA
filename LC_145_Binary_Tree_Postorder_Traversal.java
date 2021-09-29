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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>ans=new LinkedList<>();
        if(root==null)
            return ans;
        Stack<TreeNode>s=new Stack<>();
        s.push(root);
        TreeNode pre=null;
        while(!s.isEmpty()){
            TreeNode cur=s.peek();
            if(cur.left==null && cur.right==null){    //leaf node
                pre=cur;
                ans.add(cur.val);
                s.pop();
                continue;
            }
            if(pre!=null && (pre==cur.right||pre==cur.left)){   //since we are pushing root, right, left in stack respectively. I had missed pre!=null condition here, think why it's necessary
                ans.add(cur.val);
                pre=cur;
                s.pop();
                continue;
            }
            if(cur.right!=null){
                s.push(cur.right);
            }
            if(cur.left!=null){
                s.push(cur.left);
            }
        }
        return ans;
    }
}
