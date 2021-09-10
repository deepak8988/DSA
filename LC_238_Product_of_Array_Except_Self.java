class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        
        int val=1;
        //prefix multiplication values
        for(int i=0;i<n;i++){
            ans[i]=val;
            val*=nums[i];
        }
        
        val=1;
        //suffix multiplication value
        for(int i=n-1;i>=0;i--){
            ans[i]*=val;
            val*=nums[i];
        }
        
        return ans;
        
    }
}
