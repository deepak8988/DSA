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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        return dfs(root,0,targetSum);
    }
    
    private boolean dfs(TreeNode node,int sum,int targetSum){
        if(node==null)
            return false;
        
        sum+=node.val;
        
        if(node.left==null && node.right==null)
            return (sum==targetSum);
        
        return dfs(node.left,sum,targetSum)||dfs(node.right,sum,targetSum);
        
        
    }
}
