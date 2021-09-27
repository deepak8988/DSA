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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>ans=new LinkedList<>();
        if(root==null)
            return ans;
        int level=0;
        Queue<TreeNode>s=new LinkedList<>();
        s.add(root);
        List<Integer>subans=new LinkedList<>();
        subans.add(root.val);
            
        while(!s.isEmpty()){
            
            level++;
            ans.add(subans);
            subans=new LinkedList<>();
            int size=s.size();
            for(int i=0;i<size;i++){
                TreeNode node=s.poll();
                if(level %2==1){
                   if(node.left!=null){
                        s.add(node.left);
                        subans.add(0,node.left.val);   
                    }
                    if(node.right!=null){
                        s.add(node.right);
                        subans.add(0,node.right.val);
                    }
                }
                else{
                    if(node.left!=null){
                        s.add(node.left);
                        subans.add(node.left.val);   
                    }
                    if(node.right!=null){
                        s.add(node.right);
                        subans.add(node.right.val);
                    }
                }
            }
        }
        return ans;
    }
}
