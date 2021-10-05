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
    int maxans=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        trace(root);
        return maxans;
    }
    
    private int trace(TreeNode root){
       if(root==null)
           return 0;
        int left=trace(root.left);
        int right=trace(root.right);
       
        int maxlr=Math.max(left,right);
        int maxonesidewithroot=Math.max(maxlr+root.val,root.val);
        int maxtot=Math.max(maxonesidewithroot,left+right+root.val);
        maxans=Math.max(maxans,maxtot);
        
        
        return maxonesidewithroot;
    }
}
