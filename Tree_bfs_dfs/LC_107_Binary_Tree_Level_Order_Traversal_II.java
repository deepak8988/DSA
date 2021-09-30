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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>>ans=new LinkedList<>();
        if(root==null)
            return ans;
        
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer>subans=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode cur=q.poll();
                subans.add(cur.val);
                if(cur.left!=null)
                    q.add(cur.left);
                if(cur.right!=null)
                    q.add(cur.right);
            }
            ans.add(0,subans);
        }
        return ans;
    }
}
