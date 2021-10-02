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
//Bfs solution is intutive and more suitable, however for understanding perspective do try dfs also
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        int ans=1;
        Queue<Pair<TreeNode,Integer>>q=new LinkedList<>();
        q.add(new Pair<>(root,1));
        while(!q.isEmpty()){
        int first=0,last=0,offset=q.peek().getValue();   //to handle overflow
           int size=q.size();
            for(int i=0;i<size;i++){
                Pair<TreeNode,Integer>p=q.poll();
                TreeNode node=p.getKey();
                int val=p.getValue()-offset+1;
                if(node.left!=null){
                    q.add(new Pair<>(node.left,2*val));
                    if(first==0){
                        first=2*val;
                        last=2*val;
                    }
                    else
                        last=2*val;
                
                }
                if(node.right!=null){
                    q.add(new Pair<>(node.right,(2*val)+1));
                    if(first==0){
                        first=(2*val)+1;
                        last=(2*val)+1;
                    }
                    else
                        last=(2*val)+1;
                }
            }
            if(first>0){
                ans=Math.max(ans,(last-first+1));
            }
        }
            
        return ans;
    }
}
