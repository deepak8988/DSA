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
        if(root==null)
            return root;
        int R=root.val,P=p.val,Q=q.val;
        if(R>P&&R>Q)
            return lowestCommonAncestor(root.left,p,q);
        if(R<P&&R<Q)
            return lowestCommonAncestor(root.right,p,q);
        return root;
    }
    
}
