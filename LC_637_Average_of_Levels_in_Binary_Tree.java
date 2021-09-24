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
 
BFS:
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        
        ArrayList<Double>ans=new ArrayList<>();
        
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        
        long count=0,sum=0;
        while(!q.isEmpty()){
            count=q.size();
            sum=0;
            for(int i=0;i<count;i++){
                TreeNode node=q.poll();
                sum+=node.val;
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
            ans.add((sum*1.0)/count);
        }
        
        return ans;
        
    }
}


DFS:
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        
        ArrayList<Double>ans=new ArrayList<>();
        
        ArrayList<Integer>levelNumCount=new ArrayList<>();
        
        populate(root, 0, levelNumCount, ans);
        
        for(int i=0;i<ans.size();i++)
            ans.set(i,ans.get(i)/levelNumCount.get(i));
        
        return ans;
    }
    
    public void populate(TreeNode root, int i, List<Integer> count, List<Double> ans){
        if(root!=null){
            if(i<ans.size()){
                ans.set(i,ans.get(i)+root.val);
                count.set(i,count.get(i)+1);
            }
            else{
                ans.add(1.0*root.val);
                count.add(1);
            }
            populate(root.left,i+1,count,ans);
            populate(root.right,i+1,count,ans);
        }
    }
}
