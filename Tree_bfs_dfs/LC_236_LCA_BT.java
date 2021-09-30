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
    boolean first=false,second=false;
    TreeNode ans=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        trace(root,p,q);
        return ans;
    }
    
    public int trace(TreeNode root, TreeNode p, TreeNode q){
        if(root==null)
            return 0;
        int Val=0;
        if(q.val==root.val){
            second=true;
            Val++;
        }
        else if(p.val==root.val){
            first=true;
            Val++;
        }
        
        if(!first||!second){
            if(root.left!=null)
                Val+=trace(root.left,p,q);
        }
        if(Val==2){
            ans=root;
            return 0;
        }
        
        if(!first||!second){
            if(root.right!=null)
                Val+=trace(root.right,p,q);
        }
        if(Val==2){
            ans=root;
            return 0;
        }
        return Val;
    }
}
