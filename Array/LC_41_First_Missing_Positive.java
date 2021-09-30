class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
          // element must first be checked to be in range [1,n] otherwise index out of bounds error will come
            while( nums[i]<=n && nums[i]>0 && nums[i]!=i+1 && nums[i]!=nums[nums[i]-1] ){
                int temp=nums[nums[i]-1]; //this swapping order also matters if we first replace nums[i]=nums[nums[i]-1] then it could be nums[i]=-1 and in next step index=-2 out of bounds may come
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;
            }
        }
        
        for(int i=0;i<n;i++){
            if(nums[i]!=i+1)
                return i+1;
        }
        
        return n+1;
        
    }
}
