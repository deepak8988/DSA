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
    int preIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return trace(preorder,inorder,0,inorder.length-1);
    }
    
    TreeNode trace(int[] preorder, int[] inorder,int loIn,int hiIn){
        TreeNode node=new TreeNode(preorder[preIndex]);
        
        if(loIn==hiIn)
            return node;
        //can also use hashmap to cache value->index pair or inorder traversal
        int i=findindex(inorder,preorder[preIndex]);
        
        if(i-1>=loIn){
            preIndex++;
            node.left=trace(preorder,inorder,loIn,i-1);
        }
        if(i+1<=hiIn){
            preIndex++;
            node.right=trace(preorder,inorder,i+1,hiIn);
        }
        return node;
    }
    
    private int findindex(int []arr,int val){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==val)
                return i;
        }
        return arr.length;
    }
}
