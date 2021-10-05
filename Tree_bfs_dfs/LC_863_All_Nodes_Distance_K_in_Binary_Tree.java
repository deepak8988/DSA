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
    private HashMap<Integer,ArrayList<Integer>>graphMap=new HashMap<>();
    private HashMap<Integer,Integer>seen=new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<Integer>ans=new ArrayList<>();
        convertToGraph(root,null);
        Queue<Integer>q=new LinkedList<>();
        int level=0;
        q.add(target.val);
        seen.put(target.val,1);
        while(!q.isEmpty()&&level<k){
            int size=q.size();
            for(int i=0;i<size;i++){
                int qval=q.poll();
                for(int j:graphMap.get(qval)){
                    if(!seen.containsKey(j)){
                        q.add(j);
                        seen.put(j,1);
                    }
                }
            }
            level++;
        }
        while(!q.isEmpty())
            ans.add(q.poll());
        return ans;
    }
    
    private void convertToGraph(TreeNode root,TreeNode parent){
        graphMap.put(root.val,new ArrayList<Integer>());
        if(parent!=null){
            graphMap.get(root.val).add(parent.val);
        }
        
        if(root.left!=null){
            graphMap.get(root.val).add(root.left.val);
            convertToGraph(root.left,root);
        }
        if(root.right!=null){
            graphMap.get(root.val).add(root.right.val);
            convertToGraph(root.right,root);
        }
    }
}
