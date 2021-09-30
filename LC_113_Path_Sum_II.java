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
    private List<List<Integer>>ans=new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer>list=new ArrayList<>();
        trace(root,targetSum,list,0);
     return ans;
    }
    
    private void trace(TreeNode node,int targetSum, List<Integer> list, int sum){
        if(node==null)return;
        sum+=node.val;
        if(node.left==null && node.right==null){
            if(targetSum==sum){
                List<Integer>newlist=new ArrayList<>();
                for(int i:list)newlist.add(i);
                newlist.add(node.val);
                ans.add(newlist);
            }
            else
                return;
        }
        
       // if(sum>targetSum)  this case will yeild incorrect answer when target and some elements are negative
            //return;
        
        list.add(node.val);
        
        if(node.left!=null)
            trace(node.left,targetSum,list,sum);
        
        if(node.right!=null)
            trace(node.right,targetSum,list,sum);
        
        list.remove(list.size()-1);
        
        
    }
}
