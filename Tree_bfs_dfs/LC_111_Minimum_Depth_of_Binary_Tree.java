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
 
DFS:
class Solution {
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        return trace(root,0);
    }
    
    public int trace(TreeNode root, int height){
        if(root==null)
            return Integer.MAX_VALUE;
        if(root.left==null && root.right==null)
            return height+1;
        int lh=trace(root.left,height+1);
        int rh=trace(root.right,height+1);
        return Math.min(lh,rh);
    }
}


BFS:
class Solution {
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        return trace(root);
    }
    
    public int trace(TreeNode root){
       
        Queue<Pair<TreeNode,Integer>>q=new LinkedList<>();
        q.add(new Pair<>(root,1));
        while(!q.isEmpty()){
            
            int n=q.size();
            for(int i=0;i<n;i++){
                Pair<TreeNode,Integer> p=q.poll();
                TreeNode node=p.getKey();
                int level=p.getValue();
                if(node.left==null & node.right==null)
                    return level;
                if(node.left!=null)
                    q.add(new Pair<>(node.left,level+1));
                if(node.right!=null)
                    q.add(new Pair<>(node.right,level+1));
                
            }
            
        }
        return -1;//just for compiler
    }
}
