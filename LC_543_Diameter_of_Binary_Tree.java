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
    int ans=0;
    public int diameterOfBinaryTree(TreeNode root) {
        
        dfs(root,0);
        return ans;
        
    }
    
    private int dfs(TreeNode root,int h){
        if(root==null)
            return 0;
        int lh=dfs(root.left,h);
        int rh=dfs(root.right,h);
        ans=Math.max(ans,lh+rh);
        return Math.max(lh,rh)+1;
    }
}
