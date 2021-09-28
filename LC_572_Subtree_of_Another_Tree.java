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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null)
            return false;
        
        boolean found=false;
        if(root.val==subRoot.val)
            found=check(root,subRoot);
        
        if(!found)
            found=isSubtree(root.left,subRoot);
        if(!found)
            found=isSubtree(root.right,subRoot);
        
        return found;
    }
    
    private boolean check(TreeNode n1,TreeNode n2){
        if(n1==null && n2==null)
            return true;
        if(n1==null || n2==null)
            return false;
        if(n1.val==n2.val){
            return check(n1.left,n2.left) && check(n1.right,n2.right);
        }
        return false;
    }
}
