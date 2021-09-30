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
    private HashMap<Integer,Integer>map=new HashMap<>();
    int ans=0;
    public int pathSum(TreeNode root, int targetSum) {
        map.put(0,1);
        trace(root,targetSum,0);
        return ans;
    }
    
    private void trace(TreeNode node,int targetSum,int sum){
        if(node==null)
            return;
        
        sum+=node.val;
        if(map.containsKey(sum-targetSum))
            ans+=map.get(sum-targetSum);
        
        map.put(sum,map.getOrDefault(sum,0)+1);
       
        trace(node.left,targetSum,sum);
        trace(node.right,targetSum,sum);
        
        map.put(sum,map.get(sum)-1);
    }
}
