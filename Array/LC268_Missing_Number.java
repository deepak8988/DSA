class Solution {
    public int missingNumber(int[] nums) {
        
        int ans=nums.length;
        
        for(int i=0;i<nums.length;i++){
            ans^=i;
            ans^=nums[i];
        }
        
        return ans;
        
    }
}

//another answer could be n*(n+1)/2-sum(array_elements)
